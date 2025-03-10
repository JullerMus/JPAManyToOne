package org.example.jpamanytoone.Service;

import org.example.jpamanytoone.Model.Kommune;
import org.example.jpamanytoone.Repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner {

    private final RestTemplate restTemplate;
    private final KommuneRepository kommuneRepository;

    public ApiServiceGetKommunerImpl(RestTemplate restTemplate, KommuneRepository kommuneRepository) {
        this.restTemplate = restTemplate;
        this.kommuneRepository = kommuneRepository;
    }

    String KommuneUrl = "https://api.dataforsyningen.dk/kommuner";



    private void saveKommuner(List<Kommune> Kommuner) {
        Kommuner.forEach(kom -> kommuneRepository.save(kom));
    }

    @Override
    public List<Kommune> getKommuner(){
        List<Kommune> lst = new ArrayList<>();
        ResponseEntity<List<Kommune>> KommuneResponse =
                restTemplate.exchange(KommuneUrl,
                        HttpMethod.GET, null, new
                                ParameterizedTypeReference<List<Kommune>>(){
                                });
        List<Kommune> Kommuner = KommuneResponse.getBody();
        saveKommuner(Kommuner);
        return Kommuner;

    }

    @Override
    public List<String> getKommuneNames() {
        return kommuneRepository.findAll().stream().map(Kommune::getNavn).toList();
    }


}

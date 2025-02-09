package org.example.jpamanytoone.Service;

import org.example.jpamanytoone.Model.Kommune;
import org.example.jpamanytoone.Model.Region;
import org.example.jpamanytoone.Repository.KommuneRepository;
import org.example.jpamanytoone.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApiServiceGetRegionerImpl implements ApiServiceGetRegioner {

    private final RestTemplate restTemplate;
    private final RegionRepository regionRepository;
    private final KommuneRepository kommuneRepository;

    public ApiServiceGetRegionerImpl(RestTemplate restTemplate, RegionRepository regionRepository, KommuneRepository kommuneRepository) {
        this.restTemplate = restTemplate;
        this.regionRepository = regionRepository;
        this.kommuneRepository = kommuneRepository;
    }

    String regionUrl = "https://api.dataforsyningen.dk/regioner";

    private void saveRegioner(List<Region> regioner) {
        regioner.forEach(reg -> regionRepository.save(reg));
    }

    /**
     * Retrieves all regions from the URL
     * @return A list of all regions
     */
    @Override
    public List<Region> getRegioner(){
        List<Region> lst = new ArrayList<>();
        ResponseEntity<List<Region>> regionResponse =
                restTemplate.exchange(regionUrl,
                        HttpMethod.GET, null, new
                ParameterizedTypeReference<List<Region>>(){
                        });
        List<Region> regioner = regionResponse.getBody();
        saveRegioner(regioner);
        return regioner;

    }

    /**
     * Retrieves all regions from the database
     * @return A list of all regions
     */
    public List<Region> getRegionerDB(){
        List<Region> lst = new ArrayList<>(regionRepository.findAll());
        return lst;
    }

    @Override
    public List<String> getKommunerByRegion(Region regionKode){
        List<Kommune> kommunerByRegion = kommuneRepository.findAll().stream().filter(k -> k.getRegion().equals(regionKode)).toList();
        return kommunerByRegion.stream().map(Kommune::getNavn).toList();
    }



}

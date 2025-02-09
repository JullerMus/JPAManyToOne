package org.example.jpamanytoone.Service;

import org.example.jpamanytoone.Repository.RegionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceDeleteRegionerImpl implements ApiServiceDeleteRegioner {

    private final RestTemplate restTemplate;
    private final RegionRepository regionRepository;

    public ApiServiceDeleteRegionerImpl(RestTemplate restTemplate, RegionRepository regionRepository) {
        this.restTemplate = restTemplate;
        this.regionRepository = regionRepository;
    }

    @Override
    public String deleteAllRegioner() {
        regionRepository.deleteAll();
        return "Regioner deleted successfully";
    }
}

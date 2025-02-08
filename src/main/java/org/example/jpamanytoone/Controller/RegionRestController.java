package org.example.jpamanytoone.Controller;

import org.example.jpamanytoone.Model.Region;
import org.example.jpamanytoone.Repository.RegionRepository;
import org.example.jpamanytoone.Service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionRestController {


    private final ApiServiceGetRegioner apiServiceGetRegioner;

    public RegionRestController(ApiServiceGetRegioner apiServiceGetRegioner) {
        this.apiServiceGetRegioner = apiServiceGetRegioner;
    }


    /**
     * Retrieves all regions from the url
     * @return a list of regions
     */
    @GetMapping("/getregioner")
    public List<Region> getRegioner(){
        return apiServiceGetRegioner.getRegioner();
    }

    @GetMapping("/getregionerdb")
    public List<Region> getRegionerDB(){
        return apiServiceGetRegioner.getRegionerDB();
    }
}

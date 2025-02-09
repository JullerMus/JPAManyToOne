package org.example.jpamanytoone.Controller;

import org.example.jpamanytoone.Model.Kommune;
import org.example.jpamanytoone.Model.Region;
import org.example.jpamanytoone.Repository.RegionRepository;
import org.example.jpamanytoone.Service.ApiServiceDeleteRegioner;
import org.example.jpamanytoone.Service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RegionRestController {


    private final ApiServiceGetRegioner apiServiceGetRegioner;
    private final ApiServiceDeleteRegioner apiServiceDeleteRegioner;

    public RegionRestController(ApiServiceGetRegioner apiServiceGetRegioner, ApiServiceDeleteRegioner apiServiceDeleteRegioner) {
        this.apiServiceGetRegioner = apiServiceGetRegioner;
        this.apiServiceDeleteRegioner = apiServiceDeleteRegioner;
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

    @GetMapping("/deleteregioner")
    public String deleteRegioner() throws IOException {
        return apiServiceDeleteRegioner.deleteAllRegioner();

    }

    @GetMapping("/kommunenavne/{regionkode}")
    public List<String> getKommunenavne(@PathVariable Region regionkode){
        return apiServiceGetRegioner.getKommunerByRegion(regionkode);
    }
}

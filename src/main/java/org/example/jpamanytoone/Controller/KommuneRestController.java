package org.example.jpamanytoone.Controller;

import org.example.jpamanytoone.Model.Kommune;
import org.example.jpamanytoone.Service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KommuneRestController {


    private final ApiServiceGetKommuner apiServiceGetKommuner;

    public KommuneRestController(ApiServiceGetKommuner apiServiceGetKommuner) {
        this.apiServiceGetKommuner = apiServiceGetKommuner;
    }

    @GetMapping("/getkommuner")
    public List<Kommune> getKommuner() {
        return apiServiceGetKommuner.getKommuner();
    }

    @GetMapping("/getkommunenames")
    public List<String>  getKommuneNames() {
        return apiServiceGetKommuner.getKommuneNames();
    }

}

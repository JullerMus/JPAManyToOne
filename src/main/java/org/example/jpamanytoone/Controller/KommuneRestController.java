package org.example.jpamanytoone.Controller;

import org.example.jpamanytoone.Model.Kommune;
import org.example.jpamanytoone.Service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KommuneRestController {

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @GetMapping("/getkommuner")
    public List<Kommune> getKommuner() {
        return apiServiceGetKommuner.getKommuner();
    }

}

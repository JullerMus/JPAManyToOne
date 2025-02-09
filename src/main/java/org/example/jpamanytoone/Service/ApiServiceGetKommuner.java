package org.example.jpamanytoone.Service;

import org.example.jpamanytoone.Model.Kommune;

import java.util.List;

public interface ApiServiceGetKommuner {
    List<Kommune> getKommuner();
    List<String> getKommuneNames();
}

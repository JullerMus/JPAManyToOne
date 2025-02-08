package org.example.jpamanytoone.Service;

import org.example.jpamanytoone.Model.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApiServiceGetRegioner {
    List<Region> getRegioner();
}

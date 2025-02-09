package org.example.jpamanytoone.Repository;

import org.example.jpamanytoone.Model.Kommune;
import org.example.jpamanytoone.Model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KommuneRepository extends JpaRepository<Kommune, Long> {

    List<Kommune> findByRegion(Region region);
}

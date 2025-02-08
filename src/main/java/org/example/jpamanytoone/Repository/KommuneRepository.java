package org.example.jpamanytoone.Repository;

import org.example.jpamanytoone.Model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommuneRepository extends JpaRepository<Kommune, Long> {
}

package com.ipiecoles.java.java230.Repository;

import com.ipiecoles.java.java230.model.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {

    List<Technicien>findByGradeBetween(Integer grade1, Integer grade2);
}

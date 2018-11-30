package com.ipiecoles.java.java230.Repository;

import com.ipiecoles.java.java230.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.joda.time.LocalDate;
import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe,Long> {

    Employe findByMatricule(String matricule);
    List<Employe> findByNomAndPrenom(String nom, String prenom);
    List<Employe> findByNomIgnoreCase(String nom);
    List<Employe> findByDateEmbaucheBefore(LocalDate date);
    List<Employe> findByDateEmbaucheAfter(LocalDate date);
    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc(Integer salaire);

}


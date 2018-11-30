package com.ipiecoles.java.java230.Repository;

import com.ipiecoles.java.java230.model.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.joda.time.LocalDate;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe,Long> {

    Employe findByMatricule(String matricule);
    List<Employe> findByNomAndPrenom(String nom, String prenom);
    List<Employe> findByNomIgnoreCase(String nom);
    List<Employe> findByDateEmbaucheBefore(LocalDate date);
    List<Employe> findByDateEmbaucheAfter(LocalDate date);
    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);
    Page<Employe> findByNomIgnoreCase(String nom, Pageable pageable);

    //public class findByNomOrPrenomAllIgnoreCase(String nomOuPrenom){}

    @Query(value = "SELECT e FROM Employe e WHERE e.salaire > (SELECT avg(e2.salaire) FROM Employe e2)")
    List<Employe> findEmployePlusRiches();

    @Query(value = "SELECT count(e) FROM Employe e WHERE e.salaire > (SELECT avg(e2.salaire) FROM Employe e2)")
    long countEmployePlusRiches();

    //@Query(value = "SELECT e FROM Employe e WHERE lower(e.nom) = lower(:nomOuPrenom) OR lower(e.prenom) = lower(:nomOuPrenom)", nativeQuery = true);
    //List<Employe>findByNomOrPrenomAllIgnoreCase(@Param("nomOuPrenom") String nomOuPrenom);

    @Query(value = "select * from Employe e where lower(e.prenom) = lower(:nOuP) or lower(e.nom) = lower(:nOuP)", nativeQuery = true)
    List<Employe>findByNomOrPrenomAllIgnoreCase(@Param("nOuP") String nomOuPrenom);

    }







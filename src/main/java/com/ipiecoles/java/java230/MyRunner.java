package com.ipiecoles.java.java230;
import com.ipiecoles.java.java230.model.Technicien;
import org.joda.time.LocalDate;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.Repository.EmployeRepository;
import com.ipiecoles.java.java230.Repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private TechnicienRepository technicienRepository;


    @Override
    public void run(String... strings) throws Exception {
        //Read
        //Employe e = employeRepository.findOne((long) 5);
        //System.out.println(e.getNom());
        //System.out.println(e.getPrenom());
        //System.out.println(e.getMatricule());
        //System.out.println(e);

        //create
        //Employe employe = new Employe("Doe", "John","X66666", LocalDate.now(), 2000.0);
        //System.out.println(employe.getId());//null
        //employe = employeRepository.save(employe);
        //System.out.println(employe.getId());

        //update
        //employe.setMatricule("X66667");
        //employe = employeRepository.save(employe);

        //List<Employe> employes = employeRepository.findAll(new Sort(Sort.Direction.ASC,"dateEmbauche","salaire"));
        //for (Employe emp: employes){
        //      System.out.println(emp);
        //}


        //Page<Employe> employes = employeRepository.findAll(new PageRequest(1,15,Sort.Direction.ASC,"dateEmbauche"));
        //System.out.println("Nb employés : " + employes.getTotalElements());
        //System.out.println("Nb pages : " + employes.getTotalPages());
        //for (Employe emp: employes){
        //      System.out.println(emp);
        //}

        Employe employe1 = employeRepository.findByMatricule("M00001");
            System.out.println(employe1);

        //
        //long e2 = employeRepository.countEmployePlusRiches();
        //List<Employe> e = employeRepository.findEmployePlusRiches();
        //Page<Employe> p = employeRepository.findByNomIgnoreCase("bArrE",new PageRequest(0,5));
        Page<Employe> e = employeRepository.findAll(new PageRequest(0,10));
            for(Employe emp: e) {
                System.out.println(employe1.getPrimeAnnuelle());
                if(emp instanceof Technicien){
                    ((Technicien)emp).getGrade();
                }
                System.out.println(emp);
            }

        List<Technicien> techniciens = technicienRepository.findByGradeBetween(2,4);
            for (Technicien technicien : techniciens){
                System.out.println(technicien);
            }
    }

    public static void print(Object t) {
        System.out.println(t);
    }
}

package com.mix.avion.controller;

import com.mix.avion.model.Assurancedetail;
import com.mix.avion.repository.AssurancedetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

public class AssuranceAvionController {
    @Autowired
    AssurancedetailRepository assurancedetailRepository;

    @GetMapping("/dia")
    public String getStuff(){
        return "OK";
    }



//    Ny ray Atao 3 mois dia ny ray atao 1 mois
    @GetMapping("/AssuranceAvion/{nombreMois}")
    public ResponseEntity<List<Assurancedetail>> getListe(@PathVariable int nombreMois){
        try {
//            System.out.println("date = " + LocalDate.parse(to, formatter));
            LocalDate dateDebut = LocalDate.now().plusMonths(nombreMois);
            LocalDate dateFin = LocalDate.now();

            System.out.println(dateDebut);
            System.out.println(dateFin);

            List<Assurancedetail> assurance = new ArrayList<Assurancedetail>();
            System.out.println("test1 size = " + assurancedetailRepository.getAssurancedetailsByDateFinValiditeBetween(Timestamp.valueOf(dateFin.atTime(LocalTime.MIDNIGHT)),Timestamp.valueOf(dateDebut.atTime(LocalTime.MIDNIGHT))).size());
            assurancedetailRepository.getAssurancedetailsByDateFinValiditeBetween(Timestamp.valueOf(dateFin.atTime(LocalTime.MIDNIGHT)),Timestamp.valueOf(dateDebut.atTime(LocalTime.MIDNIGHT))).forEach(assurance::add);

            System.out.println("test2");
            System.out.println("assurance" + assurance.size());
            if (assurance.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(assurance, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

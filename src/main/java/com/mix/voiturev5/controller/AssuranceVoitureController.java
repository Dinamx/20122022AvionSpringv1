package com.mix.voiturev5.controller;

import com.mix.voiturev5.model.Assurancevoiture;
import com.mix.voiturev5.model.Kilometrage;
import com.mix.voiturev5.repository.AssurancevoitureRepository;
import com.mix.voiturev5.repository.KilometrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin
public class AssuranceVoitureController {
    @Autowired
    AssurancevoitureRepository assurancevoitureRepository;

    @GetMapping("/dia")
    public String getStuff(){
        return "OK";
    }



//    Ny ray Atao 3 mois dia ny ray atao 1 mois
    @GetMapping("/Assurancevoiture/{nombreMois}")
    public ResponseEntity<List<Assurancevoiture>> getListe(@PathVariable int nombreMois){
        try {
//            System.out.println("date = " + LocalDate.parse(to, formatter));
            LocalDate dateDebut = LocalDate.now().plusMonths(nombreMois);
            LocalDate dateFin = LocalDate.now();

            System.out.println(dateDebut);
            System.out.println(dateFin);

            List<Assurancevoiture> assurance = new ArrayList<Assurancevoiture>();
            assurancevoitureRepository.getAssurancevoitureByDateFinValiditeBetween(Timestamp.valueOf(dateFin.atTime(LocalTime.MIDNIGHT)),Timestamp.valueOf(dateDebut.atTime(LocalTime.MIDNIGHT))).forEach(assurance::add);
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

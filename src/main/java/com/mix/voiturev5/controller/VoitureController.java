package com.mix.voiturev5.controller;

import com.mix.voiturev5.model.Voiture;
import com.mix.voiturev5.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class VoitureController {
    @Autowired
    VoitureRepository voitureRepository;

    @GetMapping("/voitures")
//    public ResponseEntity<> getAllVoitures(@RequestParam(required = false) String title) {
    public ResponseEntity<List<Voiture>> getAllVoitures(@RequestParam(required = false) String title) {
        try {
            List<Voiture> voiture = new ArrayList<Voiture>();

            if (title == null)
                voitureRepository.findAll().forEach(voiture::add);
            if (voiture.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(voiture, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/voitures")
    public ResponseEntity<Voiture> insertVoiture(@RequestBody Voiture v) {
        try {
            voitureRepository.save(v);
            return new ResponseEntity<>(v, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/OK")
    public String getTruc(HttpServletRequest request){
        System.out.println("ok");
        String let1 = request.getParameter("let1");
        String let2 = request.getParameter("let2");
        System.out.println("ok" + let1);
        System.out.println("ok" + let2);
        return let1+let2;
    }

    @GetMapping("/OK")
    public String kok(){
        return "ok";
    }

}

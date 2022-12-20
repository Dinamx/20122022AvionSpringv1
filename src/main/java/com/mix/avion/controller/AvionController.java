package com.mix.avion.controller;


import com.mix.avion.model.Avion;
import com.mix.avion.repository.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AvionController {
    @Autowired
    AvionRepository avionrepository;

    @GetMapping("/avions")
//    public ResponseEntity<> getAllVoitures(@RequestParam(required = false) String title) {
    public ResponseEntity<List<Avion>> getAllVoitures(@RequestParam(required = false) String title) {
        try {
            List<Avion> voiture = new ArrayList<Avion>();

            if (title == null)
                avionrepository.findAll().forEach(voiture::add);
            if (voiture.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(voiture, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/avions")
    public ResponseEntity<Avion> insertVoiture(@RequestBody Avion v) {
        try {
            avionrepository.save(v);
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


// Forme anle zaavtra ho alefa
//    {
//        "id": 1,
//        "imageavion": "mix.jpg"
//    }

    @PostMapping("/avions/image")
    public ResponseEntity<Avion> updateImage(@RequestBody Avion v) {
        try {
            System.out.println("Id " + v.getId() );
            Avion temp = avionrepository.findAvionById(v.getId());
            temp.setImageavion(v.getImageavion());

            avionrepository.save(temp);
            System.out.println("Image " + temp.getImageavion());


//            avionrepository.save(v);
            return new ResponseEntity<>(temp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

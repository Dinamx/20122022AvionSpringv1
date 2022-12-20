package com.mix.avion.controller;


import com.mix.avion.model.Kilometragedetail;
import com.mix.avion.repository.KilometragedetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
public class KilometrageController {
    @Autowired
    KilometragedetailRepository kilometrageRepository;

    @GetMapping("/kilometrages/{id}")
    public ResponseEntity<List<Kilometragedetail>> getListe(@PathVariable int id){
//    public ResponseEntity<List<Kilometrage>> getListe(@RequestParam(required = false) int idTrux){
        try {
//            String id = String.valueOf(idTrux);
            System.out.println("id = " + id);
            List<Kilometragedetail> kilometrage = new ArrayList<Kilometragedetail>();
            if (String.valueOf(id) == null)
//                System.out.println("id null");
                kilometrageRepository.findAll().forEach(kilometrage::add);
            else
                System.out.println("id not null" + id);
            kilometrageRepository.findByIdavion(id).forEach(kilometrage::add);
            if (kilometrage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(kilometrage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

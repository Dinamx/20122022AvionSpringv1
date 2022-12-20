package com.mix.avion.repository;

import com.mix.avion.model.Assurancedetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface AssurancedetailRepository extends JpaRepository<Assurancedetail, Integer> {
//    List<Assurancedetail> getAssurancevoitureByDateFinValiditeBetween(Timestamp debut, Timestamp fin);
    List<Assurancedetail> getAssurancedetailsByDateFinValiditeBetween(Timestamp debut, Timestamp fin);


//    List<Assurancedetail>


}
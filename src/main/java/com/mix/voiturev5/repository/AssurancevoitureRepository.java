package com.mix.voiturev5.repository;

import com.mix.voiturev5.model.Assurancevoiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface AssurancevoitureRepository extends JpaRepository<Assurancevoiture, Integer> {

    public List<Assurancevoiture> getAssurancevoitureByDateFinValiditeBetween(Timestamp to, Timestamp from);
}
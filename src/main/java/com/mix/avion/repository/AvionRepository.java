package com.mix.avion.repository;

import com.mix.avion.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, Integer> {
    Avion findById(int id);
    Avion findAvionById(int id);




}
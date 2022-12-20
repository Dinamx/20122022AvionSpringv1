package com.mix.voiturev5.repository;

import com.mix.voiturev5.model.Kilometrage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KilometrageRepository extends JpaRepository<Kilometrage, Integer> {
    public List<Kilometrage> findByIdvoiture(int id);
}
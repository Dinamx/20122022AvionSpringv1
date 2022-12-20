package com.mix.avion.repository;

import com.mix.avion.model.Kilometragedetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KilometragedetailRepository extends JpaRepository<Kilometragedetail, Integer> {
    List<Kilometragedetail> findByIdavion(int id);
}
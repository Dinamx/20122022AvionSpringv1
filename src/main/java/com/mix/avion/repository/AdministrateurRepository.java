package com.mix.avion.repository;

import com.mix.avion.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {
    List<Administrateur> findByEmailAndPsswd(String email,String psswd);
}
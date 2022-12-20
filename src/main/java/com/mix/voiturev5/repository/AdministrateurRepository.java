package com.mix.voiturev5.repository;

import com.mix.voiturev5.model.Administrateur;
import com.mix.voiturev5.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {
    List<Administrateur> findByEmailAndPsswd(String email,String psswd);

}
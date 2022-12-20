package com.mix.voiturev5.repository;

import com.mix.voiturev5.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Integer> {

}

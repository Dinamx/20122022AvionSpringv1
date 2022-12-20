package com.mix.voiturev5.repository;

import com.mix.voiturev5.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
}
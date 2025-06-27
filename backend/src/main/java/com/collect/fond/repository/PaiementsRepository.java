package com.collect.fond.repository;

import com.collect.fond.domain.Paiements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementsRepository extends JpaRepository<Paiements, Integer> {
}

package com.collect.fond.repository;

import com.collect.fond.domain.Membres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MembresRepository extends JpaRepository<Membres, Long> {
    Optional<Membres> findByTelephone(String telephone);

}

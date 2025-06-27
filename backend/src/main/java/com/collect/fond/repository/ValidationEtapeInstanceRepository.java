package com.collect.fond.repository;

import com.collect.fond.domain.ValidationEtapeInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValidationEtapeInstanceRepository extends JpaRepository<ValidationEtapeInstance, Long> {

    List<ValidationEtapeInstance> findByTypeDemandeAndIdDemande(String typeDemande, Long idDemande);
}

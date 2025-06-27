package com.collect.fond.repository;

import com.collect.fond.domain.CelebrationMariage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CelebrationMariageRepository extends JpaRepository<CelebrationMariage, Long> {

    List<CelebrationMariage> findByIdUtilisateurDemande(Long idUtilisateurDemande);

    List<CelebrationMariage> findByStatut(String statut);
}

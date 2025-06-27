package com.collect.fond.facade;

import com.collect.fond.domain.CelebrationMariage;
import com.collect.fond.domain.ValidationEtapeConfig;
import com.collect.fond.presentation.dto.CelebrationMariageDto;
import com.collect.fond.repository.CelebrationMariageRepository;
import com.collect.fond.repository.MarieRepository;
import com.collect.fond.repository.ValidationEtapeInstanceRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CelebrationMariageFacade {

    private final CelebrationMariageRepository celebrationMariageRepository;
    private final MarieRepository marieRepository;
    private final EntityManager entityManager;
    private final ValidationEtapeInstanceRepository validationEtapeInstanceRepository;

    public CelebrationMariageFacade(EntityManager entityManager,
                                    CelebrationMariageRepository celebrationMariageRepository,
                                    MarieRepository marieRepository,
                                    ValidationEtapeInstanceRepository validationEtapeInstanceRepository) {
        this.celebrationMariageRepository = celebrationMariageRepository;
        this.marieRepository = marieRepository;
        this.entityManager = entityManager;
        this.validationEtapeInstanceRepository = validationEtapeInstanceRepository;
    }

    @Transactional
    public CelebrationMariageDto recuperer(Long id) {
        CelebrationMariage result = this.celebrationMariageRepository.getById(id);
        CelebrationMariageDto resultDto = new CelebrationMariageDto(result) ;
        resultDto.setEtapes(
                validationEtapeInstanceRepository.findByTypeDemandeAndIdDemande(
                        "CELEBRATION_MARIAGE",
                        resultDto.getId()
                )
        );
        return resultDto;
    }

    @Transactional
    public void enregistrer(CelebrationMariageDto celebrationMariageDto) {
        CelebrationMariage demande = new CelebrationMariage(celebrationMariageDto);
        celebrationMariageRepository.save(demande);
        List<ValidationEtapeConfig> etapesConfig = (List<ValidationEtapeConfig>)
            entityManager.createQuery(
                    "select e FROM ValidationEtapeConfig e WHERE e.typeDemande = 'CELEBRATION_MARIAGE'"
            ).getResultList();
        LocalDate dateDebut = LocalDate.now();
        for(int i=0; i<etapesConfig.stream().count(); i++)  {
            ValidationEtapeConfig cfg = etapesConfig.get(i);
            String statut = "NON_DEMARRE";
            if(i == 0) {
                statut = "TERMINE";
            }
            else if(i == 1) {
                statut = "EN_COURS";
            }
            LocalDate dateDebutEtp = dateDebut;
            LocalDate dateFinEtp = dateDebutEtp.plusDays(cfg.getDelaiJours());
            dateDebut = dateFinEtp;
            entityManager.createNativeQuery("""
INSERT INTO public.validation_etape_instance(
id_demande, id_config, type_demande, numero_etape, nom_etape, statut, evenement_succes, date_debut, delai_jours, date_prevision)
VALUES (:p01, :p02, :p03, :p04, :p05, :p06, :p07, :p08, :p09, :p10)""")
                    .setParameter("p01", demande.getId())
                    .setParameter("p02", cfg.getId())
                    .setParameter("p03", "CELEBRATION_MARIAGE")
                    .setParameter("p04", cfg.getNumeroEtape())
                    .setParameter("p05", cfg.getNomEtape())
                    .setParameter("p06", statut)
                    .setParameter("p07", cfg.getEvenementSucces())
                    .setParameter("p08", dateDebutEtp)
                    .setParameter("p09", cfg.getDelaiJours())
                    .setParameter("p10", dateFinEtp)
                    .executeUpdate()
            ;
        }
    }


    @Transactional
    public List<CelebrationMariageDto> lister() {
        return celebrationMariageRepository.findAll()
                .stream()
                .map(CelebrationMariageDto::new)
                .toList();
    }

}

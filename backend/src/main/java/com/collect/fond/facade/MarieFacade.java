package com.collect.fond.facade;

import com.collect.fond.domain.Marie;
import com.collect.fond.presentation.dto.MarieDto;
import com.collect.fond.repository.MarieRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Comparator.comparing;

@Service
public class MarieFacade {

  private final MarieRepository marieRepository;

    public MarieFacade(MarieRepository marieRepository) {
        this.marieRepository = marieRepository;
    }

    @Transactional
    public void enregistrer(MarieDto dto) {
        Marie marie = new Marie(
                dto.getNom(),
                dto.getPrenoms(),
                dto.getTelephone(),
                dto.getDateNaissance(),
                dto.getLieuNaissance(),
                dto.getProfession(),
                dto.getPere(),
                dto.getMere(),
                dto.getDomicile(),
                dto.getType()
        );
        marieRepository.save(marie);
    }

    @Transactional
    public void mettreAJour(Long id, MarieDto dto) {
        Marie marie = marieRepository.findById(id).orElseThrow();
        marie.mettreAJour(dto.getNom(), dto.getPrenoms(), dto.getTelephone(),
                dto.getDateNaissance(), dto.getLieuNaissance(), dto.getProfession(),
                dto.getPere(), dto.getMere(), dto.getDomicile(), dto.getType());
    }

    @Transactional
    public void supprimer(Long id) {
        marieRepository.deleteById(id);
    }

    @Transactional
    public List<MarieDto> lister() {
        return marieRepository.findAll()
                .stream()
                .map(MarieDto::new)
                .sorted(comparing(MarieDto::getNom, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(MarieDto::getPrenoms, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }
}

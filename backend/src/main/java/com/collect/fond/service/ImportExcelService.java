package com.collect.fond.service;

import com.collect.fond.domain.Membres;
import com.collect.fond.domain.Paiements;
import com.collect.fond.repository.MembresRepository;
import com.collect.fond.repository.PaiementsRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

@Service
public class ImportExcelService {

    private static final Logger log = LoggerFactory.getLogger(ImportExcelService.class);

    private final MembresRepository membresRepository;
    private final PaiementsRepository paiementsRepository;

    public ImportExcelService(MembresRepository membresRepository, PaiementsRepository paiementsRepository) {
        this.membresRepository = membresRepository;
        this.paiementsRepository = paiementsRepository;
    }

    @Transactional
    public String importExcel(MultipartFile file) {
        try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
            int numberOfSheets = workbook.getNumberOfSheets();
            int totalPaiements = 0;

            Map<String, Month> monthMap = new HashMap<>() {{
                put("JANVIER", Month.JANUARY);
                put("FEVRIER", Month.FEBRUARY);
                put("MARS", Month.MARCH);
                put("AVRIL", Month.APRIL);
                put("MAI", Month.MAY);
                put("JUIN", Month.JUNE);
                put("JUILLET", Month.JULY);
                put("AOUT", Month.AUGUST);
                put("SEPTEMBRE", Month.SEPTEMBER);
                put("OCTOBRE", Month.OCTOBER);
                put("NOVEMBRE", Month.NOVEMBER);
                put("DECEMBRE", Month.DECEMBER);
            }};

            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                String formule = sheet.getSheetName().trim().toUpperCase(Locale.ROOT);
                log.info("Traitement de la feuille: {}", formule);

                Row headerRow = sheet.getRow(0);
                Map<Integer, String> headerMap = new HashMap<>();
                if (headerRow != null) {
                    for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                        Cell cell = headerRow.getCell(j);
                        if (cell != null) {
                            headerMap.put(j, cell.getStringCellValue().trim().toUpperCase(Locale.ROOT));
                        }
                    }
                }

                Map<String, String> fieldMapping = new HashMap<>();
                fieldMapping.put("NOM ET PRENOMS", "nomEtPrenom");
                fieldMapping.put("NOM ET PRÉNOMS", "nomEtPrenom");
                fieldMapping.put("CONTACT", "telephone");

                for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) continue;

                    String nomEtPrenom = getCellValue(row.getCell(findColumnIndex(headerMap, fieldMapping, "nomEtPrenom")));
                    String[] nomPrenom = splitNomPrenom(nomEtPrenom);
                    String nom = nomPrenom[0];
                    String prenoms = nomPrenom[1];

                    String telephone = getCellValue(row.getCell(findColumnIndex(headerMap, fieldMapping, "telephone")));
                    if (telephone.isEmpty()) continue;

                    Membres membre = membresRepository.findByTelephone(telephone)
                            .orElseGet(() -> {
                                Membres m = new Membres();
                                m.setNom(nom);
                                m.setPrenoms(prenoms);
                                m.setTelephone(telephone);
                                m.setFormule(formule);
                                m.setDateInscription(LocalDateTime.now());
                                return membresRepository.save(m);
                            });

                    for (Map.Entry<Integer, String> entry : headerMap.entrySet()) {
                        String header = entry.getValue();
                        if (monthMap.containsKey(header)) {
                            Cell monthCell = row.getCell(entry.getKey());
                            String montantStr = getCellValue(monthCell);
                            if (!montantStr.isEmpty()) {
                                try {
                                    Long montant = (long) Double.parseDouble(montantStr);
                                    if (montant > 0) {
                                        LocalDate datePaiement = LocalDate.of(2025, monthMap.get(header), 1);

                                        Paiements paiement = new Paiements();
                                        paiement.setMembre(membre);
                                        paiement.setMontant(montant);
                                        paiement.setDatePaiement(datePaiement.atStartOfDay());
                                        paiement.setInfo("Import " + header + " feuille: " + formule);
                                        paiementsRepository.save(paiement);
                                        totalPaiements++;
                                    }
                                } catch (NumberFormatException e) {
                                    log.warn("Montant invalide ligne {} colonne {}: {}", j + 1, header, montantStr);
                                }
                            }
                        }
                    }
                }
            }
            return "Import terminé avec " + totalPaiements + " paiements enregistrés.";
        } catch (Exception e) {
            log.error("Erreur lors de l'import Excel: {}", e.getMessage());
            return "Erreur: " + e.getMessage();
        }
    }

    private int findColumnIndex(Map<Integer, String> headerMap, Map<String, String> fieldMapping, String fieldKey) {
        for (Map.Entry<Integer, String> entry : headerMap.entrySet()) {
            String normalized = entry.getValue().trim().toUpperCase(Locale.ROOT);
            if (fieldMapping.containsKey(normalized) && fieldMapping.get(normalized).equals(fieldKey)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private String[] splitNomPrenom(String nomEtPrenom) {
        if (nomEtPrenom == null || nomEtPrenom.trim().isEmpty()) {
            return new String[]{"", ""};
        }
        String[] parts = nomEtPrenom.split("\\s+", 2);
        if (parts.length == 1) {
            return new String[]{parts[0], ""};
        }
        return parts;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();
            case NUMERIC -> String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            default -> "";
        };
    }
}

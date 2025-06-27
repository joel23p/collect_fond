package com.collect.fond.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateEnLettres {

    private static final String[] MOIS = {
            "", "janvier", "février", "mars", "avril", "mai", "juin",
            "juillet", "août", "septembre", "octobre", "novembre", "décembre"
    };

    public static String dateEnLettres(LocalDate date) {
        int jour = date.getDayOfMonth();
        int mois = date.getMonthValue();
        int annee = date.getYear();

        return nombreEnLettres(jour) + " " +
                MOIS[mois] + " " +
                nombreEnLettres(annee);
    }
    public static String dateEnLettres(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int jour = cal.get(Calendar.DAY_OF_MONTH);
        int mois = cal.get(Calendar.MONTH) + 1;
        int annee = cal.get(Calendar.YEAR);
        int heure = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        return nombreEnLettres(jour) + " " +
                MOIS[mois] + " " +
                nombreEnLettres(annee) + " à " +
                nombreEnLettres(heure) + " heure" + (heure > 1 ? "s" : "") +
                (minute > 0 ? " " + nombreEnLettres(minute) : "");
    }
    public static String dateEnLettres(LocalDateTime dateTime) {
        int jour = dateTime.getDayOfMonth();
        int mois = dateTime.getMonthValue();
        int annee = dateTime.getYear();
        int heure = dateTime.getHour();
        int minute = dateTime.getMinute();

        return nombreEnLettres(jour) + " " +
                MOIS[mois] + " " +
                nombreEnLettres(annee) + " à " +
                nombreEnLettres(heure) + " heure" + (heure > 1 ? "s" : "") +
                (minute > 0 ? " " + nombreEnLettres(minute) : "");
    }

    // Réutilise la fonction de conversion en lettres précédente
    public static String nombreEnLettres(int n) {
        // Simplifié ici — tu peux remplacer par la version complète si besoin
        // pour gérer jusqu'à 999999
        // (voir la réponse précédente)
        String[] UNITS = {
                "", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf",
                "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize",
                "dix-sept", "dix-huit", "dix-neuf"
        };
        String[] TENS = {
                "", "", "vingt", "trente", "quarante", "cinquante", "soixante"
        };

        if (n < 20) return UNITS[n];
        if (n < 70) {
            int dizaine = n / 10;
            int unite = n % 10;
            return TENS[dizaine] + (unite == 1 ? " et un" : (unite > 0 ? "-" + UNITS[unite] : ""));
        }
        if (n < 80) return "soixante-" + nombreEnLettres(n - 60);
        if (n < 100) return "quatre-vingt" + (n == 80 ? "s" : "-" + nombreEnLettres(n - 80));
        if (n < 1000) {
            int centaine = n / 100;
            int reste = n % 100;
            String cent = (centaine == 1 ? "cent" : UNITS[centaine] + " cent");
            if (reste == 0 && centaine > 1) cent += "s";
            return cent + (reste > 0 ? " " + nombreEnLettres(reste) : "");
        }
        if (n < 1000000) {
            int mille = n / 1000;
            int reste = n % 1000;
            String milleStr = (mille == 1 ? "mil" : nombreEnLettres(mille) + " mil");
            return milleStr + (reste > 0 ? " " + nombreEnLettres(reste) : "");
        }
        return String.valueOf(n); // fallback
    }
}
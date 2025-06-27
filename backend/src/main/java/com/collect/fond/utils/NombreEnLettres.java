package com.collect.fond.utils;

public class NombreEnLettres {

    private static final String[] UNITS = {
            "", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf",
            "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize",
            "dix-sept", "dix-huit", "dix-neuf"
    };

    private static final String[] TENS = {
            "", "", "vingt", "trente", "quarante", "cinquante",
            "soixante", "soixante", "quatre-vingt", "quatre-vingt"
    };

    public static String convertir(int n) {
        if (n == 0) return "zéro";
        if (n < 0) return "moins " + convertir(-n);

        return convertirNombre(n).trim();
    }

    private static String convertirNombre(int n) {
        if (n < 20) {
            return UNITS[n];
        } else if (n < 100) {
            int dizaine = n / 10;
            int unite = n % 10;
            String sep = (dizaine == 7 || dizaine == 9) ? "-" : (unite == 1 && dizaine != 8 ? " et " : "-");
            int base = (dizaine == 7 || dizaine == 9) ? 10 : 0;
            return TENS[dizaine] + (unite > 0 ? sep + UNITS[unite + base] : (dizaine == 8 ? "s" : ""));
        } else if (n < 1000) {
            int centaine = n / 100;
            int reste = n % 100;
            String cent = (centaine == 1 ? "cent" : UNITS[centaine] + " cent");
            if (reste == 0 && centaine > 1) cent += "s";
            return cent + (reste > 0 ? " " + convertirNombre(reste) : "");
        } else if (n < 1000000) {
            int mille = n / 1000;
            int reste = n % 1000;
            String milleStr = (mille == 1 ? "mil" : convertirNombre(mille) + " mil");
            return milleStr + (reste > 0 ? " " + convertirNombre(reste) : "");
        }

        return "(Nombre trop grand)";
    }
}
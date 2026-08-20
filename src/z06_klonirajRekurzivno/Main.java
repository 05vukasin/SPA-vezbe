package z06_klonirajRekurzivno;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z06 klonirajRekurzivno ===");

        oceni("prazna lista",          "prazna | deep=true | origOcuvan=true | novaGlava=true",        klon(new int[]{}));
        oceni("jedan element",         "1 | deep=true | origOcuvan=true | novaGlava=true",             klon(new int[]{1}));
        oceni("dva elementa",          "1 -> 2 | deep=true | origOcuvan=true | novaGlava=true",        klon(new int[]{1, 2}));
        oceni("tri (primer)",          "1 -> 2 -> 3 | deep=true | origOcuvan=true | novaGlava=true",   klon(new int[]{1, 2, 3}));
        oceni("duplikati vrednosti",   "5 -> 5 -> 5 | deep=true | origOcuvan=true | novaGlava=true",   klon(new int[]{5, 5, 5}));
        oceni("negativne vrednosti",   "-1 -> -2 -> -3 | deep=true | origOcuvan=true | novaGlava=true", klon(new int[]{-1, -2, -3}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String klon(int[] vrednosti) {
        try {
            JSLista lista = new JSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            String origPre = lista.ispis();
            CJSL kl = lista.klonirajRekurzivno(lista.prvi);
            String seq = AJSLista.ispisOd(kl);
            String origPost = lista.ispis();
            boolean deep = jeDubokaKopija(lista.prvi, kl);
            boolean novaGlava = (lista.prvi == null) ? (kl == null) : (kl != null && kl != lista.prvi);
            return seq + " | deep=" + deep + " | origOcuvan=" + origPre.equals(origPost)
                    + " | novaGlava=" + novaGlava;
        } catch (Exception e) {
            return e.getClass().getSimpleName();
        }
    }

    // isti podaci, ali svaki par cvorova mora biti RAZLICIT objekat
    private static boolean jeDubokaKopija(CJSL orig, CJSL klon) {
        while (orig != null && klon != null) {
            if (orig == klon) return false;              // isti objekat -> nije duboka
            if (orig.podatak != klon.podatak) return false;
            orig = orig.sledeci;
            klon = klon.sledeci;
        }
        return orig == null && klon == null;             // ista duzina
    }

    static void oceni(String naziv, String ocekivano, String dobijeno) {
        ukupno++;
        boolean ok = ocekivano.equals(dobijeno);
        if (ok) proslo++;
        System.out.println((ok ? "  [PASS] " : "  [FAIL] ") + naziv
                + "   ->  ocekivano: " + ocekivano + " | dobijeno: " + dobijeno);
    }
}

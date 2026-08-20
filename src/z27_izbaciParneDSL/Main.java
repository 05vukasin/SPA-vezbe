package z27_izbaciParneDSL;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z27 izbaciParne ===");

        // Format rezultata: "<napred preko sledeci> || <unazad preko prethodni>"
        oceni("parni na pocetku",  "1 3 || 3 1",            izbaci(new int[]{2, 1, 3}));
        oceni("parni na kraju",    "1 3 || 3 1",            izbaci(new int[]{1, 3, 4}));
        oceni("paran u sredini",   "1 3 || 3 1",            izbaci(new int[]{1, 2, 3}));
        oceni("svi parni -> prazna"," || ",                 izbaci(new int[]{2, 4, 6}));
        oceni("nijedan paran",     "1 3 5 || 5 3 1",        izbaci(new int[]{1, 3, 5}));
        oceni("prazna lista",      " || ",                  izbaci(new int[]{}));
        oceni("negativni i nula",  "-3 -5 || -5 -3",        izbaci(new int[]{-2, -3, -4, -5, 0}));
        oceni("jedan paran",       " || ",                  izbaci(new int[]{4}));
        oceni("jedan neparan",     "7 || 7",                izbaci(new int[]{7}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String izbaci(int[] vrednosti) {
        try {
            DSLista lista = new DSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            lista.izbaciParne();
            return lista.sekvenca() + " || " + lista.sekvencaUnazad();
        } catch (Exception e) {
            return e.getClass().getSimpleName();
        }
    }

    static void oceni(String naziv, String ocekivano, String dobijeno) {
        ukupno++;
        boolean ok = ocekivano.equals(dobijeno);
        if (ok) proslo++;
        System.out.println((ok ? "  [PASS] " : "  [FAIL] ") + naziv
                + "   ->  ocekivano: " + ocekivano + " | dobijeno: " + dobijeno);
    }
}

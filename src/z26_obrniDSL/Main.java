package z26_obrniDSL;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z26 obrniDSL ===");

        // Format rezultata: "<napred preko sledeci> || <unazad preko prethodni>"
        // (proverava i vrednosti i konzistentnost prev/next pokazivaca)
        oceni("prazna",            " || ",                       obrni(new int[]{}));
        oceni("jedan element",     "42 || 42",                   obrni(new int[]{42}));
        oceni("dva elementa",      "20 10 || 10 20",             obrni(new int[]{10, 20}));
        oceni("cetiri elementa",   "40 30 20 10 || 10 20 30 40", obrni(new int[]{10, 20, 30, 40}));
        oceni("pet elemenata",     "5 4 3 2 1 || 1 2 3 4 5",     obrni(new int[]{1, 2, 3, 4, 5}));
        oceni("negativni/duplikati","-3 5 -3 || -3 5 -3",        obrni(new int[]{-3, 5, -3}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String obrni(int[] vrednosti) {
        try {
            DSLista lista = new DSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            lista.obrniDSL();
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

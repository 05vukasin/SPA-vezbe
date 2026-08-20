package z25_spojiSortirane;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z25 spojiSortirane ===");

        oceni("naizmenicno",          "1 -> 2 -> 3 -> 4 -> 5 -> 6", spoji(new int[]{1, 3, 5}, new int[]{2, 4, 6}));
        oceni("a prazna",             "2 -> 4 -> 6",                spoji(new int[]{}, new int[]{2, 4, 6}));
        oceni("b prazna",             "1 -> 3 -> 5",                spoji(new int[]{1, 3, 5}, new int[]{}));
        oceni("obe prazne",           "prazna",                     spoji(new int[]{}, new int[]{}));
        oceni("duplikati izmedju",    "1 -> 2 -> 2 -> 3 -> 3",      spoji(new int[]{2, 3}, new int[]{1, 2, 3}));
        oceni("razlicite duzine",     "1 -> 5 -> 7 -> 8 -> 9",      spoji(new int[]{5, 9}, new int[]{1, 7, 8}));
        oceni("sve iz a manje",       "1 -> 2 -> 3 -> 4",           spoji(new int[]{1, 2}, new int[]{3, 4}));
        oceni("po jedan element",     "4 -> 6",                     spoji(new int[]{6}, new int[]{4}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String spoji(int[] av, int[] bv) {
        try {
            JSLista pom = new JSLista();
            JSLista la = new JSLista();
            for (int v : av) la.dodajNaKraj(v);
            JSLista lb = new JSLista();
            for (int v : bv) lb.dodajNaKraj(v);
            CJSL rez = pom.spojiSortirane(la.prvi, lb.prvi);
            return AJSLista.ispisOd(rez);
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

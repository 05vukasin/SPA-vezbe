package z24_palindromJSL;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z24 daLiJePalindrom ===");

        oceni("neparni palindrom",   "true",  pal(new int[]{1, 2, 3, 2, 1}));
        oceni("parni palindrom",     "true",  pal(new int[]{1, 2, 2, 1}));
        oceni("nije palindrom",      "false", pal(new int[]{1, 2, 3}));
        oceni("jedan el. (true)",    "true",  pal(new int[]{7}));
        oceni("prazna (true)",       "true",  pal(new int[]{}));
        oceni("dva jednaka (true)",  "true",  pal(new int[]{5, 5}));
        oceni("dva razlicita",       "false", pal(new int[]{5, 8}));
        oceni("skoro palindrom",     "false", pal(new int[]{1, 2, 3, 2, 2}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String pal(int[] vrednosti) {
        try {
            JSLista lista = new JSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            return String.valueOf(lista.daLiJePalindrom());
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

package z10_spojiDva;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z10 spojiDva ===");

        oceni("primer",            "6 5 4 3 2 1",  spoji(new int[]{1, 3, 5},   new int[]{2, 4, 6}));
        oceni("a prazan",          "3 2 1",        spoji(new int[]{},          new int[]{1, 2, 3}));
        oceni("b prazan",          "10 5",         spoji(new int[]{5, 10},     new int[]{}));
        oceni("oba prazna",        "",             spoji(new int[]{},          new int[]{}));
        oceni("duplikati",         "3 2 1 1 1",    spoji(new int[]{1, 1, 2},   new int[]{1, 3}));
        oceni("negativni",         "2 -1 -3 -5",   spoji(new int[]{-5, -1},    new int[]{-3, 2}));
        oceni("razlicite duzine",  "5 4 3 2 1",    spoji(new int[]{1},         new int[]{2, 3, 4, 5}));
        oceni("svi isti",          "7 7 7 7",      spoji(new int[]{7, 7},      new int[]{7, 7}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String spoji(int[] a, int[] b) {
        try {
            Niz zadatak = new Niz();
            return ANiz.kaoTekst(zadatak.spojiDva(a, b));
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

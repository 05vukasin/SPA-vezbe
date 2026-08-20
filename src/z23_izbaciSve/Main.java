package z23_izbaciSve;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z23 izbaciSve ===");

        oceni("vise pojava (10)",        "20 -> 30",       izbaci(new int[]{10, 20, 10, 30, 10}, 10));
        oceni("na pocetku (10)",         "20 -> 30",       izbaci(new int[]{10, 10, 20, 30}, 10));
        oceni("na kraju (30)",           "10 -> 20",       izbaci(new int[]{10, 20, 30, 30}, 30));
        oceni("uzastopni u sredini (5)", "1 -> 9",         izbaci(new int[]{1, 5, 5, 5, 9}, 5));
        oceni("svi jednaki -> prazna",   "prazna",         izbaci(new int[]{7, 7, 7}, 7));
        oceni("vrednost ne postoji",     "10 -> 20 -> 30", izbaci(new int[]{10, 20, 30}, 99));
        oceni("prazna lista",            "prazna",         izbaci(new int[]{}, 10));
        oceni("jedan el., izbaci njega", "prazna",         izbaci(new int[]{5}, 5));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String izbaci(int[] vrednosti, int x) {
        try {
            JSLista lista = new JSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            lista.izbaciSve(x);
            return lista.ispis();
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

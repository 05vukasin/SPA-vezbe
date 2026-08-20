package z21_ubaciSortirano;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z21 ubaciSortirano ===");

        oceni("ubaci u sredinu (30)",     "10 -> 20 -> 30 -> 40 -> 50", ubaci(new int[]{10, 20, 40, 50}, 30));
        oceni("ubaci na pocetak (5)",     "5 -> 10 -> 20 -> 40 -> 50",  ubaci(new int[]{10, 20, 40, 50}, 5));
        oceni("ubaci na kraj (60)",       "10 -> 20 -> 40 -> 50 -> 60", ubaci(new int[]{10, 20, 40, 50}, 60));
        oceni("ubaci u praznu (7)",       "7",                          ubaci(new int[]{}, 7));
        oceni("duplikat (20)",            "10 -> 20 -> 20 -> 40 -> 50", ubaci(new int[]{10, 20, 40, 50}, 20));
        oceni("jedan el., ide ispred",    "3 -> 8",                     ubaci(new int[]{8}, 3));
        oceni("jedan el., ide iza",       "8 -> 15",                    ubaci(new int[]{8}, 15));
        oceni("jednak prvom (10)",        "10 -> 10 -> 20 -> 40 -> 50", ubaci(new int[]{10, 20, 40, 50}, 10));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String ubaci(int[] vrednosti, int x) {
        try {
            JSLista lista = new JSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            lista.ubaciSortirano(x);
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

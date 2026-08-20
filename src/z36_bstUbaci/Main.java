package z36_bstUbaci;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z36 ubaci ===");

        oceni("ubaci sredinu (35)",       "20 30 35 40 50 60 70 80", ubaci(true, 35));
        oceni("ubaci izmedju 40 i 50",    "20 30 40 45 50 60 70 80", ubaci(true, 45));
        oceni("ubaci najmanji (10)",      "10 20 30 40 50 60 70 80", ubaci(true, 10));
        oceni("ubaci najveci (90)",       "20 30 40 50 60 70 80 90", ubaci(true, 90));
        oceni("ubaci duplikat (50)",      "20 30 40 50 50 60 70 80", ubaci(true, 50));
        oceni("ubaci u prazno (42)",      "42",                       ubaci(false, 42));
        oceni("gradi BST u prazno",       "20 30 50 70",              ubaci(false, 50, 30, 70, 20));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String ubaci(boolean gen, int... xs) {
        try {
            BSTStablo stablo = new BSTStablo();
            if (gen) stablo.generator();
            for (int x : xs) stablo.ubaci(x);
            return stablo.ispisInfiks();
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

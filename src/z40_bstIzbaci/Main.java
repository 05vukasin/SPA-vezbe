package z40_bstIzbaci;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z40 izbaci ===");

        oceni("izbaci list (20)",              "30 40 50 60 70 80", izbaci(true, 20));
        oceni("izbaci sa dvoje dece (30)",     "20 40 50 60 70 80", izbaci(true, 30));
        oceni("izbaci koren (50, dvoje dece)", "20 30 40 60 70 80", izbaci(true, 50));
        oceni("cvor sa jednim (desnim) detetom","40 50 60 70 80",   izbaci(true, 20, 30));
        oceni("cvor sa jednim (levim) detetom","20 30 40 50 60",    izbaci(true, 80, 70));
        oceni("izbaci nepostojeci (45)",       "20 30 40 50 60 70 80", izbaci(true, 45));
        oceni("izbaci iz praznog (50)",        "",                  izbaci(false, 50));
        oceni("izbaci sve",                    "",                  izbaci(true, 20, 30, 40, 50, 60, 70, 80));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String izbaci(boolean gen, int... xs) {
        try {
            BSTStablo stablo = new BSTStablo();
            if (gen) stablo.generator();
            for (int x : xs) stablo.izbaci(x);
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
                + "   ->  ocekivano: [" + ocekivano + "] | dobijeno: [" + dobijeno + "]");
    }
}

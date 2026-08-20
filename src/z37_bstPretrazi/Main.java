package z37_bstPretrazi;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z37 pretrazi ===");

        oceni("nadji koren (50)",          "50",   pretrazi(true, 50));
        oceni("nadji list (20)",           "20",   pretrazi(true, 20));
        oceni("nadji list (80)",           "80",   pretrazi(true, 80));
        oceni("nadji unutrasnji (30)",     "30",   pretrazi(true, 30));
        oceni("nadji unutrasnji (70)",     "70",   pretrazi(true, 70));
        oceni("nema ga (45)",              "null", pretrazi(true, 45));
        oceni("nema ga, veci od svih",     "null", pretrazi(true, 100));
        oceni("prazno stablo",             "null", pretrazi(false, 50));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String pretrazi(boolean gen, int x) {
        try {
            BSTStablo stablo = new BSTStablo();
            if (gen) stablo.generator();
            CvorStabla r = stablo.pretrazi(x);
            return (r == null) ? "null" : String.valueOf(r.podatak);
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

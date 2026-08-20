package z38_bstMin;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z38 vratiMin ===");

        BSTStablo g = new BSTStablo();
        g.generator();

        oceni("min celog stabla (koren)",  "20",   min(g.koren));
        oceni("min desnog podstabla (70)", "60",   min(g.koren.desni));
        oceni("jedan cvor",                "42",   min(new CvorStabla(42)));
        oceni("koso levo (50-30-20-10)",   "10",   min(kosoLevo()));
        oceni("samo desno (min je koren)", "10",   min(samoDesno()));
        oceni("dva cvora (20 sa levim 10)","10",   min(new CvorStabla(20, new CvorStabla(10), null)));
        oceni("null cvor",                 "null", min(null));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static CvorStabla kosoLevo() {
        return new CvorStabla(50, new CvorStabla(30, new CvorStabla(20, new CvorStabla(10), null), null), null);
    }

    static CvorStabla samoDesno() {
        return new CvorStabla(10, null, new CvorStabla(20, null, new CvorStabla(30)));
    }

    static String min(CvorStabla start) {
        try {
            BSTStablo stablo = new BSTStablo();
            CvorStabla r = stablo.vratiMin(start);
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

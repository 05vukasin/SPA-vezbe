package z18_najvecaDubina;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z18 vratiCvorNaNajvecojDubini ===");

        // 1) primer iz zaglavlja: najdublji je 10 (jedinstven, dubina 3)
        oceni("primer (najdublji 10)", "10",
                test(cv(50, cv(30, cv(20, cv(10), null), null), cv(70, null, cv(80)))));

        // 2) koso levo: 50-40-30-20-10 -> najdublji 10
        oceni("koso levo (10)", "10",
                test(cv(50, cv(40, cv(30, cv(20, cv(10), null), null), null), null)));

        // 3) koso desno: 1-2-3-4 -> najdublji 4
        oceni("koso desno (4)", "4",
                test(cv(1, null, cv(2, null, cv(3, null, cv(4))))));

        // 4) jedan cvor -> vraca njega samog
        oceni("jedan cvor (42)", "42", test(cv(42)));

        // 5) balansirano sa jedinstvenim najdubljim (90 na dubini 3)
        oceni("balansirano (najdublji 90)", "90",
                test(cv(50, cv(30, cv(20), cv(40)), cv(70, cv(60), cv(80, null, cv(90))))));

        // 6) najdublji u levom podstablu (jedinstven 1 na dubini 3)
        oceni("najdublji levo (1)", "1",
                test(cv(10, cv(5, cv(3, cv(1), null), null), cv(20))));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String test(CvorStabla koren) {
        try {
            BinarnoStablo s = new BinarnoStablo();
            s.koren = koren;
            CvorStabla r = s.vratiCvorNaNajvecojDubini(koren);
            return r == null ? "null" : String.valueOf(r.podatak);
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

    static CvorStabla cv(int v, CvorStabla l, CvorStabla d) { return new CvorStabla(v, l, d); }
    static CvorStabla cv(int v) { return new CvorStabla(v); }
}

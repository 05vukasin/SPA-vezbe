package z20_daLiJeAVL;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z20 daLiJeAVL ===");

        // 1) balansirano -> true
        oceni("balansirano", "true",
                test(cv(50, cv(30, cv(20), cv(40)), cv(70, cv(60), cv(80)))));

        // 2) razlika visina = 2 kod korena -> false
        oceni("off-by-2 (koso desno)", "false",
                test(cv(50, null, cv(60, null, cv(70)))));

        // 3) jedan cvor -> true
        oceni("jedan cvor", "true", test(cv(42)));

        // 4) prazno stablo (null koren) -> true
        oceni("prazno stablo", "true", test(null));

        // 5) koso levo (lanac) -> false
        oceni("koso levo", "false",
                test(cv(50, cv(40, cv(30, cv(20), null), null), null)));

        // 6) duboko ali balansirano -> true
        oceni("duboko balansirano", "true",
                test(cv(50,
                        cv(30, cv(20, cv(10), cv(25)), cv(40)),
                        cv(70, cv(60), cv(80, cv(75), cv(90))))));

        // 7) razlika tacno 1 -> jeste AVL
        oceni("razlika tacno 1", "true",
                test(cv(50, cv(30, cv(20), null), cv(70))));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String test(CvorStabla koren) {
        try {
            BinarnoStablo s = new BinarnoStablo();
            s.koren = koren;
            return String.valueOf(s.daLiJeAVL(koren));
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

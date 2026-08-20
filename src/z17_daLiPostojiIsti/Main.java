package z17_daLiPostojiIsti;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z17 daLiPostojiIsti ===");

        // 1) klasican duplikat (dva 30): prosledi levi 30 -> true
        CvorStabla l30 = cv(30, cv(20), cv(40));
        CvorStabla t1 = cv(50, l30, cv(70, cv(30), cv(80)));
        oceni("duplikat postoji (30)", "true", test(t1, l30));

        // 2) jedinstven cvor (20) -> false
        CvorStabla c20 = cv(20);
        CvorStabla t2 = cv(50, cv(30, c20, cv(40)), cv(70, cv(30), cv(80)));
        oceni("jedinstven cvor (20)", "false", test(t2, c20));

        // 3) sve iste vrednosti (7) -> true (bilo koji cvor ima duplikat)
        CvorStabla any7 = cv(7);
        CvorStabla t3 = cv(7, cv(7, any7, cv(7)), cv(7, cv(7), cv(7)));
        oceni("sve iste (7)", "true", test(t3, any7));

        // 4) koren je duplikat (dva 50): prosledi koren -> true
        CvorStabla koren50 = cv(50, cv(30, cv(20), cv(50)), cv(70, null, cv(80)));
        oceni("koren je duplikat (50)", "true", test(koren50, koren50));

        // 5) predak-potomak duplikat (15 -> 15): prosledi predak -> true
        CvorStabla predak15 = cv(15, cv(15), cv(9));
        CvorStabla t5 = cv(100, predak15, cv(200));
        oceni("predak-potomak (15)", "true", test(t5, predak15));

        // 6) jedan cvor -> nikad nema duplikat -> false
        CvorStabla solo = cv(42);
        oceni("jedan cvor (42)", "false", test(solo, solo));

        // 7) negativni duplikat (-5) -> true
        CvorStabla neg5 = cv(-5);
        CvorStabla t7 = cv(0, cv(-5, neg5, cv(3)), cv(8, null, cv(0)));
        oceni("negativni duplikat (-5)", "true", test(t7, neg5));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String test(CvorStabla koren, CvorStabla cvor) {
        try {
            BinarnoStablo s = new BinarnoStablo();
            s.koren = koren;
            return String.valueOf(s.daLiPostojiIsti(koren, cvor));
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

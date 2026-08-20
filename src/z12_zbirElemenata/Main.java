package z12_zbirElemenata;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z12 zbirElemenata ===");

        // prazno stablo -> MORA baciti izuzetak (RuntimeException, ne UnsupportedOperation)
        oceni("prazno baca izuzetak", "RuntimeException", zbir(null));

        // jedan cvor -> vrednost
        oceni("jedan cvor (42)", "42", zbir(new CvorStabla(42)));

        // dva cvora: 10(5,_) -> 15
        oceni("dva cvora (15)", "15",
                zbir(new CvorStabla(10, new CvorStabla(5), null)));

        // balansirano standardno -> 350
        oceni("balansirano (350)", "350",
                zbir(new CvorStabla(50,
                        new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                        new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)))));

        // negativne vrednosti: -10(-5(-3,_),-2) -> -20
        oceni("negativne (-20)", "-20",
                zbir(new CvorStabla(-10,
                        new CvorStabla(-5, new CvorStabla(-3), null),
                        new CvorStabla(-2))));

        // mesano poz/neg: 5(-10,20) -> 15
        oceni("mesano (15)", "15",
                zbir(new CvorStabla(5, new CvorStabla(-10), new CvorStabla(20))));

        // koso desno: 1(_,2(_,3)) -> 6
        oceni("koso desno (6)", "6",
                zbir(new CvorStabla(1, null,
                        new CvorStabla(2, null, new CvorStabla(3)))));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String zbir(CvorStabla koren) {
        try {
            BinarnoStablo stablo = new BinarnoStablo();
            stablo.koren = koren;
            return String.valueOf(stablo.zbirElemenata());
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

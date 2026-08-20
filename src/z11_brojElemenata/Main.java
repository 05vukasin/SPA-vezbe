package z11_brojElemenata;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z11 brojElemenata ===");

        // prazno stablo (null koren) -> 0
        oceni("prazno (null)", "0", broj(null));

        // jedan cvor -> 1
        oceni("jedan cvor", "1", broj(new CvorStabla(42)));

        // koso levo: 3(2(1,_),_) -> 3
        oceni("koso levo (3)", "3",
                broj(new CvorStabla(3,
                        new CvorStabla(2, new CvorStabla(1), null),
                        null)));

        // koso desno: 1(_,2(_,3)) -> 3
        oceni("koso desno (3)", "3",
                broj(new CvorStabla(1,
                        null,
                        new CvorStabla(2, null, new CvorStabla(3)))));

        // dva cvora: 5(4,_) -> 2
        oceni("dva cvora", "2",
                broj(new CvorStabla(5, new CvorStabla(4), null)));

        // balansirano standardno: 50(30(20,40),70(60,80)) -> 7
        oceni("balansirano (7)", "7",
                broj(new CvorStabla(50,
                        new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                        new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)))));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String broj(CvorStabla koren) {
        try {
            return String.valueOf(new BinarnoStablo().brojElemenata(koren));
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

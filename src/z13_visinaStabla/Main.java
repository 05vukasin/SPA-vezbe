package z13_visinaStabla;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z13 visinaStabla ===");

        // prazno -> 0
        oceni("prazno (0)", "0", visina(null));

        // jedan cvor -> 1
        oceni("jedan cvor (1)", "1", visina(new CvorStabla(7)));

        // koso levo: 4(3(2(1,_),_),_) -> 4
        oceni("koso levo (4)", "4",
                visina(new CvorStabla(4,
                        new CvorStabla(3,
                                new CvorStabla(2, new CvorStabla(1), null),
                                null),
                        null)));

        // koso desno: 1(_,2(_,3)) -> 3
        oceni("koso desno (3)", "3",
                visina(new CvorStabla(1, null,
                        new CvorStabla(2, null, new CvorStabla(3)))));

        // asimetricno: levo dublje -> 50(30(20,_),70) -> 3
        oceni("asimetricno (3)", "3",
                visina(new CvorStabla(50,
                        new CvorStabla(30, new CvorStabla(20), null),
                        new CvorStabla(70))));

        // balansirano standardno -> 3
        oceni("balansirano (3)", "3",
                visina(new CvorStabla(50,
                        new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                        new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)))));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String visina(CvorStabla koren) {
        try {
            return String.valueOf(new BinarnoStablo().visinaStabla(koren));
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

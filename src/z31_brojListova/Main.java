package z31_brojListova;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z31 brojListova ===");

        oceni("prazno stablo (null)", "0", broj(null));
        oceni("jedan cvor", "1", broj(new CvorStabla(42)));
        // koso levo: 3(2(1,-),-)  -> jedan list (1)
        oceni("koso levo", "1", broj(
                new CvorStabla(3, new CvorStabla(2, new CvorStabla(1), null), null)));
        // koso desno: 1(-,2(-,3)) -> jedan list (3)
        oceni("koso desno", "1", broj(
                new CvorStabla(1, null, new CvorStabla(2, null, new CvorStabla(3)))));
        // balansirano 50(30(20,40),70(60,80)) -> 4
        oceni("balansirano (4 lista)", "4", broj(new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)))));
        // interni cvor sa samo jednim detetom: 10(5(-,7),15) -> listovi 7,15 -> 2
        oceni("cvor sa jednim detetom", "2", broj(new CvorStabla(10,
                new CvorStabla(5, null, new CvorStabla(7)),
                new CvorStabla(15))));
        // negativne vrednosti: -1(-2,-3) -> 2 lista
        oceni("negativne vrednosti", "2", broj(
                new CvorStabla(-1, new CvorStabla(-2), new CvorStabla(-3))));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String broj(CvorStabla koren) {
        try {
            BinarnoStablo s = new BinarnoStablo();
            return String.valueOf(s.brojListova(koren));
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

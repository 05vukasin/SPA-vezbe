package z34_zbirNaNivou;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Napomena: koren je na nivou 0 (0-baziran nivo, prema zaglavlju zadatka).
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z34 zbirNaNivou ===");

        // koren (nivo 0) -> 50
        oceni("nivo 0 (koren)", "50", zbir(base(), 0));
        // srednji nivo 1 -> 30 + 70 = 100
        oceni("nivo 1 (sredina)", "100", zbir(base(), 1));
        // najdublji nivo 2 -> 20+40+60+80 = 200
        oceni("nivo 2 (najdublji)", "200", zbir(base(), 2));
        // nivo van stabla -> 0
        oceni("nivo 3 (van stabla)", "0", zbir(base(), 3));
        // negativan nivo -> 0
        oceni("negativan nivo (-1)", "0", zbir(base(), -1));
        // jedan cvor, nivo 0 -> vrednost
        oceni("jedan cvor, nivo 0", "42", zbir(new CvorStabla(42), 0));
        // prazno stablo, nivo 0 -> 0
        oceni("prazno, nivo 0", "0", zbir(null, 0));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static CvorStabla base() {
        return new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)));
    }

    static String zbir(CvorStabla k, int nivo) {
        try {
            return String.valueOf(new BinarnoStablo().zbirNaNivou(k, nivo));
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

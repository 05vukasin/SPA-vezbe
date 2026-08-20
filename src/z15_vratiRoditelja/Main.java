package z15_vratiRoditelja;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    // standardno stablo: 50(30(20,40),70(60,80))
    static CvorStabla stablo() {
        return new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)));
    }

    public static void main(String[] args) {
        System.out.println("=== z15 vratiRoditelja ===");

        // roditelj lista 40 -> 30
        oceni("roditelj lista 40", "30", roditelj(stablo(), 40));

        // roditelj lista 80 (desna strana) -> 70
        oceni("roditelj lista 80", "70", roditelj(stablo(), 80));

        // roditelj unutrasnjeg 30 -> 50
        oceni("roditelj unutrasnjeg 30", "50", roditelj(stablo(), 30));

        // roditelj unutrasnjeg 70 -> 50
        oceni("roditelj unutrasnjeg 70", "50", roditelj(stablo(), 70));

        // vrednost je u korenu (50) -> null
        oceni("koren 50 -> null", "null", roditelj(stablo(), 50));

        // vrednost ne postoji (999) -> null
        oceni("nepostojeca 999 -> null", "null", roditelj(stablo(), 999));

        // jedan cvor, trazi njegovu vrednost -> null (koren nema roditelja)
        oceni("jedan cvor -> null", "null", roditelj(new CvorStabla(7), 7));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String roditelj(CvorStabla koren, int vrednost) {
        try {
            CvorStabla r = new BinarnoStablo().vratiRoditelja(koren, vrednost);
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

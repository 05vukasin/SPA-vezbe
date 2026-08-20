package z33_identicna;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z33 daLiSuIdenticna ===");

        // identicni
        oceni("identicni", "true", ident(base(), base()));
        // razlicita vrednost (80 -> 99)
        oceni("razlicita vrednost", "false", ident(base(), new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(99)))));
        // razlicit oblik (nedostaje desno dete cvora 30)
        oceni("razlicit oblik", "false", ident(base(), new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), null),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)))));
        // oba prazna
        oceni("oba prazna", "true", ident(null, null));
        // jedno prazno
        oceni("jedno prazno", "false", ident(base(), null));
        // ogledalo, ali NIJE identicno
        oceni("ogledalo (nije isto)", "false", ident(base(), new CvorStabla(50,
                new CvorStabla(70, new CvorStabla(80), new CvorStabla(60)),
                new CvorStabla(30, new CvorStabla(40), new CvorStabla(20)))));
        // jedan cvor iste vrednosti
        oceni("jedan cvor (isti)", "true", ident(new CvorStabla(5), new CvorStabla(5)));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static CvorStabla base() {
        return new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)));
    }

    static String ident(CvorStabla a, CvorStabla b) {
        try {
            return String.valueOf(new BinarnoStablo().daLiSuIdenticna(a, b));
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

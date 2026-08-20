package z29_binarnaPretraga;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z29 binarnaPretraga ===");

        // Ugovor: vrati INDEKS elementa x u sortiranom nizu, ili -1 ako ga nema.
        int[] a = {1, 3, 5, 7, 9, 11};
        oceni("sredina (7)",         "3",  pretraga(a, 7));
        oceni("prvi (1)",            "0",  pretraga(a, 1));
        oceni("poslednji (11)",      "5",  pretraga(a, 11));
        oceni("nema ga izmedju (4)", "-1", pretraga(a, 4));
        oceni("nema ga ispod (0)",   "-1", pretraga(a, 0));
        oceni("nema ga iznad (100)", "-1", pretraga(a, 100));
        oceni("jedan el. pogodak",   "0",  pretraga(new int[]{5}, 5));
        oceni("jedan el. promasaj",  "-1", pretraga(new int[]{5}, 3));
        oceni("prazan niz",          "-1", pretraga(new int[]{}, 1));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String pretraga(int[] a, int x) {
        try {
            Niz z = new Niz();
            return String.valueOf(z.binarnaPretraga(a, x));
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

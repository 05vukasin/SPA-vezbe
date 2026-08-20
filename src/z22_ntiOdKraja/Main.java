package z22_ntiOdKraja;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z22 nadjiNtiOdKraja ===");

        int[] lst = {10, 20, 30, 40, 50};
        oceni("n=1 (poslednji)",        "50",   nti(lst, 1));
        oceni("n=2 (pretposlednji)",    "40",   nti(lst, 2));
        oceni("n=3 (sredina)",          "30",   nti(lst, 3));
        oceni("n=5 (prvi = duzina)",    "10",   nti(lst, 5));
        oceni("n=6 (van opsega -> null)", "null", nti(lst, 6));
        oceni("jedan el., n=1",         "42",   nti(new int[]{42}, 1));
        oceni("jedan el., n=2 -> null", "null", nti(new int[]{42}, 2));
        oceni("dva el., n=2 (prvi)",    "7",    nti(new int[]{7, 9}, 2));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String nti(int[] vrednosti, int n) {
        try {
            JSLista lista = new JSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            CJSL r = lista.nadjiNtiOdKraja(n);
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

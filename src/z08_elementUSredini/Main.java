package z08_elementUSredini;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z08 elementUSredini ===");

        // Za parnu duzinu slow/fast resenje vraca gornju sredinu (index n/2).
        oceni("jedan element",       "10",  sredina(new int[]{10}));
        oceni("dva elementa",        "20",  sredina(new int[]{10, 20}));
        oceni("tri (neparno)",       "20",  sredina(new int[]{10, 20, 30}));
        oceni("cetiri (parno)",      "30",  sredina(new int[]{10, 20, 30, 40}));
        oceni("pet (neparno)",       "30",  sredina(new int[]{10, 20, 30, 40, 50}));
        oceni("sest (parno)",        "40",  sredina(new int[]{10, 20, 30, 40, 50, 60}));
        oceni("sedam (neparno)",     "40",  sredina(new int[]{10, 20, 30, 40, 50, 60, 70}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String sredina(int[] vrednosti) {
        try {
            DSLista lista = new DSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            CDSL m = lista.elementUSredini();
            return m == null ? "null" : String.valueOf(m.podatak);
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

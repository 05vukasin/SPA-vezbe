package z30_drugiNajveci;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z30 drugiNajveci ===");

        // Ugovor: vrati DRUGU najvecu RAZLICITU vrednost (razlicitu od najvece).
        // Duplikati najvece se ne racunaju. Testiramo samo nizove sa >=2 razlicite vrednosti.
        oceni("tipican",              "25", drugi(new int[]{10, 20, 30, 25}));
        oceni("duplikati najvece",    "2",  drugi(new int[]{7, 7, 7, 2}));
        oceni("duplikati oba",        "4",  drugi(new int[]{5, 1, 4, 4, 5}));
        oceni("negativne vrednosti",  "-2", drugi(new int[]{-1, -5, -3, -2}));
        oceni("dva elementa",         "3",  drugi(new int[]{3, 5}));
        oceni("dupli max i dupli 2.", "3",  drugi(new int[]{8, 8, 3, 3}));
        oceni("nesortiran",           "7",  drugi(new int[]{2, 9, 1, 9, 7}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String drugi(int[] a) {
        try {
            Niz z = new Niz();
            return String.valueOf(z.drugiNajveci(a));
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

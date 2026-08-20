package z29_binarnaPretraga;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        Niz z = new Niz();
        int[] a = {1, 3, 5, 7, 9, 11};

        System.out.println("=== z29 binarnaPretraga ===");
        System.out.println("niz:        " + ANiz.kaoTekst(a));

        int[] x        = {7, 4, 1, 11};
        int[] ocekivani = {3, -1, 0, 5};

        int ok = 0;
        for (int i = 0; i < x.length; i++) {
            String d; boolean pass = false;
            try { int r = z.binarnaPretraga(a, x[i]); d = String.valueOf(r); pass = (r == ocekivani[i]); }
            catch (Exception e) { d = e.getClass().getSimpleName(); }
            if (pass) ok++;
            System.out.println("  x=" + x[i] + ": ocekivano=" + ocekivani[i] + "   dobijeno=" + d + "   -> " + (pass ? "OK" : "NIJE"));
        }

        System.out.println("REZULTAT:   " + (ok == x.length ? "PASS" : "FAIL"));
    }
}

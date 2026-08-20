package z30_drugiNajveci;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        Niz z = new Niz();

        System.out.println("=== z30 drugiNajveci ===");

        int[][] nizovi   = {{10, 20, 30, 25}, {7, 7, 7, 2}, {5, 1, 4, 4, 5}};
        int[]   ocekivani = {25,               2,            4};

        int ok = 0;
        for (int i = 0; i < nizovi.length; i++) {
            String d; boolean pass = false;
            try { int r = z.drugiNajveci(nizovi[i]); d = String.valueOf(r); pass = (r == ocekivani[i]); }
            catch (Exception e) { d = e.getClass().getSimpleName(); }
            if (pass) ok++;
            System.out.println("  [" + ANiz.kaoTekst(nizovi[i]) + "]: ocekivano=" + ocekivani[i] + "   dobijeno=" + d + "   -> " + (pass ? "OK" : "NIJE"));
        }

        System.out.println("REZULTAT:   " + (ok == nizovi.length ? "PASS" : "FAIL"));
    }
}

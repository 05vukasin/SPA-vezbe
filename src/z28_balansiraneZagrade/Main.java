package z28_balansiraneZagrade;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        System.out.println("=== z28 daLiSuBalansirane ===");

        String[] ulazi   = {"(a[b]{c})", "(a]", "(()", "{[()]}"};
        boolean[] tacni  = {true,        false,  false,  true};

        int ok = 0;
        for (int i = 0; i < ulazi.length; i++) {
            Stek s = new Stek();
            String d; boolean pass = false;
            try {
                boolean r = s.daLiSuBalansirane(ulazi[i]);
                d = String.valueOf(r);
                pass = (r == tacni[i]);
            } catch (Exception e) { d = e.getClass().getSimpleName(); }
            if (pass) ok++;
            System.out.println("  \"" + ulazi[i] + "\": ocekivano=" + tacni[i] + "   dobijeno=" + d + "   -> " + (pass ? "OK" : "NIJE"));
        }

        System.out.println("REZULTAT:   " + (ok == ulazi.length ? "PASS" : "FAIL"));
    }
}

package z28_balansiraneZagrade;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z28 daLiSuBalansirane ===");

        oceni("ispravno ugnezdene",      "true",  bal("(a[b]{c})"));
        oceni("pogresan par",            "false", bal("(a]"));
        oceni("pogresno ugnezdenje",     "false", bal("([)]"));
        oceni("visak otvorene",          "false", bal("(()"));
        oceni("visak zatvorene",         "false", bal("())"));
        oceni("prazan string",           "true",  bal(""));
        oceni("samo obicni karakteri",   "true",  bal("abc123"));
        oceni("samo zatvorena",          "false", bal("]"));
        oceni("duboko ugnezdene",        "true",  bal("{[()]}"));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String bal(String izraz) {
        try {
            Stek s = new Stek();
            return String.valueOf(s.daLiSuBalansirane(izraz));
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

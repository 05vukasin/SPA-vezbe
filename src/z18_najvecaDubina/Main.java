package z18_najvecaDubina;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BinarnoStablo stablo = new BinarnoStablo();
        stablo.generator();

        int ocekivano = 10;

        System.out.println("=== z18 vratiCvorNaNajvecojDubini ===");
        System.out.println("stablo (infiks): " + stablo.ispisInfiks());

        String dobijeno;
        boolean pass = false;
        try {
            CvorStabla rez = stablo.vratiCvorNaNajvecojDubini(stablo.koren);
            if (rez == null) {
                dobijeno = "null";
            } else {
                dobijeno = String.valueOf(rez.podatak);
                pass = (rez.podatak == ocekivano);
            }
        } catch (Exception e) {
            dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }
}

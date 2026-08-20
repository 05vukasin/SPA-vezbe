package z14_vratiNajveci;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BinarnoStablo stablo = new BinarnoStablo();
        stablo.generator();

        int ocekivano = 95;

        System.out.println("=== z14 vratiNajveci ===");
        System.out.println("stablo (infiks): " + stablo.ispisInfiks());

        String dobijeno;
        boolean pass = false;
        try {
            CvorStabla rez = stablo.vratiNajveci(stablo.koren);
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

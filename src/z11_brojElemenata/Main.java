package z11_brojElemenata;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BinarnoStablo stablo = new BinarnoStablo();
        stablo.generator();

        int ocekivano = 7;

        System.out.println("=== z11 brojElemenata ===");
        System.out.println("stablo (infiks): " + stablo.ispisInfiks());

        String dobijeno;
        boolean pass = false;
        try {
            int rez = stablo.brojElemenata(stablo.koren);
            dobijeno = String.valueOf(rez);
            pass = (rez == ocekivano);
        } catch (Exception e) {
            dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }
}

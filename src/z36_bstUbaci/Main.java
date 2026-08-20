package z36_bstUbaci;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BSTStablo stablo = new BSTStablo();
        stablo.generator();

        String ocekivano = "20 30 35 40 50 60 70 80";
        System.out.println("=== z36 ubaci ===");
        System.out.println("pre (rastuce):  " + stablo.ispisInfiks());
        System.out.println("ubacujem:       35");

        String dobijeno;
        try { stablo.ubaci(35); dobijeno = stablo.ispisInfiks(); }
        catch (Exception e) { dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")"; }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (ocekivano.equals(dobijeno) ? "PASS" : "FAIL"));
    }
}

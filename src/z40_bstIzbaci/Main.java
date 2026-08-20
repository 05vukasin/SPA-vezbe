package z40_bstIzbaci;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BSTStablo stablo = new BSTStablo();
        stablo.generator();

        String ocekivano = "20 40 50 60 70 80";
        System.out.println("=== z40 izbaci ===");
        System.out.println("pre (rastuce):  " + stablo.ispisInfiks());
        System.out.println("izbacujem:      30 (cvor sa dvoje dece)");

        String dobijeno;
        try { stablo.izbaci(30); dobijeno = stablo.ispisInfiks(); }
        catch (Exception e) { dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")"; }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (ocekivano.equals(dobijeno) ? "PASS" : "FAIL"));
    }
}

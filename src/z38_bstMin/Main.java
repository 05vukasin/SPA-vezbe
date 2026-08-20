package z38_bstMin;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BSTStablo stablo = new BSTStablo();
        stablo.generator();

        int ocekivano = 20;
        System.out.println("=== z38 vratiMin ===");
        System.out.println("BST (rastuce): " + stablo.ispisInfiks());

        String dobijeno; boolean pass = false;
        try { CvorStabla r = stablo.vratiMin(stablo.koren); if (r == null) dobijeno = "null"; else { dobijeno = String.valueOf(r.podatak); pass = (r.podatak == ocekivano); } }
        catch (Exception e) { dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")"; }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }
}

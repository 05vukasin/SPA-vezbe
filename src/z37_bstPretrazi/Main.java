package z37_bstPretrazi;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BSTStablo stablo = new BSTStablo();
        stablo.generator();

        System.out.println("=== z37 pretrazi ===");
        System.out.println("BST (rastuce): " + stablo.ispisInfiks());

        boolean p1 = false; String d1;
        try { CvorStabla r = stablo.pretrazi(60); d1 = (r == null) ? "null" : String.valueOf(r.podatak); p1 = (r != null && r.podatak == 60); }
        catch (Exception e) { d1 = e.getClass().getSimpleName(); }
        System.out.println("[1] x=60: ocekivano=60     dobijeno=" + d1 + "   -> " + (p1 ? "OK" : "NIJE"));

        boolean p2 = false; String d2;
        try { CvorStabla r = stablo.pretrazi(45); d2 = (r == null) ? "null" : String.valueOf(r.podatak); p2 = (r == null); }
        catch (Exception e) { d2 = e.getClass().getSimpleName(); }
        System.out.println("[2] x=45: ocekivano=null   dobijeno=" + d2 + "   -> " + (p2 ? "OK" : "NIJE"));

        System.out.println("REZULTAT:   " + (p1 && p2 ? "PASS" : "FAIL"));
    }
}

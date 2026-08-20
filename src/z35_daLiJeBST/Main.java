package z35_daLiJeBST;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        System.out.println("=== z35 daLiJeBST ===");

        BinarnoStablo jeste = new BinarnoStablo();
        jeste.generator();
        System.out.println("stablo 1 (infiks): " + jeste.ispisInfiks());
        boolean p1 = false; String d1;
        try { boolean r = jeste.daLiJeBST(jeste.koren); d1 = String.valueOf(r); p1 = (r == true); }
        catch (Exception e) { d1 = e.getClass().getSimpleName(); }
        System.out.println("[1] ocekivano=true    dobijeno=" + d1 + "   -> " + (p1 ? "OK" : "NIJE"));

        BinarnoStablo nije = new BinarnoStablo();
        nije.generatorNijeBST();
        System.out.println("stablo 2 (infiks): " + nije.ispisInfiks());
        boolean p2 = false; String d2;
        try { boolean r = nije.daLiJeBST(nije.koren); d2 = String.valueOf(r); p2 = (r == false); }
        catch (Exception e) { d2 = e.getClass().getSimpleName(); }
        System.out.println("[2] ocekivano=false   dobijeno=" + d2 + "   -> " + (p2 ? "OK" : "NIJE"));

        System.out.println("REZULTAT:   " + (p1 && p2 ? "PASS" : "FAIL"));
    }
}

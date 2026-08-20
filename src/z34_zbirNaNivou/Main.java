package z34_zbirNaNivou;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BinarnoStablo stablo = new BinarnoStablo();
        stablo.generator();

        System.out.println("=== z34 zbirNaNivou ===");
        System.out.println("stablo (infiks): " + stablo.ispisInfiks());

        boolean p1 = false; String d1;
        try { int r = stablo.zbirNaNivou(stablo.koren, 1); d1 = String.valueOf(r); p1 = (r == 100); }
        catch (Exception e) { d1 = e.getClass().getSimpleName(); }
        System.out.println("[1] nivo=1: ocekivano=100   dobijeno=" + d1 + "   -> " + (p1 ? "OK" : "NIJE"));

        boolean p2 = false; String d2;
        try { int r = stablo.zbirNaNivou(stablo.koren, 2); d2 = String.valueOf(r); p2 = (r == 200); }
        catch (Exception e) { d2 = e.getClass().getSimpleName(); }
        System.out.println("[2] nivo=2: ocekivano=200   dobijeno=" + d2 + "   -> " + (p2 ? "OK" : "NIJE"));

        System.out.println("REZULTAT:   " + (p1 && p2 ? "PASS" : "FAIL"));
    }
}

package z17_daLiPostojiIsti;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BinarnoStablo stablo = new BinarnoStablo();
        stablo.generator();

        CvorStabla levo30 = stablo.koren.levi;       // 30 (ima duplikat)
        CvorStabla cvor20 = stablo.koren.levi.levi;  // 20 (jedinstven)

        System.out.println("=== z17 daLiPostojiIsti ===");
        System.out.println("stablo (infiks): " + stablo.ispisInfiks());

        boolean p1 = false;
        String d1;
        try {
            boolean r = stablo.daLiPostojiIsti(stablo.koren, levo30);
            d1 = String.valueOf(r);
            p1 = (r == true);
        } catch (Exception e) { d1 = e.getClass().getSimpleName(); }
        System.out.println("[1] cvor=30: ocekivano=true   dobijeno=" + d1 + "   -> " + (p1 ? "OK" : "NIJE"));

        boolean p2 = false;
        String d2;
        try {
            boolean r = stablo.daLiPostojiIsti(stablo.koren, cvor20);
            d2 = String.valueOf(r);
            p2 = (r == false);
        } catch (Exception e) { d2 = e.getClass().getSimpleName(); }
        System.out.println("[2] cvor=20: ocekivano=false  dobijeno=" + d2 + "   -> " + (p2 ? "OK" : "NIJE"));

        System.out.println("REZULTAT:   " + (p1 && p2 ? "PASS" : "FAIL"));
    }
}

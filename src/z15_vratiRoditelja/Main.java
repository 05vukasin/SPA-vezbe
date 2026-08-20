package z15_vratiRoditelja;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BinarnoStablo stablo = new BinarnoStablo();
        stablo.generator();

        System.out.println("=== z15 vratiRoditelja ===");
        System.out.println("stablo (infiks): " + stablo.ispisInfiks());

        // Provera 1: roditelj od 40 je 30
        boolean p1 = false;
        String d1;
        try {
            CvorStabla r = stablo.vratiRoditelja(stablo.koren, 40);
            d1 = (r == null) ? "null" : String.valueOf(r.podatak);
            p1 = (r != null && r.podatak == 30);
        } catch (Exception e) { d1 = e.getClass().getSimpleName(); }
        System.out.println("[1] roditelj(40): ocekivano=30    dobijeno=" + d1 + "   -> " + (p1 ? "OK" : "NIJE"));

        // Provera 2: roditelj korena (50) je null
        boolean p2 = false;
        String d2;
        try {
            CvorStabla r = stablo.vratiRoditelja(stablo.koren, 50);
            d2 = (r == null) ? "null" : String.valueOf(r.podatak);
            p2 = (r == null);
        } catch (Exception e) { d2 = e.getClass().getSimpleName(); }
        System.out.println("[2] roditelj(50): ocekivano=null  dobijeno=" + d2 + "   -> " + (p2 ? "OK" : "NIJE"));

        System.out.println("REZULTAT:   " + (p1 && p2 ? "PASS" : "FAIL"));
    }
}

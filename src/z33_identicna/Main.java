package z33_identicna;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BinarnoStablo s = new BinarnoStablo();

        CvorStabla a = new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)));
        CvorStabla b = new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)));
        CvorStabla c = new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(99)));

        System.out.println("=== z33 daLiSuIdenticna ===");

        boolean p1 = false; String d1;
        try { boolean r = s.daLiSuIdenticna(a, b); d1 = String.valueOf(r); p1 = (r == true); }
        catch (Exception e) { d1 = e.getClass().getSimpleName(); }
        System.out.println("[1] a vs b (isti):     ocekivano=true    dobijeno=" + d1 + "   -> " + (p1 ? "OK" : "NIJE"));

        boolean p2 = false; String d2;
        try { boolean r = s.daLiSuIdenticna(a, c); d2 = String.valueOf(r); p2 = (r == false); }
        catch (Exception e) { d2 = e.getClass().getSimpleName(); }
        System.out.println("[2] a vs c (razlicit): ocekivano=false   dobijeno=" + d2 + "   -> " + (p2 ? "OK" : "NIJE"));

        System.out.println("REZULTAT:   " + (p1 && p2 ? "PASS" : "FAIL"));
    }
}

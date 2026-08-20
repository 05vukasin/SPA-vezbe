package z24_palindromJSL;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        System.out.println("=== z24 daLiJePalindrom ===");

        JSLista a = new JSLista();
        for (int v : new int[]{1, 2, 3, 2, 1}) a.dodajNaKraj(v);
        boolean p1 = false; String d1;
        try { boolean r = a.daLiJePalindrom(); d1 = String.valueOf(r); p1 = (r == true); }
        catch (Exception e) { d1 = e.getClass().getSimpleName(); }
        System.out.println("[1] " + a.ispis() + ": ocekivano=true    dobijeno=" + d1 + "   -> " + (p1 ? "OK" : "NIJE"));

        JSLista b = new JSLista();
        for (int v : new int[]{1, 2, 3}) b.dodajNaKraj(v);
        boolean p2 = false; String d2;
        try { boolean r = b.daLiJePalindrom(); d2 = String.valueOf(r); p2 = (r == false); }
        catch (Exception e) { d2 = e.getClass().getSimpleName(); }
        System.out.println("[2] " + b.ispis() + ": ocekivano=false   dobijeno=" + d2 + "   -> " + (p2 ? "OK" : "NIJE"));

        System.out.println("REZULTAT:   " + (p1 && p2 ? "PASS" : "FAIL"));
    }
}

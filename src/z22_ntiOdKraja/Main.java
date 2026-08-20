package z22_ntiOdKraja;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        JSLista lista = new JSLista();
        for (int v : new int[]{10, 20, 30, 40, 50}) lista.dodajNaKraj(v);

        System.out.println("=== z22 nadjiNtiOdKraja ===");
        System.out.println("lista:      " + lista.ispis());

        boolean p1 = false; String d1;
        try { CJSL r = lista.nadjiNtiOdKraja(2); d1 = (r == null) ? "null" : String.valueOf(r.podatak); p1 = (r != null && r.podatak == 40); }
        catch (Exception e) { d1 = e.getClass().getSimpleName(); }
        System.out.println("[1] n=2: ocekivano=40   dobijeno=" + d1 + "   -> " + (p1 ? "OK" : "NIJE"));

        boolean p2 = false; String d2;
        try { CJSL r = lista.nadjiNtiOdKraja(5); d2 = (r == null) ? "null" : String.valueOf(r.podatak); p2 = (r != null && r.podatak == 10); }
        catch (Exception e) { d2 = e.getClass().getSimpleName(); }
        System.out.println("[2] n=5: ocekivano=10   dobijeno=" + d2 + "   -> " + (p2 ? "OK" : "NIJE"));

        System.out.println("REZULTAT:   " + (p1 && p2 ? "PASS" : "FAIL"));
    }
}

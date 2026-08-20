package z21_ubaciSortirano;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        System.out.println("=== z21 ubaciSortirano ===");

        // Provera 1: ubacivanje u sredinu
        JSLista a = new JSLista();
        for (int v : new int[]{10, 20, 40, 50}) a.dodajNaKraj(v);
        String d1;
        boolean p1 = false;
        try { a.ubaciSortirano(30); d1 = a.ispis(); p1 = "10 -> 20 -> 30 -> 40 -> 50".equals(d1); }
        catch (Exception e) { d1 = e.getClass().getSimpleName(); }
        System.out.println("[1] x=30: ocekivano=10 -> 20 -> 30 -> 40 -> 50   dobijeno=" + d1 + "   -> " + (p1 ? "OK" : "NIJE"));

        // Provera 2: ubacivanje na pocetak (menja se prvi)
        JSLista b = new JSLista();
        for (int v : new int[]{10, 20, 40, 50}) b.dodajNaKraj(v);
        String d2;
        boolean p2 = false;
        try { b.ubaciSortirano(5); d2 = b.ispis(); p2 = "5 -> 10 -> 20 -> 40 -> 50".equals(d2); }
        catch (Exception e) { d2 = e.getClass().getSimpleName(); }
        System.out.println("[2] x=5:  ocekivano=5 -> 10 -> 20 -> 40 -> 50   dobijeno=" + d2 + "   -> " + (p2 ? "OK" : "NIJE"));

        System.out.println("REZULTAT:   " + (p1 && p2 ? "PASS" : "FAIL"));
    }
}

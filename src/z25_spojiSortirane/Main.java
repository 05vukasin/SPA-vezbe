package z25_spojiSortirane;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        JSLista pom = new JSLista(); // instanca samo da pozovemo metodu

        JSLista la = new JSLista();
        for (int v : new int[]{1, 3, 5}) la.dodajNaKraj(v);
        JSLista lb = new JSLista();
        for (int v : new int[]{2, 4, 6}) lb.dodajNaKraj(v);

        String ocekivano = "1 -> 2 -> 3 -> 4 -> 5 -> 6";

        System.out.println("=== z25 spojiSortirane ===");
        System.out.println("a:          " + la.ispis());
        System.out.println("b:          " + lb.ispis());

        String dobijeno;
        try {
            CJSL rez = pom.spojiSortirane(la.prvi, lb.prvi);
            dobijeno = AJSLista.ispisOd(rez);
        } catch (Exception e) { dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")"; }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (ocekivano.equals(dobijeno) ? "PASS" : "FAIL"));
    }
}

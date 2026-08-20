package z03_invertujBezPomocne;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        JSLista lista = new JSLista();
        lista.dodajNaKraj(10);
        lista.dodajNaKraj(20);
        lista.dodajNaKraj(30);
        lista.dodajNaKraj(40);

        String ocekivano = "40 -> 30 -> 20 -> 10";

        System.out.println("=== z03 invertovanjeBezPomocne ===");
        System.out.println("pocetna:    " + lista.ispis());

        String dobijeno;
        try {
            lista.invertovanjeBezPomocne();
            dobijeno = lista.ispis();
        } catch (Exception e) {
            dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (ocekivano.equals(dobijeno) ? "PASS" : "FAIL"));
    }
}

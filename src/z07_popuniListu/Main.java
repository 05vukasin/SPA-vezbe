package z07_popuniListu;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        DSLista lista = new DSLista();
        lista.dodajNaKraj(3);
        lista.dodajNaKraj(5);
        lista.dodajNaKraj(8);

        String ocekivano = "3 4 5 6 7 8";

        System.out.println("=== z07 popuniListu ===");
        System.out.println("pre:        " + lista.ispis());

        String dobijeno;
        try {
            lista.popuniListu();
            dobijeno = lista.sekvenca();
        } catch (Exception e) {
            dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (ocekivano.equals(dobijeno) ? "PASS" : "FAIL"));
    }
}

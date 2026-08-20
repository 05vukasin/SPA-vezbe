package z08_elementUSredini;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        DSLista lista = new DSLista();
        lista.dodajNaKraj(10);
        lista.dodajNaKraj(20);
        lista.dodajNaKraj(30);
        lista.dodajNaKraj(40);
        lista.dodajNaKraj(50);

        int ocekivano = 30;

        System.out.println("=== z08 elementUSredini ===");
        System.out.println("lista:      " + lista.ispis());

        String dobijeno;
        boolean pass = false;
        try {
            CDSL sredina = lista.elementUSredini();
            if (sredina == null) {
                dobijeno = "null";
            } else {
                dobijeno = String.valueOf(sredina.podatak);
                pass = (sredina.podatak == ocekivano);
            }
        } catch (Exception e) {
            dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }
}

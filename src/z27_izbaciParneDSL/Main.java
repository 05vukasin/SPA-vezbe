package z27_izbaciParneDSL;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        DSLista lista = new DSLista();
        for (int v : new int[]{1, 2, 3, 4, 5, 6}) lista.dodajNaKraj(v);

        System.out.println("=== z27 izbaciParne ===");
        System.out.println("pre:        " + lista.ispis());

        boolean pass = false;
        try {
            lista.izbaciParne();
            String napred = lista.sekvenca();
            String nazad  = lista.sekvencaUnazad();
            boolean okNapred = "1 3 5".equals(napred);
            boolean okNazad  = "5 3 1".equals(nazad);
            pass = okNapred && okNazad;
            System.out.println("napred (sledeci):    " + napred + "   -> " + (okNapred ? "OK" : "NIJE (ocek. 1 3 5)"));
            System.out.println("unazad (prethodni):  " + nazad + "   -> " + (okNazad ? "OK" : "NIJE (ocek. 5 3 1)"));
        } catch (Exception e) {
            System.out.println("greska: " + e.getClass().getSimpleName() + " (" + e.getMessage() + ")");
        }

        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }
}

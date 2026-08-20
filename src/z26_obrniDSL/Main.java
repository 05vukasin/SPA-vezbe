package z26_obrniDSL;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        DSLista lista = new DSLista();
        for (int v : new int[]{10, 20, 30, 40}) lista.dodajNaKraj(v);

        System.out.println("=== z26 obrniDSL ===");
        System.out.println("pre:        " + lista.ispis());

        String napred, nazad;
        boolean pass = false;
        try {
            lista.obrniDSL();
            napred = lista.sekvenca();          // preko 'sledeci'
            nazad  = lista.sekvencaUnazad();    // preko 'prethodni'
            boolean okNapred = "40 30 20 10".equals(napred);
            boolean okNazad  = "10 20 30 40".equals(nazad); // od kraja unazad = originalni redosled
            pass = okNapred && okNazad;
            System.out.println("napred (sledeci):    " + napred + "   -> " + (okNapred ? "OK" : "NIJE (ocek. 40 30 20 10)"));
            System.out.println("unazad (prethodni):  " + nazad + "   -> " + (okNazad ? "OK" : "NIJE (ocek. 10 20 30 40)"));
        } catch (Exception e) {
            System.out.println("greska: " + e.getClass().getSimpleName() + " (" + e.getMessage() + ")");
        }

        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }
}

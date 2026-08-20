package z05_ispisiObrnuto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        JSLista lista = new JSLista();
        lista.dodajNaKraj(10);
        lista.dodajNaKraj(20);
        lista.dodajNaKraj(30);

        String ocekivano = "30 20 10";

        System.out.println("=== z05 ispisiObrnuto ===");
        System.out.println("lista:      " + lista.ispis());

        // hvatamo sve sto metoda ispise na System.out
        PrintStream stari = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        String dobijeno;
        boolean pass = false;
        try {
            System.setOut(new PrintStream(buf));
            lista.ispisiObrnuto(lista.prvi);
            System.setOut(stari);
            // normalizacija: sve praznine -> jedan razmak
            dobijeno = buf.toString().trim().replaceAll("\\s+", " ");
            pass = ocekivano.equals(dobijeno);
        } catch (Exception e) {
            System.setOut(stari);
            dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }
}

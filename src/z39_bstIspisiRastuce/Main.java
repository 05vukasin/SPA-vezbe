package z39_bstIspisiRastuce;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BSTStablo stablo = new BSTStablo();
        stablo.generator();

        String ocekivano = "20 30 40 50 60 70 80";
        System.out.println("=== z39 ispisiRastuce ===");

        PrintStream stari = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        String dobijeno; boolean pass = false;
        try {
            System.setOut(new PrintStream(buf));
            stablo.ispisiRastuce(stablo.koren);
            System.setOut(stari);
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

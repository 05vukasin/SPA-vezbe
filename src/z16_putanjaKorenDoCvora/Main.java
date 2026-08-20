package z16_putanjaKorenDoCvora;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BinarnoStablo stablo = new BinarnoStablo();
        stablo.generator();
        CvorStabla cilj = stablo.koren.levi.desni; // cvor 40

        String ocekivano = "50 30 40";

        System.out.println("=== z16 putanjaKorenDoCvora ===");
        System.out.println("stablo (infiks): " + stablo.ispisInfiks());
        System.out.println("cilj:            " + cilj.podatak);

        PrintStream stari = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        String dobijeno;
        boolean pass = false;
        try {
            System.setOut(new PrintStream(buf));
            stablo.putanjaKorenDoCvora(stablo.koren, cilj);
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

package z09_ispisiStekObrnuto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        Stek stek = new Stek();
        stek.push(10);
        stek.push(20);
        stek.push(30);
        stek.push(40);

        String ocekivaniIspis = "10 20 30 40";
        String stanjePre = stek.stanjeOdVrha();   // "40 30 20 10"

        System.out.println("=== z09 ispisiStekObrnuto ===");
        System.out.println("stek (vrh->dno): " + stanjePre);

        PrintStream stari = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        String dobijeniIspis;
        boolean pass = false;
        try {
            System.setOut(new PrintStream(buf));
            stek.ispisiStekObrnuto();
            System.setOut(stari);
            dobijeniIspis = buf.toString().trim().replaceAll("\\s+", " ");
            String stanjePosle = stek.stanjeOdVrha();
            boolean vracenoStanje = stanjePre.equals(stanjePosle);
            pass = ocekivaniIspis.equals(dobijeniIspis) && vracenoStanje;
            if (!vracenoStanje) dobijeniIspis += "  [stek NIJE vracen u pocetno stanje: " + stanjePosle + "]";
        } catch (Exception e) {
            System.setOut(stari);
            dobijeniIspis = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivaniIspis);
        System.out.println("dobijeno:   " + dobijeniIspis);
        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }
}

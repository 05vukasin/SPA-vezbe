package z16_putanjaKorenDoCvora;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z16 putanjaKorenDoCvora ===");

        // standardno stablo sa referencama na cvorove:
        //            50
        //          /    \
        //        30      70
        //       /  \    /  \
        //      20  40  60   80
        CvorStabla n20 = new CvorStabla(20);
        CvorStabla n40 = new CvorStabla(40);
        CvorStabla n60 = new CvorStabla(60);
        CvorStabla n80 = new CvorStabla(80);
        CvorStabla n30 = new CvorStabla(30, n20, n40);
        CvorStabla n70 = new CvorStabla(70, n60, n80);
        CvorStabla koren = new CvorStabla(50, n30, n70);

        // putanja do lista 40
        oceni("do lista 40", "50 30 40", putanja(koren, n40));

        // putanja do lista 20 (levi kraj)
        oceni("do lista 20", "50 30 20", putanja(koren, n20));

        // putanja do lista 80 (desni kraj)
        oceni("do lista 80", "50 70 80", putanja(koren, n80));

        // putanja do samog korena
        oceni("do korena 50", "50", putanja(koren, koren));

        // putanja do unutrasnjeg cvora 30
        oceni("do unutrasnjeg 30", "50 30", putanja(koren, n30));

        // putanja do unutrasnjeg cvora 70
        oceni("do unutrasnjeg 70", "50 70", putanja(koren, n70));

        // jedan cvor: putanja do njega samog
        CvorStabla solo = new CvorStabla(7);
        oceni("jedan cvor do sebe", "7", putanja(solo, solo));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String putanja(CvorStabla koren, CvorStabla cilj) {
        PrintStream stari = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(buf));
            new BinarnoStablo().putanjaKorenDoCvora(koren, cilj);
            System.setOut(stari);
            return buf.toString().trim().replaceAll("\\s+", " ");
        } catch (Exception e) {
            System.setOut(stari);
            return e.getClass().getSimpleName();
        }
    }

    static void oceni(String naziv, String ocekivano, String dobijeno) {
        ukupno++;
        boolean ok = ocekivano.equals(dobijeno);
        if (ok) proslo++;
        System.out.println((ok ? "  [PASS] " : "  [FAIL] ") + naziv
                + "   ->  ocekivano: " + ocekivano + " | dobijeno: " + dobijeno);
    }
}

package z09_ispisiStekObrnuto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z09 ispisiStekObrnuto ===");

        // Ispis od dna ka vrhu (prvo ubaceni prvi). Stek mora ostati nepromenjen.
        oceni("primer 10,20,30,40",  "10 20 30 40",   ispisi(new int[]{10, 20, 30, 40}));
        oceni("jedan element",       "42",            ispisi(new int[]{42}));
        oceni("dva elementa",        "10 20",         ispisi(new int[]{10, 20}));
        oceni("prazan stek",         "",              ispisi(new int[]{}));
        oceni("negativni",           "-5 -1 -3",      ispisi(new int[]{-5, -1, -3}));
        oceni("duplikati",           "7 7 7",         ispisi(new int[]{7, 7, 7}));
        oceni("mesano",              "3 1 2",         ispisi(new int[]{3, 1, 2}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    // Hvata stdout; vraca normalizovan ispis. Ako stek nije vracen u
    // pocetno stanje, dopisuje [STEK PROMENJEN].
    static String ispisi(int[] vrednosti) {
        Stek stek = new Stek();
        for (int v : vrednosti) stek.push(v);
        String pre = stek.stanjeOdVrha();

        PrintStream stari = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(buf));
            stek.ispisiStekObrnuto();
            System.setOut(stari);
            String ispis = buf.toString().trim().replaceAll("\\s+", " ");
            String posle = stek.stanjeOdVrha();
            if (!pre.equals(posle))
                return ispis + " [STEK PROMENJEN: " + posle + "]";
            return ispis;
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

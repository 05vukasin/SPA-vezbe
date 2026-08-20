package z39_bstIspisiRastuce;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z39 ispisiRastuce ===");

        BSTStablo g = new BSTStablo();
        g.generator();

        oceni("balansirano stablo",        "20 30 40 50 60 70 80", cap(g.koren));
        oceni("levo podstablo (30)",       "20 30 40",             cap(g.koren.levi));
        oceni("jedan cvor",                "42",                   cap(new CvorStabla(42)));
        oceni("koso levo (30-20-10)",      "10 20 30",             cap(kosoLevo()));
        oceni("koso desno (10-20-30)",     "10 20 30",             cap(kosoDesno()));
        oceni("prazno (nista ne ispisuje)","",                     cap(null));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static CvorStabla kosoLevo() {
        return new CvorStabla(30, new CvorStabla(20, new CvorStabla(10), null), null);
    }

    static CvorStabla kosoDesno() {
        return new CvorStabla(10, null, new CvorStabla(20, null, new CvorStabla(30)));
    }

    static String cap(CvorStabla start) {
        PrintStream stari = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try {
            BSTStablo stablo = new BSTStablo();
            System.setOut(new PrintStream(buf));
            stablo.ispisiRastuce(start);
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
                + "   ->  ocekivano: [" + ocekivano + "] | dobijeno: [" + dobijeno + "]");
    }
}

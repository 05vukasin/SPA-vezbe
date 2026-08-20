package z05_ispisiObrnuto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z05 ispisiObrnuto ===");

        oceni("prazna lista",          "",             obrnuto(new int[]{}));
        oceni("jedan element",         "42",           obrnuto(new int[]{42}));
        oceni("dva elementa",          "20 10",        obrnuto(new int[]{10, 20}));
        oceni("tri (primer)",          "30 20 10",     obrnuto(new int[]{10, 20, 30}));
        oceni("duplikati vrednosti",   "7 7 5 5",      obrnuto(new int[]{5, 5, 7, 7}));
        oceni("negativne vrednosti",   "3 -2 -1",      obrnuto(new int[]{-1, -2, 3}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String obrnuto(int[] vrednosti) {
        PrintStream stari = System.out;
        try {
            JSLista lista = new JSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            System.setOut(new PrintStream(buf));
            lista.ispisiObrnuto(lista.prvi);
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
                + "   ->  ocekivano: '" + ocekivano + "' | dobijeno: '" + dobijeno + "'");
    }
}

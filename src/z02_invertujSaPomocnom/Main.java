package z02_invertujSaPomocnom;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z02 invertovanjeSaPomocnom ===");

        oceni("prazna lista",          "prazna",                inv(new int[]{}));
        oceni("jedan element",         "42",                    inv(new int[]{42}));
        oceni("dva elementa",          "20 -> 10",              inv(new int[]{10, 20}));
        oceni("cetiri (primer)",       "40 -> 30 -> 20 -> 10",  inv(new int[]{10, 20, 30, 40}));
        oceni("duplikati vrednosti",   "7 -> 7 -> 5 -> 5",      inv(new int[]{5, 5, 7, 7}));
        oceni("negativne vrednosti",   "3 -> -2 -> -1",         inv(new int[]{-1, -2, 3}));
        oceni("vec opadajuce",         "10 -> 20 -> 30",        inv(new int[]{30, 20, 10}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String inv(int[] vrednosti) {
        try {
            JSLista lista = new JSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            lista.invertovanjeSaPomocnom();
            return lista.ispis();
        } catch (Exception e) {
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

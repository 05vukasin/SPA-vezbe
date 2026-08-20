package z04_zbirUCiklicnoj;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z04 zbirElemenataUCiklicnoj ===");

        oceni("prazna lista",            "0",    zbir(new int[]{}));
        oceni("jedan (ciklus na sebe)",  "7",    zbir(new int[]{7}));
        oceni("dva elementa",            "30",   zbir(new int[]{10, 20}));
        oceni("cetiri (primer)",         "50",   zbir(new int[]{5, 10, 15, 20}));
        oceni("negativne vrednosti",     "-6",   zbir(new int[]{-1, -2, -3}));
        oceni("duplikati vrednosti",     "20",   zbir(new int[]{5, 5, 5, 5}));
        oceni("sa nulom i negativnim",   "50",   zbir(new int[]{0, 100, -50}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String zbir(int[] vrednosti) {
        try {
            JSLista lista = new JSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            lista.zatvoriCiklus();
            return String.valueOf(lista.zbirElemenataUCiklicnoj());
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

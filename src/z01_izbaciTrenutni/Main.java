package z01_izbaciTrenutni;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Driver: pokreće više testova, uključujući GRANIČNE slučajeve.
// Cilj: da svi testovi budu [PASS]. Dok metoda nije gotova -> svi [FAIL].
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z01 izbaciTrenutni ===");

        oceni("izbaci iz sredine (30)",  "10 -> 20 -> 40",  izbaci(new int[]{10, 20, 30, 40}, 2));
        oceni("izbaci prvi (10)",        "20 -> 30 -> 40",  izbaci(new int[]{10, 20, 30, 40}, 0));
        oceni("izbaci poslednji (40)",   "10 -> 20 -> 30",  izbaci(new int[]{10, 20, 30, 40}, 3));
        oceni("dva el., izbaci prvi",    "20",              izbaci(new int[]{10, 20}, 0));
        oceni("dva el., izbaci drugi",   "10",              izbaci(new int[]{10, 20}, 1));
        oceni("jedan el., izbaci njega", "prazna",          izbaci(new int[]{42}, 0));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    // Napravi listu, izbaci čvor na indeksu 'idx', vrati ispis liste (ili ime izuzetka).
    static String izbaci(int[] vrednosti, int idx) {
        try {
            JSLista lista = new JSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            CJSL neki = lista.cvorNa(idx);
            lista.izbaciTrenutni(neki);
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

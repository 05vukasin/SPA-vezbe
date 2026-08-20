package z06_klonirajRekurzivno;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        JSLista lista = new JSLista();
        lista.dodajNaKraj(1);
        lista.dodajNaKraj(2);
        lista.dodajNaKraj(3);

        String ocekivano = "1 -> 2 -> 3 (novi cvorovi)";

        System.out.println("=== z06 klonirajRekurzivno ===");
        System.out.println("original:   " + lista.ispis());

        String dobijeno;
        boolean pass = false;
        try {
            CJSL klon = lista.klonirajRekurzivno(lista.prvi);
            String seq = AJSLista.ispisOd(klon);
            boolean duboka = jeDubokaKopija(lista.prvi, klon);
            dobijeno = seq + (duboka ? " (novi cvorovi)" : " (ISTI cvorovi — nije duboka!)");
            pass = "1 -> 2 -> 3".equals(seq) && duboka;
        } catch (Exception e) {
            dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }

    // isti podaci, ali svaki par cvorova mora biti RAZLICIT objekat
    private static boolean jeDubokaKopija(CJSL orig, CJSL klon) {
        while (orig != null && klon != null) {
            if (orig == klon) return false;              // isti objekat -> nije duboka
            if (orig.podatak != klon.podatak) return false;
            orig = orig.sledeci;
            klon = klon.sledeci;
        }
        return orig == null && klon == null;             // ista duzina
    }
}

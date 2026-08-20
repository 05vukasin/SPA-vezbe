package z07_popuniListu;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z07 popuniListu ===");

        oceni("primer 3,5,8",        "3 4 5 6 7 8",           popuni(new int[]{3, 5, 8}));
        oceni("jedan element",       "5",                     popuni(new int[]{5}));
        oceni("dva, rupa 1",         "3 4 5",                 popuni(new int[]{3, 5}));
        oceni("vec sukcesivno",      "1 2 3",                 popuni(new int[]{1, 2, 3}));
        oceni("susedni (diff 1)",    "7 8",                   popuni(new int[]{7, 8}));
        oceni("velika rupa",         "1 2 3 4 5",             popuni(new int[]{1, 5}));
        oceni("vise rupa",           "10 11 12 13 14 15",     popuni(new int[]{10, 13, 15}));
        oceni("prva rupa pa susedni","2 3 4 5",               popuni(new int[]{2, 4, 5}));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    // Popuni listu; vrati sekvencu unapred. Ako su prethodni-pokazivaci
    // pogresni (unazad != obrnuto od unapred), dopisi [LINK GRESKA].
    static String popuni(int[] vrednosti) {
        try {
            DSLista lista = new DSLista();
            for (int v : vrednosti) lista.dodajNaKraj(v);
            lista.popuniListu();

            String napred = lista.sekvenca();
            if (napred.isEmpty()) return napred;

            // prodji do kraja pa se vrati preko 'prethodni'
            CDSL t = lista.prvi;
            while (t.sledeci != null) t = t.sledeci;
            StringBuilder unazad = new StringBuilder();
            while (t != null) {
                unazad.append(t.podatak);
                if (t.prethodni != null) unazad.append(" ");
                t = t.prethodni;
            }

            // obrnuto od 'napred' mora biti jednako 'unazad'
            String[] delovi = napred.split(" ");
            StringBuilder obrnuto = new StringBuilder();
            for (int i = delovi.length - 1; i >= 0; i--) {
                obrnuto.append(delovi[i]);
                if (i > 0) obrnuto.append(" ");
            }
            if (!obrnuto.toString().equals(unazad.toString()))
                return napred + " [LINK GRESKA: unazad=" + unazad + "]";

            return napred;
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

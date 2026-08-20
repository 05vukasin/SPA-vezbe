package z29_binarnaPretraga;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ANiz {

    public static String kaoTekst(int[] n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length; i++) { sb.append(n[i]); if (i < n.length - 1) sb.append(" "); }
        return sb.toString();
    }

    // >>> Metoda koju TI implementiras <<<
    // Niz 'a' je sortiran rastuce. Vrati INDEKS elementa 'x', ili -1 ako ga nema.
    public abstract int binarnaPretraga(int[] a, int x);
}

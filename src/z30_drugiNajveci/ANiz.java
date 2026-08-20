package z30_drugiNajveci;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ANiz {

    public static String kaoTekst(int[] n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length; i++) { sb.append(n[i]); if (i < n.length - 1) sb.append(" "); }
        return sb.toString();
    }

    // >>> Metoda koju TI implementiras <<<
    // Vrati DRUGU najvecu RAZLICITU vrednost u nizu.
    // (npr. [3,7,2,7,5] -> najveca 7, druga najveca 5)
    public abstract int drugiNajveci(int[] a);
}

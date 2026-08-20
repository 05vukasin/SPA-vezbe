package z10_spojiDva;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ANiz {

    // Pomocna: niz kao "6 5 4 3 2 1"
    public static String kaoTekst(int[] n) {
        if (n == null) return "null";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length; i++) {
            sb.append(n[i]);
            if (i < n.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    // >>> Metoda koju TI implementiras <<<
    public abstract int[] spojiDva(int[] a, int[] b);
}

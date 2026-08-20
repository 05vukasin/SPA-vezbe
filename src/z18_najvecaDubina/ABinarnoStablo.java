package z18_najvecaDubina;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ABinarnoStablo {
    public CvorStabla koren;

    // Najdublji cvor je 10 (dubina 3):
    //            50
    //          /    \
    //        30      70
    //       /          \
    //      20           80
    //     /
    //    10
    public void generator() {
        koren = new CvorStabla(50,
                    new CvorStabla(30, new CvorStabla(20, new CvorStabla(10), null), null),
                    new CvorStabla(70, null, new CvorStabla(80)));
    }

    public String ispisInfiks() {
        StringBuilder sb = new StringBuilder();
        infiks(koren, sb);
        return sb.toString().trim();
    }

    private void infiks(CvorStabla c, StringBuilder sb) {
        if (c == null) return;
        infiks(c.levi, sb);
        sb.append(c.podatak).append(" ");
        infiks(c.desni, sb);
    }

    // >>> Metoda koju TI implementiras <<<
    // Vrati pokazivac na cvor koji se nalazi na NAJVECOJ dubini.
    public abstract CvorStabla vratiCvorNaNajvecojDubini(CvorStabla k);
}

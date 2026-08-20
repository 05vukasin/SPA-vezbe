package z14_vratiNajveci;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ABinarnoStablo {
    public CvorStabla koren;

    // PAZI: ovo NIJE BST (90 je levo od 50). Najveci je 95.
    //            50
    //          /    \
    //        90      70
    //       /  \    /
    //      20  40  95
    public void generator() {
        koren = new CvorStabla(50,
                    new CvorStabla(90, new CvorStabla(20), new CvorStabla(40)),
                    new CvorStabla(70, new CvorStabla(95), null));
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
    // Vrati POKAZIVAC na cvor sa najvecom vrednoscu (ne pretpostavljaj BST!).
    public abstract CvorStabla vratiNajveci(CvorStabla k);
}

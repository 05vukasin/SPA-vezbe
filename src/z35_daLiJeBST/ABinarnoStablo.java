package z35_daLiJeBST;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ABinarnoStablo {
    public CvorStabla koren;

    // Ispravan BST
    public void generator() {
        koren = new CvorStabla(50,
                    new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                    new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)));
    }

    // NIJE BST: 90 je u levom podstablu korena 50 (a 90 > 50)
    public void generatorNijeBST() {
        koren = new CvorStabla(50,
                    new CvorStabla(30, new CvorStabla(20), new CvorStabla(90)),
                    new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)));
    }

    public String ispisInfiks() {
        StringBuilder sb = new StringBuilder();
        infiks(koren, sb);
        return sb.toString().trim();
    }
    private void infiks(CvorStabla c, StringBuilder sb) {
        if (c == null) return;
        infiks(c.levi, sb); sb.append(c.podatak).append(" "); infiks(c.desni, sb);
    }

    // >>> Metoda koju TI implementiras <<<
    // Vrati true ako je stablo BST (za svaki cvor: levo podstablo < cvor < desno).
    public abstract boolean daLiJeBST(CvorStabla k);
}

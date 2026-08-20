package z36_bstUbaci;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Apstraktno binarno stablo pretrage (BST). Koren je CvorStabla.
public abstract class ABSTStablo {
    public CvorStabla koren;

    // Pravi BST:
    //            50
    //          /    \
    //        30      70
    //       /  \    /  \
    //      20  40  60   80      (infiks/rastuce: 20 30 40 50 60 70 80)
    public void generator() {
        koren = new CvorStabla(50,
                    new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                    new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)));
    }

    // Infiks obilazak (za BST daje rastuci redosled) — za proveru
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
    // Ubaci 'x' u BST tako da stablo ostane BST.
    public abstract void ubaci(int x);
}

package z11_brojElemenata;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ABinarnoStablo {
    public CvorStabla koren;

    // Generise test-stablo:
    //            50
    //          /    \
    //        30      70
    //       /  \    /  \
    //      20  40  60   80
    public void generator() {
        koren = new CvorStabla(50,
                    new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                    new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)));
    }

    // Ispis infiks (levi-koren-desni)
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
    public abstract int brojElemenata(CvorStabla k);
}

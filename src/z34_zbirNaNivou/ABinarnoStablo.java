package z34_zbirNaNivou;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ABinarnoStablo {
    public CvorStabla koren;

    //            50            <- nivo 0
    //          /    \
    //        30      70        <- nivo 1  (zbir 100)
    //       /  \    /  \
    //      20  40  60   80     <- nivo 2  (zbir 200)
    public void generator() {
        koren = new CvorStabla(50,
                    new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
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
    // Vrati zbir vrednosti svih cvorova na datom nivou (koren je nivo 0).
    public abstract int zbirNaNivou(CvorStabla k, int nivo);
}

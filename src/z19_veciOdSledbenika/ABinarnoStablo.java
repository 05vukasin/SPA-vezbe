package z19_veciOdSledbenika;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ABinarnoStablo {
    public CvorStabla koren;

    // Koren (50) NIJE veci od svih sledbenika (60 > 50):
    //            50
    //          /    \
    //        60      20
    //       /  \       \
    //      10  25      15
    // Veci od svih svojih sledbenika: 60, 20, 10, 25, 15  -> 5 cvorova
    public void generator() {
        koren = new CvorStabla(50,
                    new CvorStabla(60, new CvorStabla(10), new CvorStabla(25)),
                    new CvorStabla(20, null, new CvorStabla(15)));
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
    // Broj cvorova koji su veci od SVIH svojih sledbenika (listovi se broje).
    public abstract int vratiBrojCvorovaVecihOdSvojihSledbenika(CvorStabla k);
}

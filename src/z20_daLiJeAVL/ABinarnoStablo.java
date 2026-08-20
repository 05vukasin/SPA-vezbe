package z20_daLiJeAVL;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ABinarnoStablo {
    public CvorStabla koren;

    // Balansirano (AVL) stablo:
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

    // Nebalansirano stablo (NIJE AVL): 50 -> 60 -> 70 (samo desno)
    public void generatorNijeAVL() {
        koren = new CvorStabla(50, null,
                    new CvorStabla(60, null, new CvorStabla(70)));
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
    // true ako je stablo AVL (za SVAKI cvor: |visina(levo) - visina(desno)| <= 1).
    public abstract boolean daLiJeAVL(CvorStabla k);
}

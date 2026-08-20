package z12_zbirElemenata;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ABinarnoStablo {
    public CvorStabla koren;

    // Standardno test-stablo (zbir = 350)
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
        infiks(c.levi, sb);
        sb.append(c.podatak).append(" ");
        infiks(c.desni, sb);
    }

    // >>> Metoda koju TI implementiras <<<
    // PUBLIC metoda bez parametra: ako je stablo prazno -> baci izuzetak,
    // inace vrati zbir (savet: pozovi privatnu rekurzivnu metodu sa parametrom).
    public abstract int zbirElemenata();
}

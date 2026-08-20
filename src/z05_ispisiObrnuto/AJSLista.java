package z05_ispisiObrnuto;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class AJSLista {
    public CJSL prvi;

    public void dodajNaKraj(int v) {
        CJSL novi = new CJSL(v);
        if (prvi == null) { prvi = novi; return; }
        CJSL t = prvi;
        while (t.sledeci != null) t = t.sledeci;
        t.sledeci = novi;
    }

    public String ispis() {
        if (prvi == null) return "prazna";
        StringBuilder sb = new StringBuilder();
        CJSL t = prvi;
        while (t != null) {
            sb.append(t.podatak);
            if (t.sledeci != null) sb.append(" -> ");
            t = t.sledeci;
        }
        return sb.toString();
    }

    // >>> Metoda koju TI implementiras <<<
    // Treba da ISPISE elemente (System.out.print/println), a ne da ih vraca.
    public abstract void ispisiObrnuto(CJSL prvi);
}

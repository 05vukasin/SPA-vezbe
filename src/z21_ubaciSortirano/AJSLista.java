package z21_ubaciSortirano;

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
    // Lista je sortirana rastuce; ubaci 'x' tako da OSTANE sortirana.
    public abstract void ubaciSortirano(int x);
}

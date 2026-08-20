package z07_popuniListu;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ADSLista {
    public CDSL prvi;

    public void dodajNaKraj(int v) {
        CDSL novi = new CDSL(v);
        if (prvi == null) { prvi = novi; return; }
        CDSL t = prvi;
        while (t.sledeci != null) t = t.sledeci;
        t.sledeci = novi;
        novi.prethodni = t;
    }

    public String ispis() {
        if (prvi == null) return "prazna";
        StringBuilder sb = new StringBuilder();
        CDSL t = prvi;
        while (t != null) {
            sb.append(t.podatak);
            if (t.sledeci != null) sb.append(" <-> ");
            t = t.sledeci;
        }
        return sb.toString();
    }

    // Ispis samo vrednosti razdvojenih razmakom (za proveru sekvence)
    public String sekvenca() {
        if (prvi == null) return "";
        StringBuilder sb = new StringBuilder();
        CDSL t = prvi;
        while (t != null) {
            sb.append(t.podatak);
            if (t.sledeci != null) sb.append(" ");
            t = t.sledeci;
        }
        return sb.toString();
    }

    // >>> Metoda koju TI implementiras <<<
    public abstract void popuniListu();
}

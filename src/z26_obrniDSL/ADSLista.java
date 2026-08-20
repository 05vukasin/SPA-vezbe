package z26_obrniDSL;

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

    // Vrednosti iduci UNAPRED (preko 'sledeci')
    public String sekvenca() {
        StringBuilder sb = new StringBuilder();
        CDSL t = prvi;
        while (t != null) { sb.append(t.podatak); if (t.sledeci != null) sb.append(" "); t = t.sledeci; }
        return sb.toString();
    }

    // Vrednosti iduci od POSLEDNJEG unazad (preko 'prethodni') — provera prev pokazivaca
    public String sekvencaUnazad() {
        if (prvi == null) return "";
        CDSL t = prvi;
        while (t.sledeci != null) t = t.sledeci; // do kraja
        StringBuilder sb = new StringBuilder();
        while (t != null) { sb.append(t.podatak); if (t.prethodni != null) sb.append(" "); t = t.prethodni; }
        return sb.toString();
    }

    // >>> Metoda koju TI implementiras <<<
    // Obrni dvostruko-spregnutu listu (i 'sledeci' i 'prethodni' moraju biti ispravni).
    public abstract void obrniDSL();
}

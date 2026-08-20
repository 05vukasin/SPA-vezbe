package z25_spojiSortirane;

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

    public String ispis() { return ispisOd(prvi); }

    // Pomocna: ispis proizvoljnog lanca
    public static String ispisOd(CJSL glava) {
        if (glava == null) return "prazna";
        StringBuilder sb = new StringBuilder();
        CJSL t = glava;
        while (t != null) {
            sb.append(t.podatak);
            if (t.sledeci != null) sb.append(" -> ");
            t = t.sledeci;
        }
        return sb.toString();
    }

    // >>> Metoda koju TI implementiras <<<
    // Dva pokazivaca na sortirane (rastuce) liste; vrati NOVU sortiranu listu
    // koja sadrzi sve elemente oba (merge).
    public abstract CJSL spojiSortirane(CJSL a, CJSL b);
}

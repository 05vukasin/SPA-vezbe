package z06_klonirajRekurzivno;

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
        return ispisOd(prvi);
    }

    // Pomocna: ispis proizvoljnog lanca cvorova
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
    // Vraca NOVU listu (nove cvorove) sa istim vrednostima. Rekurzivno.
    public abstract CJSL klonirajRekurzivno(CJSL prvi);
}

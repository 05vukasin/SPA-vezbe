package z01_izbaciTrenutni;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Apstraktna klasa jednostruko spregnute liste. Drzi pokazivac na prvi element.
// Na testu ovakvu klasu dobijes u .jar-u i nasledis je.
public abstract class AJSLista {
    public CJSL prvi;

    // Pomocna: dodaje element na kraj liste (za pravljenje test-podataka)
    public void dodajNaKraj(int v) {
        CJSL novi = new CJSL(v);
        if (prvi == null) {
            prvi = novi;
            return;
        }
        CJSL tekuci = prvi;
        while (tekuci.sledeci != null) tekuci = tekuci.sledeci;
        tekuci.sledeci = novi;
    }

    // Pomocna: vraca cvor na datom indeksu (0-baziran)
    public CJSL cvorNa(int index) {
        CJSL tekuci = prvi;
        for (int i = 0; i < index && tekuci != null; i++) tekuci = tekuci.sledeci;
        return tekuci;
    }

    // Pomocna: ispis liste u obliku "10 -> 20 -> 30"
    public String ispis() {
        if (prvi == null) return "prazna";
        StringBuilder sb = new StringBuilder();
        CJSL tekuci = prvi;
        while (tekuci != null) {
            sb.append(tekuci.podatak);
            if (tekuci.sledeci != null) sb.append(" -> ");
            tekuci = tekuci.sledeci;
        }
        return sb.toString();
    }

    // >>> Metoda koju TI implementiras u klasi JSLista <<<
    public abstract void izbaciTrenutni(CJSL neki);
}

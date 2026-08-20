package z04_zbirUCiklicnoj;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Jednostruko-spregnuta CIKLICNA lista: poslednji cvor pokazuje nazad na 'prvi'.
public abstract class AJSLista {
    public CJSL prvi;

    // Dodaje na kraj DOK JE LISTA JOS LINEARNA (pre zatvaranja ciklusa)
    public void dodajNaKraj(int v) {
        CJSL novi = new CJSL(v);
        if (prvi == null) { prvi = novi; return; }
        CJSL t = prvi;
        while (t.sledeci != null) t = t.sledeci;
        t.sledeci = novi;
    }

    // Zatvara ciklus: poslednji.sledeci = prvi
    public void zatvoriCiklus() {
        if (prvi == null) return;
        CJSL t = prvi;
        while (t.sledeci != null) t = t.sledeci;
        t.sledeci = prvi;
    }

    // Bezbedan ispis ciklicne liste (staje kad se vrati na 'prvi')
    public String ispis() {
        if (prvi == null) return "prazna";
        StringBuilder sb = new StringBuilder();
        CJSL t = prvi;
        do {
            sb.append(t.podatak);
            t = t.sledeci;
            if (t != prvi) sb.append(" -> ");
        } while (t != prvi && t != null);
        return sb.append(" -> (nazad na ").append(prvi.podatak).append(")").toString();
    }

    // >>> Metoda koju TI implementiras <<<
    public abstract int zbirElemenataUCiklicnoj();
}

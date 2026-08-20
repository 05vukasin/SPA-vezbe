package z09_ispisiStekObrnuto;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Stek nad nizom. Koristi push/pop/vrh/prazan u svojoj metodi.
public abstract class AStek {
    private int[] niz = new int[100];
    private int vrh = -1;

    public void push(int x) { niz[++vrh] = x; }
    public int pop()        { return niz[vrh--]; }
    public int vrh()        { return niz[vrh]; }      // peek (ne skida)
    public boolean prazan() { return vrh == -1; }

    // Pomocna za driver: stanje steka od vrha ka dnu, bez menjanja steka
    public String stanjeOdVrha() {
        if (vrh == -1) return "prazan";
        StringBuilder sb = new StringBuilder();
        for (int i = vrh; i >= 0; i--) {
            sb.append(niz[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    // >>> Metoda koju TI implementiras <<<
    // Ispisuje elemente tako da se PRVO UBACENI ispisuju PRVI.
    // Bez pomocnih struktura; stek na kraju mora ostati nepromenjen.
    public abstract void ispisiStekObrnuto();
}

package z28_balansiraneZagrade;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Stek nad nizom (cuva int; karaktere mozes cuvati kao (int) c).
public abstract class AStek {
    private int[] niz = new int[1000];
    private int vrh = -1;

    public void push(int x) { niz[++vrh] = x; }
    public int pop()        { return niz[vrh--]; }
    public int vrh()        { return niz[vrh]; }
    public boolean prazan() { return vrh == -1; }

    // >>> Metoda koju TI implementiras <<<
    // Vrati true ako su zagrade () [] {} u stringu ispravno ugnezdene/balansirane.
    // Ostale karaktere ignorisi.
    public abstract boolean daLiSuBalansirane(String izraz);
}

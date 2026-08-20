package z33_identicna;

// ====== DATO (simulira .jar) — NE DIRATI ======
public abstract class ABinarnoStablo {
    public CvorStabla koren;

    // >>> Metoda koju TI implementiras <<<
    // Vrati true ako su dva stabla identicna (ista struktura I iste vrednosti).
    public abstract boolean daLiSuIdenticna(CvorStabla a, CvorStabla b);
}

package z07_popuniListu;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Cvor dvostruko spregnute liste (CDSL). Ima 'prethodni' i 'sledeci'.
public class CDSL {
    public int podatak;
    public CDSL prethodni;
    public CDSL sledeci;

    public CDSL(int podatak) {
        this.podatak = podatak;
    }
}

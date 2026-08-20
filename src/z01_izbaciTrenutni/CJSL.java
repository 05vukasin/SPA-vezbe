package z01_izbaciTrenutni;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Cvor jednostruko spregnute liste (CJSL = Cvor Jednostruko Spregnute Liste)
public class CJSL {
    public int podatak;
    public CJSL sledeci;

    public CJSL(int podatak) {
        this.podatak = podatak;
    }
}

package z39_bstIspisiRastuce;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Cvor binarnog stabla.
public class CvorStabla {
    public int podatak;
    public CvorStabla levi;
    public CvorStabla desni;

    public CvorStabla(int podatak) {
        this.podatak = podatak;
    }

    // Zgodan konstruktor za brzo pravljenje stabla u generatoru
    public CvorStabla(int podatak, CvorStabla levi, CvorStabla desni) {
        this.podatak = podatak;
        this.levi = levi;
        this.desni = desni;
    }
}

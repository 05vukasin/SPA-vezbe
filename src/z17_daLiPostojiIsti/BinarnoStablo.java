package z17_daLiPostojiIsti;

/**
 * ============================ ZADATAK z17 ============================
 *  Naslov:  Da li postoji cvor sa istom vrednoscu
 *
 *  Opis:    Dat je koren binarnog stabla i pokazivac na jedan cvor 'cvor'.
 *           Napisati metodu koja vraca true ako u stablu postoji JOS NEKI
 *           cvor sa istom vrednoscu kao 'cvor' (a razlicit od njega), inace
 *           false.
 *
 *  Primer:  stablo: 50(30(20,40), 70(30,80))
 *           cvor = levi 30  ->  true  (postoji jos jedan 30)
 *           cvor = 20       ->  false (jedini je)
 *
 *  Ogranicenja:
 *    - Ne racunaj sam 'cvor' kao "istog" (poredi po objektu: c != cvor).
 * ====================================================================
 */
public class BinarnoStablo extends ABinarnoStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public boolean daLiPostojiIsti(CvorStabla k, CvorStabla cvor) {
        throw new UnsupportedOperationException("TODO: daLiPostojiIsti");
    }
}

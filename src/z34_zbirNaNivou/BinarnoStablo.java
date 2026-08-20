package z34_zbirNaNivou;

/**
 * ============================ ZADATAK z34 ============================
 *  Naslov:  Zbir cvorova na datom nivou
 *
 *  Opis:    Dat je koren binarnog stabla i ceo broj 'nivo'. Napisati metodu
 *           koja vraca zbir vrednosti svih cvorova koji se nalaze na tom nivou.
 *           Koren je na nivou 0, njegova deca na nivou 1, itd.
 *
 *  Primer:  50(30(20,40), 70(60,80))
 *           nivo 1  ->  100  (30 + 70)
 *           nivo 2  ->  200  (20 + 40 + 60 + 80)
 *
 *  Ogranicenja:
 *    - Savet: rekurzija koja smanjuje 'nivo' za 1 pri svakom spustanju.
 * ====================================================================
 */
public class BinarnoStablo extends ABinarnoStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public int zbirNaNivou(CvorStabla k, int nivo) {
        throw new UnsupportedOperationException("TODO: zbirNaNivou");
    }
}

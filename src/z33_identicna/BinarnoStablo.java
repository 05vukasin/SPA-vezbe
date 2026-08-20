package z33_identicna;

/**
 * ============================ ZADATAK z33 ============================
 *  Naslov:  Da li su dva stabla identicna
 *
 *  Opis:    Data su korena dva binarna stabla. Napisati metodu koja vraca
 *           true ako su stabla identicna — imaju istu strukturu (isti oblik)
 *           i iste vrednosti u odgovarajucim cvorovima.
 *
 *  Primer:  a = 50(30(20,40), 70(60,80))
 *           b = 50(30(20,40), 70(60,80))  ->  true
 *           c = 50(30(20,40), 70(60,99))  ->  false
 *
 *  Ogranicenja:
 *    - Dva prazna stabla su identicna. Rekurzija.
 * ====================================================================
 */
public class BinarnoStablo extends ABinarnoStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public boolean daLiSuIdenticna(CvorStabla a, CvorStabla b) {
        throw new UnsupportedOperationException("TODO: daLiSuIdenticna");
    }
}

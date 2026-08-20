package z12_zbirElemenata;

/**
 * ============================ ZADATAK z12 ============================
 *  Naslov:  Zbir elemenata (public/private + Exception)
 *
 *  Opis:    Dat je koren binarnog stabla sa celim brojevima. Napisati
 *           metodu koja vraca zbir svih cvorova. Ako je stablo PRAZNO,
 *           metoda treba da baci izuzetak (npr. RuntimeException).
 *
 *           Ideja (obrazac sa vezbi):
 *             - PUBLIC zbirElemenata(): proveri da li je koren == null;
 *               ako jeste -> throw new RuntimeException("prazno stablo");
 *               inace vrati rezultat privatne rekurzivne metode.
 *             - PRIVATE zbir(CvorStabla k): rekurzija k.podatak + levo + desno.
 *
 *  Primer:  stablo:  50(30(20,40), 70(60,80))  ->  zbir 350
 *           prazno:  baca izuzetak
 *
 *  Ogranicenja:
 *    - Privatnu pomocnu metodu mozes slobodno dodati u ovu klasu.
 * ====================================================================
 */
public class BinarnoStablo extends ABinarnoStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public int zbirElemenata() throws RuntimeException {
        throw new UnsupportedOperationException("TODO: zbirElemenata");
    }
}

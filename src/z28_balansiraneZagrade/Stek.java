package z28_balansiraneZagrade;

/**
 * ============================ ZADATAK z28 ============================
 *  Naslov:  Balansirane zagrade
 *
 *  Opis:    Dat je string koji sadrzi zagrade ( ) [ ] { } i druge karaktere.
 *           Napisati metodu koja vraca true ako su sve zagrade ispravno
 *           otvorene i zatvorene i pravilno ugnezdene, inace false.
 *           Koristi STEK.
 *
 *  Primer:  "(a[b]{c})"  ->  true
 *           "(a]"        ->  false   (pogresan par)
 *           "(()"        ->  false   (visak otvorene)
 *
 *  Ogranicenja:
 *    - Karaktere koji nisu zagrade ignorisi.
 *    - Savet: otvorenu zagradu 'push', zatvorenu uporedi sa 'pop'.
 * ====================================================================
 */
public class Stek extends AStek {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public boolean daLiSuBalansirane(String izraz) {
        throw new UnsupportedOperationException("TODO: daLiSuBalansirane");
    }
}

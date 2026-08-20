package z20_daLiJeAVL;

/**
 * ============================ ZADATAK z20 ============================
 *  Naslov:  Da li je stablo AVL
 *
 *  Opis:    Dat je koren binarnog stabla. Napisati metodu koja vraca true
 *           ako je stablo AVL, a false u suprotnom. Stablo je AVL ako za
 *           SVAKI cvor vazi da se visine njegovog levog i desnog podstabla
 *           razlikuju za najvise 1.
 *
 *  Primer:  50(30(20,40), 70(60,80))  ->  true  (balansirano)
 *           50(_, 60(_, 70))          ->  false (kod 50 je razlika visina 2)
 *
 *  Ogranicenja:
 *    - Savet: pomocna metoda koja vraca visinu, a "-1" moze da signalizira
 *      da je vec negde prekrsen uslov (efikasno, jedan prolaz).
 * ====================================================================
 */
public class BinarnoStablo extends ABinarnoStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public boolean daLiJeAVL(CvorStabla k){
        throw new UnsupportedOperationException("TODO: daLiJeAVL");
    }
}

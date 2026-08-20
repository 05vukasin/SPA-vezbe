package z40_bstIzbaci;

/**
 * ============================ ZADATAK z40 ============================
 *  Naslov:  Izbacivanje iz BST
 *
 *  Opis:    Dat je koren BST-a. Napisati metodu koja izbacuje cvor sa
 *           vrednoscu 'x' tako da stablo nakon izbacivanja ostane BST.
 *
 *  Primer:  BST: 20 30 40 50 60 70 80,  izbaci 30 (ima dvoje dece)
 *           rezultat: 20 40 50 60 70 80
 *
 *  Ogranicenja:
 *    - Tri slucaja: list; cvor sa jednim detetom; cvor sa dvoje dece
 *      (zameni ga najmanjim iz desnog podstabla ili najvecim iz levog).
 * ====================================================================
 */
public class BSTStablo extends ABSTStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public void izbaci(int x) {
        throw new UnsupportedOperationException("TODO: izbaci");
    }
}

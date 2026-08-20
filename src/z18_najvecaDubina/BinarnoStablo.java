package z18_najvecaDubina;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================ ZADATAK z18 ============================
 *  Naslov:  Cvor na najvecoj dubini
 *
 *  Opis:    Dat je koren binarnog stabla. Napisati metodu koja vraca
 *           pokazivac na cvor koji se nalazi na najvecoj dubini u stablu.
 *
 *  Primer:  stablo: 50(30(20(10,_),_), 70(_,80))  ->  najdublji cvor: 10
 *
 *  Ogranicenja:
 *    - Ako ima vise cvorova na istoj (najvecoj) dubini, dovoljno je vratiti
 *      bilo koji od njih. (U ovom test-primeru najdublji je jedinstven.)
 *    - Moze rekurzivno (prati dubinu) ili BFS-om (poslednji obidjeni cvor).
 * ====================================================================
 */
public class BinarnoStablo extends ABinarnoStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public CvorStabla vratiCvorNaNajvecojDubini(CvorStabla k) {
        throw new UnsupportedOperationException("TODO: vratiCvorNaNajvecojDubini");
    }
}

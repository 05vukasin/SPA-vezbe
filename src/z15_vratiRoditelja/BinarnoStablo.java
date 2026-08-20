package z15_vratiRoditelja;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================ ZADATAK z15 ============================
 *  Naslov:  Vrati roditelja cvora sa datom vrednoscu
 *
 *  Opis:    Dat je koren binarnog stabla i vrednost. Napisati metodu koja
 *           vraca pokazivac na RODITELJA cvora koji sadrzi tu vrednost.
 *
 *  Primer:  stablo: 50(30(20,40), 70(60,80))
 *           vrednost 40  ->  roditelj 30
 *           vrednost 50  ->  null (koren nema roditelja)
 *
 *  Ogranicenja:
 *    - Ako vrednost ne postoji, ili je u korenu -> vrati null.
 * ====================================================================
 */
public class BinarnoStablo extends ABinarnoStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public CvorStabla vratiRoditelja(CvorStabla k, int vrednost) {
        throw new UnsupportedOperationException("TODO: vratiRoditelja");
    }
}

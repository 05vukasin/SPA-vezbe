package z35_daLiJeBST;

/**
 * ============================ ZADATAK z35 ============================
 *  Naslov:  Da li je stablo BST
 *
 *  Opis:    Dat je koren binarnog stabla. Napisati metodu koja vraca true ako
 *           je stablo binarno stablo pretrage (BST): za SVAKI cvor sve
 *           vrednosti u levom podstablu su manje, a u desnom vece od cvora.
 *
 *  Primer:  50(30(20,40), 70(60,80))  ->  true
 *           50(30(20,90), 70(60,80))  ->  false  (90 je levo od 50, a vece)
 *
 *  Ogranicenja:
 *    - PAZI: nije dovoljno gledati samo dete-roditelj; ceo levi/desni opseg mora
 *      da vazi. Savet: prosledjuj dozvoljeni interval (min, max).
 * ====================================================================
 */
public class BinarnoStablo extends ABinarnoStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public boolean daLiJeBST(CvorStabla k) {
        throw new UnsupportedOperationException("TODO: daLiJeBST");
    }
}

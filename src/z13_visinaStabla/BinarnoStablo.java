package z13_visinaStabla;

/**
 * ============================ ZADATAK z13 ============================
 *  Naslov:  Visina stabla
 *
 *  Opis:    Dat je koren binarnog stabla. Napisati metodu koja vraca visinu
 *           stabla — broj cvorova na najduzoj putanji od korena do lista.
 *
 *  Konvencija:  prazno stablo = 0, jedan cvor = 1.
 *
 *  Primer:  stablo:  50(30(20,40), 70(60,80))  ->  visina 3
 *
 *  Ogranicenja:
 *    - Rekurzija: visina = 1 + max(visina(levo), visina(desno)).
 * ====================================================================
 */
public class BinarnoStablo extends ABinarnoStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public int visinaStabla(CvorStabla k){
        throw new UnsupportedOperationException("TODO: visinaStabla");
    }
}

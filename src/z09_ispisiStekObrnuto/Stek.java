package z09_ispisiStekObrnuto;

/**
 * ============================ ZADATAK z09 ============================
 *  Naslov:  Ispisi stek obrnuto (bez pomocne strukture)
 *
 *  Opis:    Dat je stek. Napisati metodu koja ispisuje elemente steka u
 *           obrnutom redosledu — elementi koji su PRVO ubaceni ispisuju se
 *           PRVI (tj. od dna ka vrhu). Nije dozvoljeno koriscenje pomocnih
 *           struktura. Posle izvrsenja stek mora ostati u istom stanju kao
 *           pre poziva. (Savet: rekurzija — pop, rekurzija, ispis, push.)
 *
 *  Primer:  push redom: 10, 20, 30, 40   (40 je na vrhu)
 *           ispis:      10 20 30 40
 *           stek posle: nepromenjen (vrh je i dalje 40)
 *
 *  Ogranicenja:
 *    - Samo push/pop/vrh/prazan; nikakav niz/lista/drugi stek.
 * ====================================================================
 */
public class Stek extends AStek {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public void ispisiStekObrnuto(){
        throw new UnsupportedOperationException("TODO: ispisiStekObrnuto");
    }
}

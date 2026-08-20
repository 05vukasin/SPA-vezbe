package z19_veciOdSledbenika;

/**
 * ============================ ZADATAK z19 ============================
 *  Naslov:  Broj cvorova vecih od svih svojih sledbenika
 *
 *  Opis:    Dat je koren binarnog stabla. Napisati metodu koja vraca broj
 *           cvorova koji su STROGO veci od svih svojih sledbenika (svih
 *           cvorova u svom levom i desnom podstablu). Listovi (koji nemaju
 *           sledbenike) se TAKODJE broje.
 *
 *  Primer:  stablo: 50(60(10,25), 20(_,15))
 *           - 50: ima sledbenika 60 (>50) -> NE
 *           - 60,20,10,25,15 -> DA
 *           rezultat: 5
 *
 *  Ogranicenja:
 *    - Savet: pomocna metoda koja vraca maksimum podstabla olaksava proveru.
 * ====================================================================
 */
public class BinarnoStablo extends ABinarnoStablo {

    // ====== TVOJ ZADATAK — implementiraj metod ispod ======
    @Override
    public int vratiBrojCvorovaVecihOdSvojihSledbenika(CvorStabla k) {
        throw new UnsupportedOperationException("TODO: vratiBrojCvorovaVecihOdSvojihSledbenika");
    }
}

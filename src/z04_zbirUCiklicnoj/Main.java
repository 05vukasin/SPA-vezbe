package z04_zbirUCiklicnoj;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        JSLista lista = new JSLista();
        lista.dodajNaKraj(5);
        lista.dodajNaKraj(10);
        lista.dodajNaKraj(15);
        lista.dodajNaKraj(20);
        lista.zatvoriCiklus();

        int ocekivano = 50;

        System.out.println("=== z04 zbirElemenataUCiklicnoj ===");
        System.out.println("lista:      " + lista.ispis());

        String dobijeno;
        boolean pass = false;
        try {
            int rez = lista.zbirElemenataUCiklicnoj();
            dobijeno = String.valueOf(rez);
            pass = (rez == ocekivano);
        } catch (Exception e) {
            dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }
}

package z01_izbaciTrenutni;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Driver: pravi test-podatke, poziva tvoju metodu i proverava rezultat.
public class Main {
    public static void main(String[] args) {
        JSLista lista = new JSLista();
        lista.dodajNaKraj(10);
        lista.dodajNaKraj(20);
        lista.dodajNaKraj(30);
        lista.dodajNaKraj(40);

        CJSL neki = lista.cvorNa(2); // cvor sa vrednoscu 30
        String ocekivano = "10 -> 20 -> 40";

        System.out.println("=== z01 izbaciTrenutni ===");
        System.out.println("pocetna:    " + lista.ispis());
        System.out.println("izbacujem:  " + neki.podatak);

        String dobijeno;
        try {
            lista.izbaciTrenutni(neki);
            dobijeno = lista.ispis();
        } catch (Exception e) {
            dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (ocekivano.equals(dobijeno) ? "PASS" : "FAIL"));
    }
}

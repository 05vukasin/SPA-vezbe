package z23_izbaciSve;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        JSLista lista = new JSLista();
        for (int v : new int[]{10, 20, 10, 30, 10}) lista.dodajNaKraj(v);

        String ocekivano = "20 -> 30";

        System.out.println("=== z23 izbaciSve ===");
        System.out.println("pocetna:    " + lista.ispis());
        System.out.println("izbacujem:  10");

        String dobijeno;
        try { lista.izbaciSve(10); dobijeno = lista.ispis(); }
        catch (Exception e) { dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")"; }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (ocekivano.equals(dobijeno) ? "PASS" : "FAIL"));
    }
}

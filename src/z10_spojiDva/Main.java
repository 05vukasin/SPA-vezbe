package z10_spojiDva;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        Niz zadatak = new Niz();
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};

        String ocekivano = "6 5 4 3 2 1";

        System.out.println("=== z10 spojiDva ===");
        System.out.println("a:          " + ANiz.kaoTekst(a));
        System.out.println("b:          " + ANiz.kaoTekst(b));

        String dobijeno;
        try {
            int[] rez = zadatak.spojiDva(a, b);
            dobijeno = ANiz.kaoTekst(rez);
        } catch (Exception e) {
            dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (ocekivano.equals(dobijeno) ? "PASS" : "FAIL"));
    }
}

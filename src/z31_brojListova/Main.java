package z31_brojListova;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BinarnoStablo stablo = new BinarnoStablo();
        stablo.generator();

        int ocekivano = 4;
        System.out.println("=== z31 brojListova ===");
        System.out.println("stablo (infiks): " + stablo.ispisInfiks());

        String dobijeno; boolean pass = false;
        try { int r = stablo.brojListova(stablo.koren); dobijeno = String.valueOf(r); pass = (r == ocekivano); }
        catch (Exception e) { dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")"; }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (pass ? "PASS" : "FAIL"));
    }
}

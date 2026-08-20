package z32_ogledalo;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        BinarnoStablo stablo = new BinarnoStablo();
        stablo.generator();

        String ocekivano = "80 70 60 50 40 30 20";
        System.out.println("=== z32 napraviOgledalo ===");
        System.out.println("pre (infiks):   " + stablo.ispisInfiks());

        String dobijeno;
        try { stablo.napraviOgledalo(stablo.koren); dobijeno = stablo.ispisInfiks(); }
        catch (Exception e) { dobijeno = e.getClass().getSimpleName() + " (" + e.getMessage() + ")"; }

        System.out.println("ocekivano:  " + ocekivano);
        System.out.println("dobijeno:   " + dobijeno);
        System.out.println("REZULTAT:   " + (ocekivano.equals(dobijeno) ? "PASS" : "FAIL"));
    }
}

package z12_zbirElemenata;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    public static void main(String[] args) {
        System.out.println("=== z12 zbirElemenata ===");

        // --- Provera 1: neprazno stablo -> zbir 350 ---
        BinarnoStablo stablo = new BinarnoStablo();
        stablo.generator();
        System.out.println("stablo (infiks): " + stablo.ispisInfiks());

        boolean provera1 = false;
        String d1;
        try {
            int rez = stablo.zbirElemenata();
            d1 = String.valueOf(rez);
            provera1 = (rez == 350);
        } catch (Exception e) {
            d1 = e.getClass().getSimpleName() + " (" + e.getMessage() + ")";
        }
        System.out.println("[1] zbir: ocekivano=350   dobijeno=" + d1 + "   -> " + (provera1 ? "OK" : "NIJE"));

        // --- Provera 2: prazno stablo -> mora baciti izuzetak (ne UnsupportedOperation) ---
        BinarnoStablo prazno = new BinarnoStablo(); // koren == null
        boolean provera2 = false;
        String d2;
        try {
            int rez = prazno.zbirElemenata();
            d2 = "vratio " + rez + " (a trebalo je da baci izuzetak)";
        } catch (UnsupportedOperationException e) {
            d2 = "jos nije implementirano";
        } catch (Exception e) {
            d2 = "bacio " + e.getClass().getSimpleName();
            provera2 = true;
        }
        System.out.println("[2] prazno stablo baca izuzetak: dobijeno=" + d2 + "   -> " + (provera2 ? "OK" : "NIJE"));

        System.out.println("REZULTAT:   " + (provera1 && provera2 ? "PASS" : "FAIL"));
    }
}

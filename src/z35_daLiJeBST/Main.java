package z35_daLiJeBST;

// ====== DATO (simulira .jar) — NE DIRATI ======
// Napomena: BST je STROG — levo < cvor < desno (duplikati NISU dozvoljeni).
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z35 daLiJeBST ===");

        // ispravan BST
        oceni("ispravan BST", "true", bst(new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)))));
        // nije BST: 90 je levo od 50 (dete-roditelj lokalno ok za 30, ali opseg pada)
        oceni("nije BST (90 levo od 50)", "false", bst(new CvorStabla(50,
                new CvorStabla(30, new CvorStabla(20), new CvorStabla(90)),
                new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)))));
        // klasican tricky: cvor u desnom podstablu manji od pretka
        // 10(5, 15(6,20)) -> 6 je u desnom podstablu 10, a 6 < 10
        oceni("tricky (6 < predak 10)", "false", bst(new CvorStabla(10,
                new CvorStabla(5),
                new CvorStabla(15, new CvorStabla(6), new CvorStabla(20)))));
        // jedan cvor -> BST
        oceni("jedan cvor", "true", bst(new CvorStabla(42)));
        // prazno -> BST
        oceni("prazno (null)", "true", bst(null));
        // duplikat: 10(10,20) -> nije strogi BST
        oceni("duplikat (levo == koren)", "false", bst(new CvorStabla(10,
                new CvorStabla(10), new CvorStabla(20))));
        // negativne vrednosti, validan BST: 0(-5(-10,-2),5(3,8))
        oceni("negativne vrednosti (validan)", "true", bst(new CvorStabla(0,
                new CvorStabla(-5, new CvorStabla(-10), new CvorStabla(-2)),
                new CvorStabla(5, new CvorStabla(3), new CvorStabla(8)))));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String bst(CvorStabla k) {
        try {
            return String.valueOf(new BinarnoStablo().daLiJeBST(k));
        } catch (Exception e) {
            return e.getClass().getSimpleName();
        }
    }

    static void oceni(String naziv, String ocekivano, String dobijeno) {
        ukupno++;
        boolean ok = ocekivano.equals(dobijeno);
        if (ok) proslo++;
        System.out.println((ok ? "  [PASS] " : "  [FAIL] ") + naziv
                + "   ->  ocekivano: " + ocekivano + " | dobijeno: " + dobijeno);
    }
}

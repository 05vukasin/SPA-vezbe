package z19_veciOdSledbenika;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z19 vratiBrojCvorovaVecihOdSvojihSledbenika ===");

        // 1) primer iz zaglavlja -> 5 (60,20,10,25,15; koren 50 NE jer 60>50)
        oceni("primer iz zaglavlja", "5",
                test(cv(50, cv(60, cv(10), cv(25)), cv(20, null, cv(15)))));

        // 2) sve raste na dole -> broje se samo listovi (4,5,6) -> 3
        oceni("raste na dole (samo listovi)", "3",
                test(cv(1, cv(2, cv(4), cv(5)), cv(3, null, cv(6)))));

        // 3) sve opada na dole -> svaki cvor > svih sledbenika -> svih 7
        oceni("opada na dole (svih 7)", "7",
                test(cv(50, cv(40, cv(20), cv(30)), cv(45, cv(10), cv(35)))));

        // 4) jedan cvor (list) -> uvek se broji -> 1
        oceni("jedan cvor (list)", "1", test(cv(7)));

        // 5) negativne vrednosti -> 5 (-1,-8,-2,-4,-9; -3 NE jer -2>-3)
        oceni("negativni", "5",
                test(cv(-1, cv(-3, cv(-8), cv(-2)), cv(-4, null, cv(-9)))));

        // 6) nula veca od negativnih listova -> koren + dva lista -> 3
        oceni("nula i negativni listovi", "3",
                test(cv(0, cv(-5, null, null), cv(-2, null, null))));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String test(CvorStabla koren) {
        try {
            BinarnoStablo s = new BinarnoStablo();
            s.koren = koren;
            return String.valueOf(s.vratiBrojCvorovaVecihOdSvojihSledbenika(koren));
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

    static CvorStabla cv(int v, CvorStabla l, CvorStabla d) { return new CvorStabla(v, l, d); }
    static CvorStabla cv(int v) { return new CvorStabla(v); }
}

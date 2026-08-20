package z14_vratiNajveci;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z14 vratiNajveci ===");

        // jedan cvor -> on sam
        oceni("jedan cvor (42)", "42", najveci(new CvorStabla(42)));

        // najveci u KORENU: 100(50(10,20),70) -> 100
        oceni("max u korenu (100)", "100",
                najveci(new CvorStabla(100,
                        new CvorStabla(50, new CvorStabla(10), new CvorStabla(20)),
                        new CvorStabla(70))));

        // najveci u LEVOM podstablu (nije BST): 50(90(20,40),70(60,_)) -> 90
        oceni("max u levom (90)", "90",
                najveci(new CvorStabla(50,
                        new CvorStabla(90, new CvorStabla(20), new CvorStabla(40)),
                        new CvorStabla(70, new CvorStabla(60), null))));

        // najveci u DESNOM podstablu: 50(90(20,40),70(95,_)) -> 95
        oceni("max u desnom (95)", "95",
                najveci(new CvorStabla(50,
                        new CvorStabla(90, new CvorStabla(20), new CvorStabla(40)),
                        new CvorStabla(70, new CvorStabla(95), null))));

        // sve negativne: -50(-90(-20,-40),-10) -> -10
        oceni("negativne (-10)", "-10",
                najveci(new CvorStabla(-50,
                        new CvorStabla(-90, new CvorStabla(-20), new CvorStabla(-40)),
                        new CvorStabla(-10))));

        // duplikati maksimuma: 50(50,30(50,_)) -> 50
        oceni("duplikat max (50)", "50",
                najveci(new CvorStabla(50,
                        new CvorStabla(50),
                        new CvorStabla(30, new CvorStabla(50), null))));

        // koso desno rastuce: 1(_,2(_,3)) -> 3
        oceni("koso desno (3)", "3",
                najveci(new CvorStabla(1, null,
                        new CvorStabla(2, null, new CvorStabla(3)))));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    static String najveci(CvorStabla koren) {
        try {
            CvorStabla r = new BinarnoStablo().vratiNajveci(koren);
            return (r == null) ? "null" : String.valueOf(r.podatak);
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

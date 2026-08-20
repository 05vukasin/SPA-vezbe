package z20_daLiJeAVL;

// ====== DODATNI TEST — NE DIRATI ======
public class TestExtra {
    static int ukupno = 0, palo = 0;

    public static void main(String[] args) {
        BinarnoStablo s = new BinarnoStablo();

        // balansirano, BST-poredak
        test("balansirano BST", cv(50, cv(30, cv(20), cv(40)), cv(70, cv(60), cv(80))), s);   // true
        // balansirano ALI levo dete > roditelj (nije BST-poredak) -> i dalje AVL
        test("balansirano NE-BST", cv(50, cv(90, cv(20), cv(40)), cv(70, cv(60), cv(80))), s); // true
        // nebalansirano ali BST-poredak (levi lanac) -> NIJE AVL
        test("nebalansirano BST", cv(50, cv(30, cv(20, cv(10), null), null), cv(70, null, null)), s); // false
        // klasicno koso desno
        test("koso desno", cv(50, null, cv(60, null, cv(70))), s);                             // false
        // jedan cvor
        test("jedan cvor", cv(42, null, null), s);                                             // true
        // razlika tacno 1 -> jeste AVL
        test("razlika 1", cv(50, cv(30, cv(20), null), cv(70)), s);                            // true

        System.out.println("\n===================================");
        System.out.println("UKUPNO: " + ukupno + "   PALO: " + palo);
        System.out.println(palo == 0 ? "SVE OK z20" : "IMA GRESAKA z20 -> pogledaj gore");
    }

    static void test(String naziv, CvorStabla koren, BinarnoStablo s) {
        s.koren = koren;
        boolean tvoj = s.daLiJeAVL(koren);
        boolean ref = refAVL(koren);
        ukupno++;
        if (tvoj != ref) palo++;
        System.out.println((tvoj == ref ? "  ok   " : "GRESKA ") + naziv + ":  tvoj=" + tvoj + "  tacno=" + ref);
    }

    // ISPRAVNA referenca: -1 znaci "nije AVL"
    static boolean refAVL(CvorStabla k) { return h(k) != -1; }
    static int h(CvorStabla k) {
        if (k == null) return 0;
        int l = h(k.levi); if (l == -1) return -1;
        int d = h(k.desni); if (d == -1) return -1;
        if (Math.abs(l - d) > 1) return -1;
        return 1 + Math.max(l, d);
    }

    static CvorStabla cv(int v, CvorStabla l, CvorStabla d) { return new CvorStabla(v, l, d); }
    static CvorStabla cv(int v) { return new CvorStabla(v); }
}

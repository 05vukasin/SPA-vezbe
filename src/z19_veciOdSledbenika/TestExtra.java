package z19_veciOdSledbenika;

// ====== DODATNI TEST — NE DIRATI ======
public class TestExtra {
    static int ukupno = 0, palo = 0;

    public static void main(String[] args) {
        BinarnoStablo s = new BinarnoStablo();

        test("standard pozitivni", cv(50, cv(60, cv(10), cv(25)), cv(20, null, cv(15))), s); // ref 5
        test("jedan cvor = 0", cv(0, null, null), s);                                          // list uvek broji
        test("negativni", cv(-5, cv(-10, null, null), null), s);                               // -5 > -10
        test("svi negativni", cv(-1, cv(-3, cv(-8), cv(-2)), cv(-4, null, cv(-9))), s);
        test("nule i negativni", cv(0, cv(-5, null, null), cv(-2, null, null)), s);

        System.out.println("\n===================================");
        System.out.println("UKUPNO: " + ukupno + "   PALO: " + palo);
        System.out.println(palo == 0 ? "SVE OK z19" : "IMA GRESAKA z19 -> pogledaj gore");
    }

    static void test(String naziv, CvorStabla koren, BinarnoStablo s) {
        s.koren = koren;
        int tvoj = s.vratiBrojCvorovaVecihOdSvojihSledbenika(koren);
        int ref = refBroj(koren);
        ukupno++;
        if (tvoj != ref) palo++;
        System.out.println((tvoj == ref ? "  ok   " : "GRESKA ") + naziv + ":  tvoj=" + tvoj + "  tacno=" + ref);
    }

    // ISPRAVNA referenca (prazno podstablo se tretira kao "nema sledbenika")
    static int refBroj(CvorStabla k) {
        if (k == null) return 0;
        boolean self = veciOdSvih(k.podatak, k.levi) && veciOdSvih(k.podatak, k.desni);
        return (self ? 1 : 0) + refBroj(k.levi) + refBroj(k.desni);
    }
    static boolean veciOdSvih(int v, CvorStabla sub) {
        if (sub == null) return true;
        return v > sub.podatak && veciOdSvih(v, sub.levi) && veciOdSvih(v, sub.desni);
    }

    static CvorStabla cv(int v, CvorStabla l, CvorStabla d) { return new CvorStabla(v, l, d); }
    static CvorStabla cv(int v) { return new CvorStabla(v); }
}

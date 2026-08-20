package z17_daLiPostojiIsti;

import java.util.ArrayList;

// ====== DODATNI TEST — NE DIRATI ======
// Za svako stablo i SVAKI cvor u njemu poredi tvoj daLiPostojiIsti sa
// brute-force referencom (prebroj koliko cvorova ima istu vrednost; ako ih
// ima >= 2 -> tacan odgovor je true).
public class TestExtra {
    static int ukupno = 0, palo = 0;

    public static void main(String[] args) {
        BinarnoStablo s = new BinarnoStablo();

        // 1) klasican slucaj sa jednim duplikatom (30)
        test("dva 30", cv(50, cv(30, cv(20), cv(40)), cv(70, cv(30), cv(80))), s);

        // 2) bez ijednog duplikata
        test("svi razliciti", cv(50, cv(30, cv(20), cv(40)), cv(70, cv(60), cv(80))), s);

        // 3) SVE iste vrednosti
        test("svi 7", cv(7, cv(7, cv(7), cv(7)), cv(7, cv(7), cv(7))), s);

        // 4) duplikat je koren i list (vrednost 50 dva puta: koren i dole desno)
        test("koren duplikat", cv(50, cv(30, cv(20), cv(50)), cv(70, null, cv(80))), s);

        // 5) tri iste vrednosti (33 x3) + ostali jedinstveni
        test("tri 33", cv(10, cv(33, cv(5), cv(33)), cv(33, null, cv(99))), s);

        // 6) jedan cvor (nikad nema duplikat)
        test("jedan cvor", cv(42, null, null), s);

        // 7) negativne i nula vrednosti, duplikat -5
        test("negativni", cv(0, cv(-5, cv(-5), cv(3)), cv(8, null, cv(0))), s);

        // 8) degenerisano (samo desno), duplikat 2 na kraju
        test("koso desno", cv(1, null, cv(2, null, cv(3, null, cv(2, null, null)))), s);

        // 9) duplikat u istom podstablu (predak-potomak: 15 -> 15)
        test("predak-potomak", cv(100, cv(15, cv(15), cv(9)), cv(200, null, null)), s);

        System.out.println("\n===================================");
        System.out.println("UKUPNO provera: " + ukupno + "   PALO: " + palo);
        System.out.println(palo == 0 ? "SVE OK ✔  z17 radi na svim primerima" : "IMA GRESAKA �’ pogledaj gore");
    }

    // Testira dato stablo: za svaki cvor uporedi tvoj rezultat sa referencom.
    static void test(String naziv, CvorStabla koren, BinarnoStablo s) {
        s.koren = koren;
        ArrayList<CvorStabla> svi = new ArrayList<>();
        skupi(koren, svi);
        System.out.println("\n--- " + naziv + " (cvorova: " + svi.size() + ") ---");
        for (CvorStabla c : svi) {
            boolean tvoj = s.daLiPostojiIsti(koren, c);
            boolean ref  = brojIste(koren, c.podatak) >= 2; // ima li JOS neki iste vrednosti
            ukupno++;
            String oznaka = (tvoj == ref) ? "ok" : "  <<< GRESKA";
            if (tvoj != ref) palo++;
            System.out.println("  cvor=" + c.podatak + "  tvoj=" + tvoj + "  tacno=" + ref + "  " + oznaka);
        }
    }

    static void skupi(CvorStabla k, ArrayList<CvorStabla> out) {
        if (k == null) return;
        out.add(k);
        skupi(k.levi, out);
        skupi(k.desni, out);
    }

    static int brojIste(CvorStabla k, int v) {
        if (k == null) return 0;
        return (k.podatak == v ? 1 : 0) + brojIste(k.levi, v) + brojIste(k.desni, v);
    }

    // skraceni konstruktori za pravljenje stabla
    static CvorStabla cv(int v, CvorStabla l, CvorStabla d) { return new CvorStabla(v, l, d); }
    static CvorStabla cv(int v) { return new CvorStabla(v); }
}

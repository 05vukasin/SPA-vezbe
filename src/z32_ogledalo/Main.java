package z32_ogledalo;

// ====== DATO (simulira .jar) — NE DIRATI ======
public class Main {
    static int ukupno = 0, proslo = 0;

    public static void main(String[] args) {
        System.out.println("=== z32 napraviOgledalo ===");

        // prazno: infiks pre "" -> posle ""
        oceni("prazno (null koren)", "", ogledalo(null));
        // jedan cvor: "42" -> "42"
        oceni("jedan cvor", "42", ogledalo(new CvorStabla(42)));
        // dva levo: 2(1,-) infiks "1 2" -> "2 1"
        oceni("dva cvora (levo)", "2 1",
                ogledalo(new CvorStabla(2, new CvorStabla(1), null)));
        // dva desno: 1(-,2) infiks "1 2" -> "2 1"
        oceni("dva cvora (desno)", "2 1",
                ogledalo(new CvorStabla(1, null, new CvorStabla(2))));
        // koso levo: 3(2(1,-),-) infiks "1 2 3" -> "3 2 1"
        oceni("koso levo", "3 2 1",
                ogledalo(new CvorStabla(3, new CvorStabla(2, new CvorStabla(1), null), null)));
        // asimetricno: 1(2(4,-),3) infiks "4 2 1 3" -> ogledalo "3 1 2 4"
        oceni("asimetricno", "3 1 2 4",
                ogledalo(new CvorStabla(1,
                        new CvorStabla(2, new CvorStabla(4), null),
                        new CvorStabla(3))));
        // balansirano 50(30(20,40),70(60,80)) infiks "20 30 40 50 60 70 80" -> obrnuto
        oceni("balansirano", "80 70 60 50 40 30 20",
                ogledalo(new CvorStabla(50,
                        new CvorStabla(30, new CvorStabla(20), new CvorStabla(40)),
                        new CvorStabla(70, new CvorStabla(60), new CvorStabla(80)))));

        System.out.println("\nREZULTAT: " + proslo + "/" + ukupno
                + (proslo == ukupno ? "  — SVE PROŠLO ✅" : "  — IMA PADOVA ❌"));
    }

    // napravi ogledalo IN PLACE i vrati infiks obilazak posle mutacije
    static String ogledalo(CvorStabla koren) {
        try {
            BinarnoStablo s = new BinarnoStablo();
            s.koren = koren;
            s.napraviOgledalo(s.koren);
            return s.ispisInfiks();
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

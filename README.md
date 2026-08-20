# SPA — Vežbe (FON)

Zbirka od **40 zadataka** za vežbanje za predmet **SPA (Strukture podataka i algoritmi)** na
**Fakultetu organizacionih nauka (FON)**.

Zadaci su napravljeni **na osnovu materijala sa vežbi** i **simuliraju realan ispit**: dobiješ
„gotove" klase (kao da su iz `.jar`-a koji se dobije na testu) i tvoj posao je da **implementiraš
samo jednu zadatu metodu**. Kada rešenje prođe, driver ispiše `REZULTAT: PASS`.

> Svih 40 zadataka je **neurađeno** — čekaju tebe. Ideja je da ih rešavaš sam, iz više puta, kao
> pripremu za test.

---

## Kako izgleda jedan zadatak

Svaki zadatak je **zaseban paket** u `src/` (npr. `src/z01_izbaciTrenutni/`). U svakom paketu:

| Fajl | Uloga |
|------|-------|
| `CJSL` / `CDSL` / `CvorStabla` … | **DATO — NE DIRATI.** Čvor-klasa strukture. |
| `AJSLista` / `ADSLista` / `AStek` / `ANiz` / `ABinarnoStablo` … | **DATO — NE DIRATI.** Apstraktna klasa (generator test-podataka + ispis). Simulira `.jar` sa testa. |
| `Main` | **DATO — NE DIRATI.** Driver: pravi podatke, poziva tvoju metodu i proverava rezultat. |
| `JSLista` / `DSLista` / `Stek` / `Niz` / `BinarnoStablo` / `BSTStablo` | **TVOJ ZADATAK.** Konkretna klasa u kojoj pišeš rešenje. |

Na vrhu konkretne klase je **tekst zadatka** (Naslov / Opis / Primer / Ograničenja), a metoda koju
treba da napišeš je označena sa:

```java
// ====== TVOJ ZADATAK — implementiraj metod ispod ======
@Override
public void izbaciTrenutni(CJSL neki) {
    throw new UnsupportedOperationException("TODO: izbaciTrenutni");   // <-- ovo izbaci i napiši rešenje
}
```

---

## Kako se radi (workflow)

1. Otvori paket `src/zXX_.../` i u njemu **konkretnu klasu**.
2. Pročitaj **tekst zadatka** na vrhu klase.
3. Izbaci `throw new UnsupportedOperationException(...)` i **napiši rešenje**.
4. Pokreni `Main` tog paketa i gledaj `REZULTAT: PASS/FAIL`.
5. Kada prođe, čekiraj zadatak u [`CHECKLISTA.md`](CHECKLISTA.md).

Dok metoda nije implementirana, driver ispiše `dobijeno: UnsupportedOperationException` i
`REZULTAT: FAIL` — to je normalno, znači zadatak čeka tebe.

### Pokretanje

**IntelliJ IDEA:** desni klik na `Main` u željenom paketu → *Run 'Main.main()'*.
(`src/` treba da bude označen kao *Sources Root*: desni klik na `src` → *Mark Directory as → Sources Root*.)

**Terminal** (iz foldera `src/`):

```bash
javac z01_izbaciTrenutni/*.java && java z01_izbaciTrenutni.Main
```

Neki zadaci (`z17`, `z19`, `z20`) imaju i `TestExtra.java` — dodatni test sa više primera:

```bash
javac z17_daLiPostojiIsti/*.java && java z17_daLiPostojiIsti.TestExtra
```

---

## Kako se preuzima

```bash
git clone https://github.com/05vukasin/SPA-vezbe.git
cd SPA-vezbe/src
```

Ili preko GitHub-a: dugme **Code → Download ZIP**, pa raspakuj.

Potreban je samo **JDK** (bilo koja verzija 8+). Nema spoljnih biblioteka.

---

## Organizacija: serije po 10 (linearne pa nelinearne)

Zadaci idu u **serijama po 10**, i u svakoj seriji se smenjuju **linearne** pa **nelinearne**
strukture:

| Serija | Zadaci | Tip | Strukture |
|--------|--------|-----|-----------|
| **1** | z01–z10 | **Linearne** | jednostruko/dvostruko spregnute liste, stek, niz |
| **2** | z11–z20 | **Nelinearne** | binarno stablo |
| **3** | z21–z30 | **Linearne** | spregnute liste, stek, niz |
| **4** | z31–z40 | **Nelinearne** | binarno stablo, BST |

Prvih 20 (serije 1 i 2) su „osnovni" zadaci sa vežbi; drugih 20 (serije 3 i 4) su nastavak/proširenje.

---

## Spisak zadataka

Kolona **LeetCode** pokazuje da li zadatak odgovara nekom poznatom LeetCode problemu. „*(slično)*"
znači da je ideja ista, ali postavka nije 1:1.

### Serija 1 — Linearne strukture (z01–z10)

| # | Zadatak | Metoda | LeetCode |
|---|---------|--------|----------|
| z01 | Izbaci trenutni element (JSL) | `izbaciTrenutni` | [237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/) |
| z02 | Invertovanje liste (sa pomoćnom) | `invertovanjeSaPomocnom` | [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) |
| z03 | Invertovanje liste (bez pomoćne, u mestu) | `invertovanjeBezPomocne` | [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) |
| z04 | Zbir elemenata ciklične liste | `zbirElemenataUCiklicnoj` | — |
| z05 | Ispiši listu obrnuto (rekurzija) | `ispisiObrnuto` | — |
| z06 | Kloniraj listu rekurzivno (duboka kopija) | `klonirajRekurzivno` | [138. Copy List w/ Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/) *(slično)* |
| z07 | Popuni listu sukcesivnim brojevima (DSL) | `popuniListu` | — |
| z08 | Element u sredini liste (slow/fast, DSL) | `elementUSredini` | [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/) |
| z09 | Ispiši stek obrnuto (rekurzija, stek se vraća) | `ispisiStekObrnuto` | — |
| z10 | Spoji dva sortirana niza (rezultat nerastuće) | `spojiDva` | [88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/) |

### Serija 2 — Nelinearne strukture: binarno stablo (z11–z20)

| # | Zadatak | Metoda | LeetCode |
|---|---------|--------|----------|
| z11 | Broj elemenata stabla | `brojElemenata` | — |
| z12 | Zbir elemenata (public/private + Exception) | `zbirElemenata` | — |
| z13 | Visina stabla | `visinaStabla` | [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) |
| z14 | Vrati čvor sa najvećom vrednošću (nije BST) | `vratiNajveci` | — |
| z15 | Vrati roditelja čvora sa datom vrednošću | `vratiRoditelja` | — |
| z16 | Putanja od korena do čvora | `putanjaKorenDoCvora` | — |
| z17 | Da li postoji čvor sa istom vrednošću | `daLiPostojiIsti` | — |
| z18 | Čvor na najvećoj dubini | `vratiCvorNaNajvecojDubini` | — |
| z19 | Broj čvorova većih od svih sledbenika | `vratiBrojCvorovaVecihOdSvojihSledbenika` | — |
| z20 | Da li je stablo AVL | `daLiJeAVL` | [110. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/) |

### Serija 3 — Linearne strukture (z21–z30)

| # | Zadatak | Metoda | LeetCode |
|---|---------|--------|----------|
| z21 | Ubaci u sortiranu listu (JSL) | `ubaciSortirano` | — |
| z22 | N-ti element od kraja (JSL) | `nadjiNtiOdKraja` | [19. Remove Nth Node From End](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) *(slično)* |
| z23 | Izbaci sve čvorove sa datom vrednošću (JSL) | `izbaciSve` | [203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/) |
| z24 | Da li je lista palindrom (JSL) | `daLiJePalindrom` | [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) |
| z25 | Spoji dve sortirane liste (JSL) | `spojiSortirane` | [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) |
| z26 | Obrni dvostruko-spregnutu listu | `obrniDSL` | [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) *(slično)* |
| z27 | Izbaci parne iz dvostruko-spregnute liste | `izbaciParne` | — |
| z28 | Balansirane zagrade (stek) | `daLiSuBalansirane` | [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) |
| z29 | Binarna pretraga (niz) | `binarnaPretraga` | [704. Binary Search](https://leetcode.com/problems/binary-search/) |
| z30 | Druga najveća vrednost (niz) | `drugiNajveci` | — |

### Serija 4 — Nelinearne strukture: stablo i BST (z31–z40)

| # | Zadatak | Metoda | LeetCode |
|---|---------|--------|----------|
| z31 | Broj listova | `brojListova` | — |
| z32 | Ogledalo stabla | `napraviOgledalo` | [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/) |
| z33 | Da li su dva stabla identična | `daLiSuIdenticna` | [100. Same Tree](https://leetcode.com/problems/same-tree/) |
| z34 | Zbir čvorova na datom nivou | `zbirNaNivou` | — |
| z35 | Da li je stablo BST | `daLiJeBST` | [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) |
| z36 | Ubacivanje u BST | `ubaci` | [701. Insert into a BST](https://leetcode.com/problems/insert-into-a-binary-search-tree/) |
| z37 | Pretraga u BST | `pretrazi` | [700. Search in a BST](https://leetcode.com/problems/search-in-a-binary-search-tree/) |
| z38 | Najmanji element u BST | `vratiMin` | — |
| z39 | Ispis BST u rastućem redosledu (inorder) | `ispisiRastuce` | [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) |
| z40 | Izbacivanje iz BST | `izbaci` | [450. Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/) |

---

## Napomena

Paket `src/stablo/` (`BStablo` sa `bfs`/`nacrtaj`) i `src/Main.java` su **odvojeni** — to je prostor
za učenje BFS-a i nije deo ovih 40 zadataka; možeš ih slobodno ignorisati.

## Rešenja

Repo namerno **ne** sadrži rešenja — poenta je da ih napišeš sam. Ako zapneš, pročitaj još jednom
*Opis* i *Ograničenja* na vrhu zadatka (tu su i saveti/hintovi).

---

*Napravljeno kao priprema za ispit iz predmeta SPA na FON-u. Srećno vežbanje!* 🎓

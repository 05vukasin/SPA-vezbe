package stablo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BStablo {
    public Cvor glava;

    public void Generator() {
        glava = new Cvor(10);
        glava.desni = new Cvor(15);
        glava.levi = new Cvor(5);
        glava.levi.desni = new Cvor(8);
        glava.levi.levi = new Cvor(3);
        glava.desni.levi = new Cvor(12);
        glava.desni.desni = new Cvor(18);
        glava.desni.levi.desni = new Cvor(14);
    }

    public void ispis() {
        ispis(glava);
    }

    private void ispis(Cvor cv) {
        if( cv == null ) return;
        ispis(cv.levi);
        System.out.println(" " + cv.podatak);
        ispis(cv.desni);
    }

    public int visina() {
        return visina(glava);
    }

    private int visina(Cvor cv) {
        if(cv == null) return 0;
        return 1 + Math.max(visina(cv.levi), visina(cv.desni));
    }

    public void bfs() {
        if(glava == null) return;
        Queue<Cvor> red = new LinkedList<>();
        red.add(glava);

        while(!red.isEmpty()) {
            Cvor cv = red.poll();
            System.out.println(" " + cv.podatak);
            if(cv.levi != null) red.add(cv.levi);
            if(cv.desni != null) red.add(cv.desni);
        }
    }

    public void nacrtaj() {
        if (glava == null) return;
        int h = visina(glava);
        int width = (int) Math.pow(2, h) + 1;

        Queue<Cvor>    redCvor = new LinkedList<>();
        Queue<Integer> redPoz  = new LinkedList<>();   // paralelni red pozicija
        redCvor.add(glava);
        redPoz.add((width + 1) / 2);                    // koren u sredinu

        int nivo = 1;
        while (!redCvor.isEmpty()) {
            int lineSize = redCvor.size();
            int offset = (int) Math.pow(2, h - nivo - 1); // pomeraj dece ovog nivoa
            int trenutnaKolona = 0;                        // koliko karaktera ispisano u liniji

            for (int i = 0; i < lineSize; i++) {
                Cvor cv = redCvor.poll();
                int poz = redPoz.poll();

                // dopuni razmake do kolone poz (poz je 1-indeksirano)
                while (trenutnaKolona < poz - 1) {
                    System.out.print(" ");
                    trenutnaKolona++;
                }
                System.out.print(cv.podatak);
                trenutnaKolona += String.valueOf(cv.podatak).length();

                if (cv.levi != null)  { redCvor.add(cv.levi);  redPoz.add(poz - offset); }
                if (cv.desni != null) { redCvor.add(cv.desni); redPoz.add(poz + offset); }
            }
            System.out.println();
            nivo++;
        }
    }
}

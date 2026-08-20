import stablo.BStablo;

import java.beans.Visibility;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BStablo bs = new BStablo();
        bs.Generator();

        bs.ispis();

        System.out.println("Visina: "+ bs.visina());

        bs.bfs();
        System.out.println("Nacrtaj");
        bs.nacrtaj();
    }
}
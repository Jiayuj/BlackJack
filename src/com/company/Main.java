package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        Scanner scanner = new Scanner(System.in);

        String nick;

        // start
        System.out.println(" Welcome to black jack ");
        System.out.println("-----------------------");
        System.out.print(" Enter you nick: ");
        nick = scanner.nextLine();
        System.out.println();


        // monstra menu
        Point.show(nick);
        System.out.println();
        menu.mostrar();

        //select menu
        int opcion = menu.getOpcion();
        while (opcion!=3) {
            if (opcion == 1) {
                Start start = new Start();
                start.game();
                System.out.println("Again ?");
                System.out.println("1 = Yes 2 = No");
                int opcionagain=menu.getOpcion();
                if (opcionagain==1){
                    opcion=1;
                }else {
                    Point.show(nick);
                    System.out.println();
                    menu.mostrar();
                    opcion = menu.getOpcion();
                }
            } else if (opcion == 2) {
                Point.show(nick);
                menu.mostrar();
                opcion=menu.getOpcion();
            }
        }
    }
}

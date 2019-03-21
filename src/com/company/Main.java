package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Point point = new Point();
        Scanner scanner = new Scanner(System.in);

        String nick;

        // start
        System.out.println(" Welcome to black jack ");
        System.out.println("-----------------------");
        System.out.print(" Enter you nick: ");
        nick = scanner.nextLine();
        System.out.println();


        // monstra menu
        point.muestra(nick);
        System.out.println();
        menu.opcion();

        //select menu
        int opcion = menu.set_opcion();
        while (opcion!=3) {
            if (opcion == 1) {
                Start start = new Start();
                start.game();
                System.out.println("Again ?");
                System.out.println("1 = Yes 2 = No");
                int opcionagain=menu.set_opcion();
                if (opcionagain==1){
                    opcion=1;
                }else {
                    opcion=3;
                }
            } else if (opcion == 2) {
                point.muestra(nick);
                menu.opcion();
                opcion=menu.set_opcion();
            }
        }
    }
}

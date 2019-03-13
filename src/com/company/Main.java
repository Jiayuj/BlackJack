package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String nick;
        // start game
        System.out.println(" Welcome to black jack ");
        System.out.println("-----------------------");
        System.out.print(" Enter you nick: ");
        nick = scanner.nextLine();
        borrar();

        //monstar inici
        int point = 100;

        int l = nick.length()+9+2+7+Integer.toString(point).length()+2;
        int l_b= (l - 10)/2;
        for (int i = 0; i < l_b; i++) {
            System.out.print(" ");
        }
        System.out.print("Black Jack");
        for (int i = 0; i < l_b; i++) {
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < l; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(" Player: "+nick+"  "+"Point: "+point+"P ");


        // monstra menu
        System.out.println(" Menu");
        System.out.println("-----------");
        System.out.println("1 - Start game");
        System.out.println("2 - Short points");
        System.out.println("3 - Exit");

        //select menu
        int opcion=scanner.nextInt();

        if (opcion==1){

            System.out.println("                 Black Jack                  ");
            System.out.println("---------------------------------------------");
            System.out.println(" A = 1p or 11p | 2-10 = 2p-10p | J,Q,K = 10p ");

            System.out.println("Computer");
            int card_com= new Random().nextInt(13)+1;




        }else if (opcion==2){
            borrar();
            for (int i = 0; i < l_b; i++) {
                System.out.print(" ");
            }
            System.out.print("Black Jack");
            for (int i = 0; i < l_b; i++) {
                System.out.print(" ");
            }
            System.out.println();
            for (int i = 0; i < l; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println(" Player: "+nick+"  "+"Point: "+point+"P ");
        }else {
            System.exit(0);
        }

    }
    static void borrar(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}

package com.company;

import java.util.Scanner;

public class Menu {


    void mostrar(){
        System.out.println(" Menu");
        System.out.println("-----------");
        System.out.println("1 - Start game");
        System.out.println("2 - Short points");
        System.out.println("3 - Exit");
    }

    int getOpcion(){
        int opcion= new Scanner(System.in).nextInt();
        return opcion;
    }


    void game(){
        System.out.println("                 Black Jack                  ");
        System.out.println("---------------------------------------------");
        System.out.println(" A = 1p or 11p | 2-10 = 2p-10p | J,Q,K = 10p ");
    }

    void opcionPlayer(){
        System.out.println("mostrar:");
        System.out.println("1 = stand 2 = hit  3  4  5");
    }

    void opcionMas(){
        System.out.println("YOU WANT MORE CARD?");
        System.out.println("1 =  yes  2 = no");
    }
}

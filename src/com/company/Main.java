package com.company;

import java.util.ArrayList;
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

        //start game
        if (opcion==1){
            borrar();
            System.out.println("                 Black Jack                  ");
            System.out.println("---------------------------------------------");
            System.out.println(" A = 1p or 11p | 2-10 = 2p-10p | J,Q,K = 10p ");

            comprobar();


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

    private static String[] card(){
        Random random = new Random();
        //52 card
        String [] cardlist = {"♣A","♣2","♣3","♣4","♣5","♣6","♣7","♣8","♣9","♣10","♣J","♣Q","♣K",
                                "♦A","♦2","♦3","♦4","♦5","♦6","♦7","♦8","♦9","♦10","♦J","♦Q","♦K",
                                "♥A","♥2","♥3","♥4","♥5","♥6","♥7","♥8","♥9","♥10","♥J","♥Q","♥K",
                                "♠A","♠2","♠3","♠4","♠5","♠6","♠7","♠8","♠9","♠10","♠J","♠Q","♠K",};
        for (int i = 0; i < cardlist.length; i++) {
            String temp;
            int n = random.nextInt(52);
            temp = cardlist[i];
            cardlist[i]=cardlist[n];
            cardlist[n]=temp;
        }
        return cardlist;
    }

    private static String reparticarta(){
        String [] card = card();
        String carta="";
        for (int i = 0; i < card.length; i++) {
            if (!card[i].equals("1")){
                carta = card[i];
                card[i]="1";
                break;
            }
        }
        return carta;
    }

    private static void comprobar(){
        ArrayList<String> cardplayer = new ArrayList<>();
        ArrayList<String> cardcomputer = new ArrayList<>();
        int cpoint=0;
        int ppoint=0;
        for (int i = 0; i < 2; i++) {
            String cc= reparticarta();
            cardcomputer.add(i,cc);
            String cp= reparticarta();
            cardplayer.add(i,cp);
            cpoint += value(cc.substring(1));
            ppoint += value(cp.substring(1));
        }
        System.out.println("Computer");
        System.out.println("1 card: *");
        for (int j = 1; j < cardcomputer.size(); j++) {
            System.out.println((j) + 1 + " card: " + cardcomputer.get(j));
        }
        System.out.println("Point: ?");
        System.out.println("");
        System.out.println("Player");
        for (int j = 0; j < cardplayer.size(); j++) {
            System.out.println((j) + 1 + " card: " + cardplayer.get(j));
        }
        if (cardplayer.get(0).substring(1).equals("A") || cardplayer.get(1).substring(1).equals("A")){
            ppoint += 10;
        }
        System.out.println("Point: " + ppoint);
        System.out.println();
        System.out.println("opcion:");
        System.out.println("q   w  e  r  t");
        String opcion = new Scanner(System.in).nextLine();
        while (!opcion.equals("t")) {
            if (opcion.equals("q")) {
                opcion = "c";
                System.out.println("Player");
                for (int j = 0; j < cardplayer.size(); j++) {
                    System.out.println((j) + 1 + " card: " + cardplayer.get(j));
                }
                System.out.println("Point: " + ppoint);
            }

            if (opcion.equals("w")) {
                for (int i = 2; ppoint < 21; i++) {
                    String cp = reparticarta();
                    cardplayer.add(i,cp);
                    if (cp.substring(1).equals("A")){
                        for (int j = 0; j < cardplayer.size(); j++) {
                            if (cardplayer.get(j).equals("Q") || cardplayer.get(j).equals("J") || cardplayer.get(j).equals("K")){

                            }
                        }
                    }
                    int p = value(cp.substring(1));
                    ppoint += p;

                    System.out.println("Player");
                    for (int j = 0; j < cardplayer.size(); j++) {
                        System.out.println((j) + 1 + " card: " + cardplayer.get(j));
                    }
                    System.out.println("Point: " + ppoint);
                    if (ppoint > 21) {
                        System.out.println("BUST");
                        System.out.println("YOU LOST ！！！");
                        opcion = "t";
                        break;
                    } else if (ppoint == 21) {
                        System.out.println("YOU WIN ！！！");
                    } else {
                        System.out.println("YOU WANT MORE CARD?");
                        System.out.println("A =  yes  B = no");
                        String opcion1 = new Scanner(System.in).nextLine();
                        if (opcion1.equals("B")) {
                            opcion = "c";
                            break;
                        }
                    }
                }
            }

            if (opcion.equals("c")){
                for (int i = 2; cpoint < 18; i++) {
                    String cc = reparticarta();
                    cardcomputer.add(i, cc);
                    cpoint += value(cc.substring(1));
                }

                if (cpoint>21 || ppoint>cpoint){
                    borrar();
                    System.out.println("Computer");
                    for (int j = 0; j < cardcomputer.size(); j++) {
                        System.out.println((j) + 1 + " card: " + cardcomputer.get(j));
                    }
                    System.out.println("Point: " + cpoint);
                    System.out.println();
                    System.out.println("Player");
                    for (int j = 0; j < cardplayer.size(); j++) {
                        System.out.println((j) + 1 + " card: " + cardplayer.get(j));
                    }
                    System.out.println("Point: " + ppoint);
                    System.out.println("YOU WIN ！！！");
                    break;
                }else if (cpoint == 21 || cpoint>ppoint){
                    borrar();
                    System.out.println("Computer");
                    for (int j = 0; j < cardcomputer.size(); j++) {
                        System.out.println((j) + 1 + " card: " + cardcomputer.get(j));
                    }
                    System.out.println("Point: " + cpoint);
                    System.out.println();
                    System.out.println("Player");
                    for (int j = 0; j < cardplayer.size(); j++) {
                        System.out.println((j) + 1 + " card: " + cardplayer.get(j));
                    }
                    System.out.println("Point: " + ppoint);
                    System.out.println("YOU LOST ！！！");
                    break;
                }
            }
        }
    }

    private static int value(String cc){
        String []tow = {"2","3","4","5","6","7","8","9","10"};
        String []ten = {"J","Q","K"};
        String oneor11 = "A";
        int value=0;
        if (cc.equals(oneor11)){
            value=1;
        }else {
            for (int i = 0; i <tow.length ; i++) {
                if (cc.equals(tow[i])){
                    value=Integer.parseInt(tow[i]);
                    break;
                }
            }
            for (int i = 0; i <ten.length ; i++) {
                if (cc.equals(ten[i])){
                    value=10;
                    break;
                }
            }
        }
        return value;
    }


    private static void borrar(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}

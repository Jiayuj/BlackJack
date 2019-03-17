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
        String cp1= reparticarta();
        String cc1= reparticarta();
        String cp2= reparticarta();
        String cc2= reparticarta();

        int c1=value(cc1.substring(1));
        int c2=value(cc2.substring(1));
        int cpoint = c1 + c2;


        int p1=value(cp1.substring(1));
        int p2=value(cp2.substring(1));
        int ppoint = p1 + p2;
        System.out.println("Computer");
        System.out.println("1 card: *");
        System.out.println("2 card: " + cc2);
        System.out.println();
        System.out.println("Player");
        System.out.println("1 card: " + cp1);
        System.out.println("2 card: " + cp2);
        System.out.println("Point: "+ ppoint);

        System.out.println();
        System.out.println("opcion:");
        System.out.println("q   w  e  r  t");
        String opcion = new Scanner(System.in).nextLine();
        while (!opcion.equals("t")) {
            if (opcion.equals("q")) {
                if (p1 == 1 || p2 == 1) {
                    System.out.println("What point want?");
                    System.out.println("A = 1   B = 11");
                    String pointA = new Scanner(System.in).nextLine();
                    if (pointA.equals("B")) {
                        ppoint += 10;
                    }
                }
                borrar();
                System.out.println("                 Black Jack                  ");
                System.out.println("---------------------------------------------");
                System.out.println(" A = 1p or 11p | 2-10 = 2p-10p | J,Q,K = 10p ");
                System.out.println();
                System.out.println("Computer");
                System.out.println("1 card: " + cc1);
                System.out.println("2 card: " + cc2);
                System.out.println("Point: " + cpoint);
                System.out.println();
                System.out.println("Player");
                System.out.println("1 card: " + cp1);
                System.out.println("2 card: " + cp2);
                System.out.println("Point: " + ppoint);
                System.out.println();
                if (cpoint > ppoint) {
                    System.out.println("YOU LOST ！！！");
                    opcion="t";
                } else {
                    System.out.println("YOU WIN ！！！");
                    opcion="t";
                }
            }

            if (opcion.equals("w")) {
                ArrayList<String> cardplayer = new ArrayList<>();
                cardplayer.add(0, cp1);
                cardplayer.add(1, cp2);
                for (int i = 2; ppoint < 21; i++) {
                    String cp = reparticarta();
                    cardplayer.add(i,cp);
                    int p = value(cp.substring(1));
                    ppoint += p;
                    for (int j = 0; j < cardplayer.size(); j++) {
                        System.out.println((j) + 1 + " card: " + cardplayer.get(j));
                    }
                    System.out.println("Point: " + ppoint);
                    if (ppoint > 21) {
                        System.out.println("BUST");
                        opcion = "t";
                        break;
                    } else if (ppoint == 21) {
                        System.out.println("YOU WIN ！！！");
                    } else {
                        System.out.println("YOU WANT MORE CARD?");
                        System.out.println("A =  yes  B = no");
                        String opcion1 = new Scanner(System.in).nextLine();
                        if (opcion1.equals("B")) {
                            System.out.println("opcion:");
                            System.out.println("q   w  e  r  t");
                            opcion = new Scanner(System.in).nextLine();
                            break;
                        }
                    }
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

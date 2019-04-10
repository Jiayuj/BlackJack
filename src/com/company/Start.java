package com.company;

import java.util.ArrayList;

public class Start {

    Deck card = new Deck();
    Menu menu = new Menu();
    Muestra muestra = new Muestra();
    Checker checker = new Checker();
    ArrayList<String> playerCards = new ArrayList<>();
    ArrayList<String> computerCards = new ArrayList<>();

    int cpoint=0;
    int ppoint=0;
    int opcionp=0;

    void game (){
        menu.game();
        //desordenar carta
        card.carddesodenat();
        //repartica prime dos carta.
        for (int i = 0; i < 2; i++) {
            String cc= card.reparticarta();
            computerCards.add(i,cc);
            String cp= card.reparticarta();
            playerCards.add(i,cp);
        }
        cpoint = checker.check(computerCards);
        ppoint = checker.check(playerCards);

        muestra.cardcom(computerCards);
        muestra.cardp(playerCards, ppoint);


        menu.opcionPlayer();
        opcionp = menu.getOpcion();
        while (opcionp!=9){
            if (opcionp==1){
                opcionp=11;
            }else if (opcionp==2){
                for (int i = 2; ppoint < 21; i++) {
                    String cp = card.reparticarta();
                    playerCards.add(i, cp);
                    ppoint = checker.check(playerCards);
                    muestra.cardp(playerCards,ppoint);
                    if (ppoint > 21) {
                        System.out.println("BUST");
                        System.out.println("YOU LOST ！！！");
                        Point.point -= 10;
                        opcionp=9;
                    } else if (ppoint == 21) {
                        System.out.println("YOU WIN ！！！");
                        Point.point += 10;
                        opcionp=9;
                    } else {
                        System.out.println("YOU WANT MORE CARD?");
                        System.out.println("1 =  yes  2 = no");
                        int opcionmore = menu.getOpcion();
                        if (opcionmore==2) {
                            opcionp = 11;
                            break;
                        }
                    }
                }
            }

            if (opcionp==11){
                for (int i = 2; cpoint < 17; i++) {
                    String cc = card.reparticarta();
                    computerCards.add(i, cc);
                    cpoint = checker.check(computerCards);
                }

                if (cpoint>21 || ppoint>cpoint){
                    muestra.cardcomP(computerCards, cpoint);
                    muestra.cardp(playerCards, ppoint);
                    System.out.println("YOU WIN ！！！");
                    Point.point += 10;
                    opcionp=9;

                }else if (cpoint == 21 || cpoint>ppoint) {
                    muestra.cardcomP(computerCards, cpoint);
                    muestra.cardp(playerCards, ppoint);
                    System.out.println("YOU LOST ！！！");
                    Point.point -= 10;
                    opcionp = 9;
                }
            }

            if (opcionp==00){
                Point.point -= 10;
                System.out.println("You points - 10\n");
                opcionp = 9;
            }
        }
    }
}
package com.company;

import java.util.ArrayList;

public class Start {

    Card card = new Card();
    Menu menu = new Menu();
    Value value = new Value();
    Muestra muestra = new Muestra();
    Comprobar comprobar = new Comprobar();
    ArrayList<String> cardplayer = new ArrayList<>();
    ArrayList<String> cardcomputer = new ArrayList<>();
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
            cardcomputer.add(i,cc);
            String cp= card.reparticarta();
            cardplayer.add(i,cp);
            cpoint = comprobar.computer_punto(cc);
            ppoint = comprobar.player_punto(cp);
        }

        muestra.cardcom(cardcomputer);
        muestra.cardp(cardplayer, ppoint);


        menu.opcion_player();
        opcionp = menu.set_opcion();
        while (opcionp!=9){
            if (opcionp==1){
                opcionp=11;
            }else if (opcionp==2){
                for (int i = 2; ppoint < 21; i++) {
                    String cp = card.reparticarta();
                    cardplayer.add(i, cp);
                    ppoint += value.value(cp.substring(1));
                    muestra.cardp(cardplayer,ppoint);
                    if (ppoint > 21) {
                        System.out.println("BUST");
                        System.out.println("YOU LOST ！！！");
                        opcionp=9;
                    } else if (ppoint == 21) {
                        System.out.println("YOU WIN ！！！");
                        opcionp=9;
                    } else {
                        System.out.println("YOU WANT MORE CARD?");
                        System.out.println("1 =  yes  2 = no");
                        int opcionmore = menu.set_opcion();
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
                    cardcomputer.add(i, cc);
                    cpoint += value.value(cc.substring(1));
                }

                if (cpoint>21 || ppoint>cpoint){
                    muestra.cardcomP(cardcomputer, cpoint);
                    muestra.cardp(cardplayer, ppoint);
                    System.out.println("YOU WIN ！！！");
                    opcionp=9;

                }else if (cpoint == 21 || cpoint>ppoint) {
                    muestra.cardcomP(cardcomputer, cpoint);
                    muestra.cardp(cardplayer, ppoint);
                    System.out.println("YOU LOST ！！！");
                    opcionp = 9;
                }
            }
        }
    }
}
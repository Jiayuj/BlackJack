package com.company;

import java.util.Random;

public class Card {

    String [] cardlist;
    int orden = 0;
    static String [] desordena(){
        String [] cardlist = {"♣A","♣2","♣3","♣4","♣5","♣6","♣7","♣8","♣9","♣10","♣J","♣Q","♣K",
                "♦A","♦2","♦3","♦4","♦5","♦6","♦7","♦8","♦9","♦10","♦J","♦Q","♦K",
                "♥A","♥2","♥3","♥4","♥5","♥6","♥7","♥8","♥9","♥10","♥J","♥Q","♥K",
                "♠A","♠2","♠3","♠4","♠5","♠6","♠7","♠8","♠9","♠10","♠J","♠Q","♠K",};
        for (int i = 0; i < cardlist.length; i++) {
            String temp;
            int n = new Random().nextInt(52);
            temp = cardlist[i];
            cardlist[i]=cardlist[n];
            cardlist[n]=temp;
        }
        return cardlist;
    }

    void carddesodenat(){
        cardlist= desordena();
    }
    String reparticarta(){
        String carta= cardlist[orden];
        orden++;
        return carta;
    }


}

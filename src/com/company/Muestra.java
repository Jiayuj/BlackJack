package com.company;

import java.util.ArrayList;

public class Muestra {

    void cardcom(ArrayList<String> cardcomputer){

        //mosntra carta que tiene
        System.out.println("Computer");
        System.out.println("1 card: *");
        for (int j = 1; j < cardcomputer.size(); j++) {
            System.out.println((j) + 1 + " card: " + cardcomputer.get(j));
        }
        System.out.println("Point: ?");
        System.out.println();
    }

    void cardcomP(ArrayList<String> cardcomputer,int cpoint){
        System.out.println("Computer");
        for (int j = 0; j < cardcomputer.size(); j++) {
            System.out.println((j) + 1 + " card: " + cardcomputer.get(j));
        }
        System.out.println("Point: " + cpoint);
        System.out.println();
    }

    void cardp (ArrayList<String> cardplayer,int ppoint){
        System.out.println("Player");
        for (int j = 0; j < cardplayer.size(); j++) {
            System.out.println((j) + 1 + " card: " + cardplayer.get(j));
        }
        System.out.println("Point: " + ppoint);
        System.out.println();
    }
}

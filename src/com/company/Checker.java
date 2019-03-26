package com.company;

import java.util.ArrayList;

public class Checker {


    int check(ArrayList<String> card){
        Value value = new Value();
        boolean A = false;
        boolean jqk = false;
        boolean n = false;
        int point=0;


        for (int i = 0; i < card.size(); i++) {
            point += value.value(card.get(i).substring(1));
            if (card.get(i).substring(1).equals("A")){
                A=true;
            }else if (card.get(i).substring(1).equals("J") || card.get(i).substring(1).equals("Q") || card.get(i).substring(1).equals("K")){
                jqk=true;
            }else {
                n = true;
            }
        }


        if (A && jqk && n){
            point = 21;
        }else if (A && !jqk && n){
            if ((point+10) < 21){
                point +=10;
            }
        }

        return point;
    }
}

package com.company;

public class Comprobar {


    int computer_punto(String cc){
        Value value = new Value();
        int cpoint=0;
        int comproba=0;

        //punto de A
        if (cc.substring(1).equals("A")){
            comproba += 2;
        }else if (cc.substring(1).equals("J") || cc.substring(1).equals("Q") ||cc.substring(1).equals("K")){
            comproba++;
        }

        if (comproba==3 || comproba==2){
            cpoint += value.value(cc.substring(1));
        }else {
            cpoint += value.value(cc.substring(1));
        }
        return cpoint;
    }

    int player_punto(String cp){
        Value value = new Value();
        int ppoint=0;
        int comproba=0;

        //punto de A
        if (cp.substring(1).equals("A")){
            comproba += 2;
        }else if (cp.substring(1).equals("J") || cp.substring(1).equals("Q") ||cp.substring(1).equals("K")){
            comproba++;
        }

        if (comproba==3 || comproba==2){
            ppoint += value.value(cp.substring(1));
        }else {
            ppoint += value.value(cp.substring(1));
        }
        return ppoint;
    }
}

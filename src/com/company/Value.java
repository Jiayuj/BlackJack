package com.company;

public class Value {


    int value(String cc){
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
}

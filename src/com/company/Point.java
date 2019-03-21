package com.company;

public class Point {
    int point = 100;

    void muestra(String nick){
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
    }


}

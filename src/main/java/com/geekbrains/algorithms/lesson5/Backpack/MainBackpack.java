package com.geekbrains.algorithms.lesson5.Backpack;

import java.util.ArrayList;
import java.util.List;

public class MainBackpack {

    public static int backpackWt = 5;
    public static List<Baggage> backpack = new ArrayList<>();
    public static int sumAllWorthBaggageInBackpack = 0;

    public static void main(String[] args) {

        Baggage baggage[] = new Baggage[4];
        baggage[0] = new Baggage("Ноутбук", 3, 2000);
        baggage[1] = new Baggage("Гитара", 1, 1500);
        baggage[2] = new Baggage("Бензопила", 4, 3000);
        baggage[3] = new Baggage("Планшет", 1, 2500);

        backpackPull(sortBaggage(baggage), backpackWt, sumAllWorthBaggageInBackpack, backpack);

        for (int i = 0; i < backpack.size(); i++) {
            System.out.println(backpack.get(i).getName() + " весом " + backpack.get(i).getWt() + "кг и ценностью " + backpack.get(i).getWorth() + "$");
        }



    }
   public static int backpackPull(Baggage baggage[], int backpackWt, int sumAllWorthBaggageInBackpack, List<Baggage> backpack){
       int i = baggage.length-1;
       if(backpackWt == 0){
           return 0;
       }
       if(i == 0 && backpackWt > baggage[i].getWt()){
           backpackWt -= baggage[i].getWt();
           backpack.add(baggage[i]);
           return sumAllWorthBaggageInBackpack += baggage[i].getWorth();
       }
       if ((backpackWt - baggage[i].getWt()) < 0){
           backpackPull(newBaggage(baggage),backpackWt, sumAllWorthBaggageInBackpack,backpack);
           return 0;
       }
       backpack.add(baggage[i]);
       backpackWt -= baggage[i].getWt();
       sumAllWorthBaggageInBackpack += baggage[i].getWorth();
       return backpackPull(newBaggage(baggage), backpackWt, sumAllWorthBaggageInBackpack, backpack);

   }
   public static Baggage[] sortBaggage(Baggage baggage[]){
        for (int i = 1; i < baggage.length; i++) {
            Baggage temp = baggage[i];
            int m = i;
            if(m > 0 && temp.worthOneKgBaggage() <= baggage[m-1].worthOneKgBaggage()){
                baggage[m] = baggage[m-1];
                m--;
            }
            baggage[m] = temp;
        }
        return baggage;
   }
   public static void print(Baggage baggage[]){
       for (int i = 0; i < baggage.length; i++) {
           System.out.println(baggage[i].getName() + " " + baggage[i].worthOneKgBaggage());
       }
       System.out.println();
   }
   public static Baggage[] newBaggage(Baggage baggage[]){
        int i = baggage.length;
       Baggage newBaggage[] = new Baggage[i-1];
       for (int j = 0; j < newBaggage.length; j++) {
           newBaggage[j] = baggage[j];
       }
       return newBaggage;
   }

}

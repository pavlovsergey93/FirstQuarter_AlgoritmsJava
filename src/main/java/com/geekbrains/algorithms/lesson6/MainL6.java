package com.geekbrains.algorithms.lesson6;

import com.geekbrains.algorithms.lesson2.MyArray;

import java.util.Random;

public class MainL6 {
    public static void main(String[] args) {
        int count = 100000;
        int countBalance = 0;
        for (int i = 0; i < count; i++) {
            MyTree<Integer,Integer> map = new MyTree<>();
            while(true){
                int value = randomValue();
                int key = value;
                map.put(key, value);
                if(map.height() == 7){
                    map.deleteToKey(key);
                    if(map.isBalance()){
                        countBalance++;
                    }
                    break;
                }
            }
        }
        System.out.println("Сбалансированных деревьев: " + countBalance);
        System.out.println("Общее число деревьев: " + count);
        System.out.println("Процент сбалансированных деревьев: " + ((double)countBalance/(double)count*100) + "%");
    }
    public static int randomValue(){
        return (int)(Math.random()*200 - 100);
    }
}

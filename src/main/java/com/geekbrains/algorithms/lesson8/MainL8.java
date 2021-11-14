package com.geekbrains.algorithms.lesson8;

import java.util.Random;

public class MainL8{
    public static void main(String[] args) {
        Random random = new Random();
        ChainingHashMap<Integer, String> map = new ChainingHashMap<>(7);

        for (int i = 0; i < 5; i++) {
            map.put(i, "a");
            //map.put(random.nextInt(100), "a");
        }
        System.out.println(map.get(3));
        map.delete(3);
        System.out.println(map.get(3));
        System.out.println(map);

        LinearProbingHashMap<Integer, String> lphn = new LinearProbingHashMap<>(97);
        lphn.put(5, "qwe");
        lphn.put(15, "qwewqr");
        System.out.println(lphn.get(10));

    }
}

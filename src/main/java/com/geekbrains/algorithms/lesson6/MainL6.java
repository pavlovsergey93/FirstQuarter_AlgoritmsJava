package com.geekbrains.algorithms.lesson6;

import com.geekbrains.algorithms.lesson2.MyArray;

public class MainL6 {
    public static void main(String[] args) {
        MyTree<Integer,String> map = new MyTree<>();
        map.put(4,"four");
        map.put(2,"two");
        map.put(1,"one");
        map.put(3,"three");
        map.put(5,"five");

        System.out.println(map.size());
        System.out.println(map.get(2));
        map.put(2, "two two");
        map.put(6, "six");
        System.out.println(map.get(2));
        System.out.println(map.get(6));

    }
}

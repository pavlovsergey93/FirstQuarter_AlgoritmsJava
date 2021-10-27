package com.geekbrains.algorithms.lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArray arr = new MyArray(200);
        arr.addArrayElement(15, 1000);
        arr.arrayInit();
        arr.display(MyArray.getSize());
        arr.arrayDelete();
        if(arr.findArrayElement(1000) == -1) {
            System.out.println();
            System.out.println("Искомого элемента не обнаружено!");
        }
    }
}

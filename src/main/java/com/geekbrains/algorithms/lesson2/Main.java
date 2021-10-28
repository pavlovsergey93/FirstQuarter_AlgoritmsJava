package com.geekbrains.algorithms.lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArray arr = new MyArray(10000);
        arr.addArrayElement(5, 1000);
        arr.arrayInit();
        arr.display(MyArray.getSize());
        arr.arrayDelete();
        if(arr.findArrayElement(1000) == -1) {
            System.out.println();
            System.out.println("Искомого элемента не обнаружено!");
        }
        System.out.println("Какой метод сортировки применить? (1 - Пузырьковый, 2 - Метод с маркером, 3 - Метод вставки)");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        System.out.println("--------------------------------------------------------------------------------------------");

        if(result == 1) {
            System.out.println("Пузырьковый метод");
            arr.sortBubble();
        } else if(result == 2) {
            System.out.println("Метод с маркером");
            arr.sortSelect();
        }else{
            System.out.println("Метод вставки");
            arr.sortInsert();
        }
        //arr.display(MyArray.getSize());
    }
}

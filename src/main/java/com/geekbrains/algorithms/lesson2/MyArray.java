package com.geekbrains.algorithms.lesson2;

import java.util.Scanner;

public class MyArray {
    private static int array[];
    private static int size;

    public MyArray(int size){
        this.size = size;
        this.array = new int[size];
    }
    //заполнение массива
    public int[] arrayInit(){
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) continue;
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    // Вывод массива
    public void display(int len) {
        for (int i = 0; i < len; i++){
            if(i%50 == 0) System.out.println();
            System.out.print(array[i] + " ");
        }
    }

    // Удаление массива со сдвигом
    public void arrayDelete(){
        int i;
        int len = array.length;
        System.out.println();
        System.out.print("Введите удаляемый элемент: ");
        Scanner scanner = new Scanner(System.in);
        int search = scanner.nextInt();
        // цикл поиска необходимого элемента по всему массиву
        for (i = 0; i < len; i++) {
            if (array[i] == search){
                break;
            }
        }
        // сдвиг влево
        for (int j = i; j < len - 1; j++) {
            array[j] = array[j+1];
        }
        len--;
        display(len);
    }

    // добавление элемента массива
    public void addArrayElement(int index, int element){
        this.array[index] = element;
    }

    public static int[] getArray() {
        return array;
    }

    public static void setArray(int[] array) {
        MyArray.array = array;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        MyArray.size = size;
    }
    public int findArrayElement(int findElement){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == findElement){
                System.out.println();
                System.out.println("Элемент " + findElement + " находится в ячейке " + i);
                return array[i];
            }
        }
        return -1;
    }
}

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
//            if (array[i] != 0) continue;
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    // Вывод массива
    public void display(int len) {
        for (int i = 0; i < len; i++){
            if(i%1000 == 0) System.out.println();
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
    // Пузырьковая сортировка
    public int[] sortBubble(){
        long timeRun = System.currentTimeMillis();
        for(int i = array.length-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (array[j] > array[j+1]){
                    int str = array[j];
                    array[j] = array[j+1];
                    array[j+1] = str;
                }
            }
        }
        long timeOff = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (timeOff - timeRun));
        return array;
    }
    // сортировка с маркером
    public int[] sortSelect(){
        long timeRun = System.currentTimeMillis();
        for(int i = 0; i < array.length; i++){
            int marker = i;
            for(int j = i+1; j < array.length; j++){
                if (array[j] < array[marker]){
                    marker = j;
                }
            }
            int str = array[i];
            array[i] = array[marker];
            array[marker] = str;
        }
        long timeOff = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (timeOff - timeRun));
        return array;
    }
    // Сортировка методом вставки
    public int[] sortInsert (){
        long timeRun = System.currentTimeMillis();
        for(int i = 1; i < array.length; i++){
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j-1] >= temp){
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
        long timeOff = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (timeOff - timeRun));
        return array;
    }
}

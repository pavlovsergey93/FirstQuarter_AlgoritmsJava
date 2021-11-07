package com.geekbrains.algorithms.lesson5;

public class Main {
    public static void main(String[] args) {
        System.out.println(exponentiation(2, 10));
    }
    // Возведение в степень рекурсивным методом
    public static int exponentiation(int number, int degre){
        if (degre == 0){
            return 1;
        }
        if (degre == 1){
            return number;
        }
        return (exponentiation(number, (degre-1)) * number);
    }
}

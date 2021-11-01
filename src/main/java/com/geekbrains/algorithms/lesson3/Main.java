package com.geekbrains.algorithms.lesson3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        String str = "Hello world";
        Stack<Character> stack = new Stack<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.print(stack.pop());
        }
        System.out.println();

        Deque<Integer> deque = new Deque<>(4);
        deque.insertLeft(10);
        deque.insertLeft(20);
        deque.insertRight(30);
        deque.insertRight(40);

        System.out.println(deque.remoteLeft());
        System.out.println(deque.remoteRight());
        System.out.println(deque.remoteRight());
        System.out.println(deque.remoteRight());
    }
}

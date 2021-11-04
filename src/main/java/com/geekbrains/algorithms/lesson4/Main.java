package com.geekbrains.algorithms.lesson4;

public class Main {
    // не сразу увидел изменение домашки:(
    public static void main(String[] args) {
        MyLinkedList<Integer> mll = new MyLinkedList<>();
        mll.insertFirst(4);
        mll.insertFirst(5);
        mll.insertFirst(6);
        mll.insertFirst(7);
        mll.insertFirst(8);
        mll.insertFirst(9);
        mll.insertFirst(10);

        System.out.println(mll.getFirst());
        System.out.println(mll.deleteFirst());
        System.out.println(mll.deleteFirst());
        System.out.println(mll.deleteFirst());
        System.out.println(mll.deleteFirst());

        System.out.println(mll);
        mll.insert(3,35);
        System.out.println(mll);

        mll.delete(4);
        System.out.println(mll);

        MyLinkedListTwoLine mlltl = new MyLinkedListTwoLine();
        mlltl.insertLast(1);
        mlltl.insertLast(2);
        mlltl.insertLast(4);
        mlltl.insertLast(6);
        mlltl.insertFirst(8);
        mlltl.insertFirst(10);
        mlltl.insertFirst(12);
        mlltl.insertFirst(14);
        mlltl.insert(3,1000);
        mlltl.insert(3,1000);
        mlltl.insert(5,2000);
        System.out.println(mlltl);
        mlltl.deleteFirst();
        System.out.println(mlltl);
        mlltl.deleteFirst();
        System.out.println(mlltl);
        mlltl.deleteLast();
        mlltl.deleteLast();
        System.out.println(mlltl);
        mlltl.delete(1000);
        System.out.println(mlltl);
        mlltl.delete(1000);
        System.out.println(mlltl);

        MyStackLine msl = new MyStackLine();
        msl.push(10);
        msl.push(20);
        msl.push(30);
        System.out.println(msl);
        System.out.println(msl.peek().getValue());
        System.out.println(msl.pop().getValue());
        System.out.println(msl.pop().getValue());
        msl.push(40);
        msl.push(50);
        msl.push(60);
        msl.push(70);
        System.out.println(msl);

        MyQueueLine mql = new MyQueueLine();
        mql.insert(10);
        mql.insert(20);
        mql.insert(30);
        mql.insert(40);
        System.out.println(mql);
        mql.delete();
        System.out.println(mql);
        mql.delete();
        System.out.println(mql);
        System.out.println(mql.peek());

    }
}

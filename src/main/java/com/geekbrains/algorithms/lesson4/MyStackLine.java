package com.geekbrains.algorithms.lesson4;

public final class MyStackLine<T>{
    @Override
    public String toString(){
        StringBuilder  sb = new StringBuilder("[");
        MyStackLine.Node current = top;
        for (int i = 0; i < size; i++) {
            sb.append(current.getValue()).append(", ");
            current =current.getNext();
        }
        if (size > 0){
            sb.setLength(sb.length()-2);
        }
        sb.append("]");
        return sb.toString();

    }
    private Node top;
    private int size;

    public class Node{
        T value;
        Node next;

        public Node(T value, Node next){
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public void push(T item){// добавлять файлы с головы методом insertFirst
        Node newNode = new Node(item, top);
        top = newNode;
        size++;
    }

    public Node peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return getTop();
    }
    public Node pop(){ // использовать метод deleteFirst, для изымания послендего добавленного файл
        Node temp = peek();
        top = top.getNext();
        size--;
        return temp;
    }
}

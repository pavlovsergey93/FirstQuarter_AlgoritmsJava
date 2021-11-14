package com.geekbrains.algorithms.lesson4;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node first;
    private int size;

    public T getFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.getValue();
    }

    public int size() {
        return size;
    }

    public class Node {
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

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst (T item){
        Node newNode = new Node(item, first);
        first = newNode;
        size++;
    }
    public T deleteFirst(){
        T temp = getFirst();
        first = first.getNext();
        size--;
        return temp;
    }
    public final int indexFind (T item){
        Node current = first;
        int index = 0;
        while (current != null){
            if(item.equals(current)){
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }
    public boolean contains(T item){
        return indexFind(item) >-1;
    }
    public void insert(int index, T item){
        if(index < 0  || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            insertFirst(item);
            return;
        }
        Node current = first;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }
        Node newNode = new Node(item, current.getNext());
        current.setNext(newNode);
        size++;
    }

    public boolean delete(T item){
        if(isEmpty()){
            return false;
        }
        if(item.equals(first.getValue())){
            deleteFirst();
            return true;
        }
        Node current = first;
        while (current.getNext() != null && !current.getNext().getValue().equals(item)) {
            current = current.getNext();
        }
        if(current.getNext() == null){
            return false;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    @Override
    public String toString(){
        StringBuilder  sb = new StringBuilder("[");
        Node current = first;
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
}

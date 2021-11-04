package com.geekbrains.algorithms.lesson4;

import java.util.NoSuchElementException;

public class MyLinkedListTwoLine<T> {
    private Node first;
    private Node last;
    private int size;

    public T getLast() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return last.getValue();
    }

    public void setLast(Node last) {
        this.last = last;
    }

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
        Node prev;

        public Node(Node prev,T value, Node next){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        public Node(T value, Node next){
            this.value = value;
            this.next = next;
        }
        public Node( Node prev,T value){
            this.value = value;
            this.prev = prev;
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

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst (T item){
        Node newNode = new Node(item, first);
        if(isEmpty()) {
            last = newNode;
        }
        else{
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item){
        Node newNode = new Node(last, item);
        if (isEmpty()){
            first = newNode;
        }else{
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }
    public void insert(int index, T item){
        if(index < 0  || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            insertFirst(item);
            return;
        }
        if(index == size){
            insertLast(item);
            return;
        }
        Node current = first;
        for (int i = 1; i <= index; i++) {
            current = current.getNext();
        }
        Node newNode = new Node(current.prev, item, current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        size++;
    }
    public T deleteFirst(){
        T temp = getFirst();
        first = first.getNext();
        if(isEmpty()){
            last = null;
        }else{
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    public T deleteLast() {
        T temp = getLast();
        if (last.getPrev() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return temp;
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
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if(current == null){
            return false;
        }
        if(current == last){
            deleteLast();
            return true;
        }
        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
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

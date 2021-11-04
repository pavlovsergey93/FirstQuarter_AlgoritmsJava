package com.geekbrains.algorithms.lesson4;

public class MyQueueLine <T>{
    @Override
    public String toString(){
        StringBuilder  sb = new StringBuilder("[");
        MyQueueLine.Node current = head;
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
    private int size;
    private Node head;
    private Node end;
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public class Node{
        Node next;
        T value;

        public Node(T value, Node next){
            this.next = next;
            this.value = value;

        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void insert(T item){
        Node newNode = new Node(item,end);
        if(isEmpty()) {
            head = newNode;
            end = newNode;

        }else{
            end.next = newNode;
            end = newNode;
        }
        size++;
    }
    public T peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return head.value;
    }
    public T delete(){
        T temp = peek();
        head = head.next;
        size--;
        return temp;
    }
}

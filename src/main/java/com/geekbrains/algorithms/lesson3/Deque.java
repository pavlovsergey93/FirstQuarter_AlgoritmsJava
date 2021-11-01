package com.geekbrains.algorithms.lesson3;

public class Deque<T> {
    private final int DEFAULT_CAPACITY = 10;
    private T[] deque;
    private int size;
    private int front;
    private int end;

    public Deque(int size) throws IllegalAccessException {
        if (size <= 0){
            throw new IllegalAccessException();
        }
        this.deque = (T[]) new Object[size];
    }
    public Deque(){
        this.deque = (T[]) new Object[DEFAULT_CAPACITY];
    }
    public boolean isEmpty(){
       return (this.size == 0);
    }
    public boolean isFull(){
        return (this.size == deque.length);
    }

    public int size() {
        return size;
    }
    // 0 1 2 3 4
    //       F
    //   E
    // 7     3
    public void insertLeft(T item){
        if(isFull()){
            throw new RuntimeException("Deque is FULL");
        }
        size++;
        this.deque[end] = item;
        end = nextIndex(end);
    }
    public T remoteLeft(){
        T temp = peek();
        deque[end] = null;
        end = prevIndex(end);
        return temp;
    }
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Deque is EMPTY");
        }
        return deque[--end];
    }

    public void insertRight(T item){
        if(isFull()){
            throw new RuntimeException("Deque is FULL");
        }
        size++;
        front = prevIndex(front);
        deque[front] = item;
    }
    public T remoteRight(){
        T temp = peekFront();
        deque[front] = null;
        front = nextIndex(front);
        size--;
        return temp;
    }
    public T peekFront(){
        if(isEmpty()){
            throw new RuntimeException("Deque is EMPTY");
        }
        return deque[front];
    }
    public int nextIndex(int index){
        return (index + 1) % deque.length;
    }
    public int prevIndex(int index){
        if(index == 0) {
            return (index = deque.length-1);
        }
        return ((index - 1) % deque.length);
    }
}

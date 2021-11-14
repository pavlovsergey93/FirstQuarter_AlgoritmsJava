package com.geekbrains.algorithms.lesson3;

public class Queue<T> {
    private T[] queue;
    private int size;
    private int front;
    private int end;
    private final int DEFAULT_CAPACITY = 10;

    public Queue(int size) throws IllegalAccessException {
        if(size <= 0){
            throw new IllegalAccessException();
        }
        queue = (T[]) new Object[size];
    }
    public Queue(){
        queue = (T[]) new Object[DEFAULT_CAPACITY];
    }
    public void insert(T item){
        if(isFull()){
            throw new RuntimeException("Queue is full");
        }
        size++;
        queue[end] = item;
        end = nextIndex(end);
    }
    public T peekFront(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }
    public T remove(){
        T temp = peekFront();
        queue[front] = null;
        front = nextIndex(front);
        size--;
        return temp;
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public boolean isFull(){
        return (this.size == queue.length);
    }
    public int nextIndex(int index){
        return (index + 1) % queue.length;
    }
    public int size(){
        return size;
    }
}

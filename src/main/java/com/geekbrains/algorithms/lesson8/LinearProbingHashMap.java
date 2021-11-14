package com.geekbrains.algorithms.lesson8;

import java.util.LinkedList;

public class LinearProbingHashMap<K, V> {
    private int campacity;
    private int size;

    private K[] keys;
    private V[] values;

    public LinearProbingHashMap(int capacity){
        if (capacity <= 0){
            throw new IllegalArgumentException();
        }
        this.campacity = capacity;
        keys = (K[]) new Object[capacity];
        values = (V[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int hash (K key){
        return (key.hashCode() & 0x7fffffff) % campacity;
    }

    private int hash2 (K key){
        return 5 - (key.hashCode() & 0x7fffffff) % 5;
    }

    public void checkKeyNotNull(K key){
        if(key == null){
            throw new IllegalArgumentException();
        }
    }

    public  boolean contains(K key){
        return get(key) != null;
    }

    public V get(K key){
        checkKeyNotNull(key);
        for (int i = hash(key); keys[i] != null; i = (i+hash2(key)) % campacity){
            if(key.equals(keys[i])){
                return values[i];
            }
        }
        return null;
    }

    public void put (K key, V value){
        if(size == campacity-1){
            throw new RuntimeException("Is full");
        }
        checkKeyNotNull(key);
        int i;
        for (i = hash(key); keys[i] != null; i = (i+hash2(key)) % campacity){
            if(key.equals(keys[i])){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }
}

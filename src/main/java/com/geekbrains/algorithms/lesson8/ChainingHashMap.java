package com.geekbrains.algorithms.lesson8;

import java.util.LinkedList;

public class ChainingHashMap<K, V>{
    private int campacity;

    public ChainingHashMap(int campacity){
        if (campacity <= 0){
            throw new IllegalArgumentException();
        }
        this.campacity = campacity;
        st = new LinkedList[campacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }
    public int size() {
        return size;
    }

    private int size;

    private LinkedList<Node>[] st;

    private class Node{
        K key;
        V value;
         public Node (K key, V value){
             this.key = key;
             this.value = value;
         }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int hash (K key){
        return (key.hashCode() & 0x7fffffff) % campacity;
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
        int i = hash(key);
        for (Node node : st[i]) {
            if(key.equals(node.key)){
                return node.value;
            }
        }
        return null;
    }

    public void put (K key, V value){
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if(key.equals(node.key)){
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    public void delete(K key){
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if(key.equals(node.key)){
                node.value = null;
                node.key = null;
                size--;
                return;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < campacity; i++) {
            for(Node node: st[i]){
                sb.append(node.key).append(" = ").append(node.value).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

package com.geekbrains.algorithms.lesson6;

import java.util.NoSuchElementException;

public class MyTree<K extends Comparable<K>, V>{
    private Node root;

    private class Node{

        K key;
        V value;
        Node leftTree;
        Node rightTree;
        int size;
        int height;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.size = 1;
            height = 0;
        }
    }
    public V get(K key) {
        checkKeyNotNull(key);
        return get(root, key);
    }
    private V get(Node node, K key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            return node.value;
        }else if(cmp < 0){
            return get(node.leftTree, key);
        }else {
            return get(node.rightTree, key);
        }
    }
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if (node == null){
            return 0;
        }else if(node.leftTree == null && node.rightTree == null){
            return 0;
        }else if(node.leftTree == null){
            return node.rightTree.height + 1;
        }else if(node.rightTree == null){
            return node.leftTree.height + 1;
        }else{
            return (Math.max(node.leftTree.height, node.rightTree.height) + 1);
        }
    }

    public int size(){
        return size(root);
    }
    private int size(Node node){
        if(node == null){
            return 0;
        }
        return node.size;
    }

    public boolean isEmpty(){
        return root == null;
    }

    private void checkKeyNotNull(K key){
        if (key == null){
            throw new IllegalArgumentException("Kay null");
        }
    }

    public void put(K key, V value){
        checkKeyNotNull(key);
        if (value == null){
            //delete(key)
            return;
        }
        root = put(root, key, value);
    }
    private Node put(Node node, K key, V value) {
        if(node == null){
            return  new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            node.value = value;
        }else if(cmp < 0){
            node.leftTree = put(node.leftTree, key, value);
        }else{ // cmp > 0
            node.rightTree = put(node.rightTree, key, value);
        }
        node.size = 1 + size(node.leftTree) + size(node.rightTree);
        node.height = height(node);
        return node;
    }

    public K minKey(){
        return findMinNode(root).key;
    }
    public Node findMinNode(Node node){
        if(node.leftTree == null){
            return node;
        }
        return findMinNode(node.leftTree);
    }
    public void deleteMin(Node node){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        deleteMinNode(root);
    }
    private Node deleteMinNode(Node node){
        if(node.leftTree == null){
            return node.rightTree;
        }
        node.leftTree = deleteMinNode(node.leftTree);
        node.size = 1 + size(node.leftTree) + size(node.rightTree);
        node.height = height(node);
        return node;
    }

    public Node findMaxNode(Node node){
        if(node.rightTree == null){
            return node;
        }
        return findMaxNode(node.rightTree);
    }

    public void deleteToKey(K key){
        checkKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            node.leftTree = delete(node.leftTree, key);
        }else if(cmp > 0){
            node.rightTree = delete(node.rightTree, key);
        }else{
            if (node.leftTree == null){
                return node.rightTree;
            }
            if(node.rightTree == null){
                return node.leftTree;
            }
            Node temp = node;
            node = findMinNode(node.rightTree);
            node.rightTree = deleteMinNode(temp.rightTree);
            node.leftTree = temp.leftTree;
        }
        node.size = 1 + size(node.leftTree) + size(node.rightTree);
        node.height = height(node);
        return node;
    }
    public boolean isBalance() {
        return isBalance(root);
    }
    private boolean isBalance(Node node){
        if (node == null){
            return true;
        }else if (node.leftTree == null && node.rightTree == null){
            return true;
        }else if (height(node.leftTree) - height(node.rightTree) <= 1
                && isBalance(node.leftTree)
                && isBalance(node.rightTree)){
            return  true;
        }
        return false;

    }

}

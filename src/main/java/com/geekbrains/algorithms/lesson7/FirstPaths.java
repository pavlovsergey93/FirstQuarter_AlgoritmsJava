package com.geekbrains.algorithms.lesson7;

import java.util.LinkedList;

public abstract class FirstPaths {
    private boolean marker[];
    private int edgeTo[];
    private int source;

    public boolean hasPathTo(int toVex) {
        return marker[toVex];
    }

    public LinkedList<Integer> pathTo(int toVex) {
        if (!hasPathTo(toVex)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = toVex;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}

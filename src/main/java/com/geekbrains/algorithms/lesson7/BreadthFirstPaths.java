package com.geekbrains.algorithms.lesson7;

import java.util.LinkedList;

public class BreadthFirstPaths{
    private boolean marker[];
    private int edgeTo[];
    private int source;

    public BreadthFirstPaths(Graph graph, int source) {
        this.source = source;
        marker = new boolean[graph.getCountVer()];
        edgeTo = new int[graph.getCountVer()];
        bfp(graph, source);
    }

    public void bfp(Graph graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(source);
        marker[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.removeLast();
            for (int w : graph.getGraphList(vertex)) {
                if (!marker[w]) {
                    marker[w] = true;
                    edgeTo[w] = vertex;
                    queue.addFirst(w);
                }
            }
        }
    }
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



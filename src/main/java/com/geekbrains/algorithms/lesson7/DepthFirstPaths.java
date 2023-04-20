package com.geekbrains.algorithms.lesson7;

import java.util.LinkedList;

public class DepthFirstPaths {
    private boolean marker[];
    private int edgeTo[];
    private int source;

    public DepthFirstPaths(Graph graph, int source){
        this.source = source;
        marker = new boolean[graph.getCountVer()];
        edgeTo = new int[graph.getCountVer()];
        dfp(graph, source);
    }
    // Обход в глубину
    private void dfp(Graph graph, int v){
        marker[v] = true;
        for(int w: graph.getGraphList(v)){
            if(marker[w] == false){
                edgeTo[w] = v;
                dfp(graph, w);
            }
        }
    }

    public boolean hasPathTo(int toVex){
        return marker[toVex];
    }

    public LinkedList<Integer> pathTo(int toVex){
        if(!hasPathTo(toVex)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = toVex;
        int way = 0;
        while (vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
            way++;
        }
        System.out.println("Длина пути: " + way);
        return stack;

    }
}

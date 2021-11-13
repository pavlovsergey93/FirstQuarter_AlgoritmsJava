package com.geekbrains.algorithms.lesson7;

import java.util.LinkedList;
import java.util.function.IntToDoubleFunction;

public class Graph{
    private int countVer;
    private int countEdge;
    private LinkedList<Integer>[] graphList;

    public Graph(int countVer) {
        if (countVer <= 0) {
            throw new IllegalArgumentException("countVer" + countVer);
        }
        this.countVer = countVer;
        graphList = new LinkedList[countVer];
        for (int i = 0; i < graphList.length; i++) {
            graphList[i] = new LinkedList<>();
        }
    }

    public void addEdgeInGraph(int v1, int v2){
        if(v1 < 0 || v2 < 0 || v1 > countVer || v2 > countVer){
            throw new IllegalArgumentException();
        }
        graphList[v1].add(v2);
        if(v1 != v2){
            graphList[v2].add(v1);
        }
        countEdge++;
    }

    public int getCountVer() {
        return countVer;
    }

    public int getCountEdge() {
        return countEdge;
    }

    public LinkedList<Integer> getGraphList(int vertex) {
        return (LinkedList<Integer>) graphList[vertex].clone();
    }
}

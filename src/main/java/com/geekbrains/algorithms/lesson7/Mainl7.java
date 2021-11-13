package com.geekbrains.algorithms.lesson7;

public class Mainl7 {
    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addEdgeInGraph(1, 2);
        graph.addEdgeInGraph(1, 3);
        graph.addEdgeInGraph(1, 6);
        graph.addEdgeInGraph(2, 4);
        graph.addEdgeInGraph(2, 10);
        graph.addEdgeInGraph(3, 4);
        graph.addEdgeInGraph(3, 6);
        graph.addEdgeInGraph(4, 8);
        graph.addEdgeInGraph(5, 10);
        graph.addEdgeInGraph(6, 7);
        graph.addEdgeInGraph(7, 8);
        graph.addEdgeInGraph(7, 9);
        graph.addEdgeInGraph(8, 9);
        graph.addEdgeInGraph(8, 10);

        System.out.println(graph.getCountEdge());
        System.out.println(graph.getCountVer());
        System.out.println(graph.getGraphList(2));
        System.out.println(graph.getGraphList(5));
        System.out.println();

        DepthFirstPaths dfp = new DepthFirstPaths(graph, 1);
        System.out.println(dfp.hasPathTo( 3));
        System.out.println(dfp.pathTo(3));
        System.out.println();

        BreadthFirstPaths bfp = new BreadthFirstPaths(graph,1);
        System.out.println(bfp.hasPathTo(3));
        System.out.println(bfp.pathTo(3));

    }
}

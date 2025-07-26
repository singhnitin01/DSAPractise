package graph1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyListUnDirected {

    static void addEdgesToGraph(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void displayAdjacenyList(List<List<Integer>> graph) {
        if(graph == null) {
            System.out.println("Empty graph");
        }
        System.out.println("Graph:");
        for(int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for(int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " -> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer V = 4;
        List<List<Integer>> graph = new ArrayList<>(V);
        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>());
        }
        addEdgesToGraph(graph, 0, 1);
        addEdgesToGraph(graph, 0, 2);
        addEdgesToGraph(graph, 1, 2);
        addEdgesToGraph(graph, 1, 3);

        displayAdjacenyList(graph);
    }
}

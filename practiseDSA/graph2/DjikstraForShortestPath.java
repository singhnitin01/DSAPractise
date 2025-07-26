package graph2;

import graph1.ShortestPathInDirectedGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
* For an undirected weighted graph, Djikstra's algorithm helps us find the shortest path from source vertex to
* all the vertex.
* */
public class DjikstraForShortestPath {

    /*
    Input #of test cases: 1
    Input V: 6
    Input number of edges E: 8
    Enter Edges with weight:
    0 - 0 1 4
    1 - 0 2 4
    2 - 1 2 2
    3 - 2 3 3
    4 - 2 4 1
    5 - 2 5 6
    6 - 3 5 2
    7 - 4 5 3
    Shortest Distance in UnDirected, weighted Graph:
* */


    static class Pair {
        int node;
        int dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static void addEdgesToUnDirectedGraph(List<List<int[]>> adjList, int u, int v, int weight) {
        adjList.get(u).add(new int[]{v, weight});
        adjList.get(v).add(new int[]{u, weight});
    }

    public static void main(String[] args) throws IOException {
        ShortestPathInDirectedGraph obj = new ShortestPathInDirectedGraph();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input #of test cases: ");
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- > 0) {
            System.out.print("Input V: ");
            int V = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> adjList = new ArrayList<>(V);
            for(int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }

            System.out.print("Input number of edges E: ");
            int E = Integer.parseInt(br.readLine().trim());

            System.out.println("Enter Edges with weight:"); // first u , then v and then weight
            for(int i = 0; i < E; i++) {
                System.out.print(i + " - ");
                String[] edgeAndWeight = br.readLine().trim().split(" ");
                addEdgesToUnDirectedGraph(adjList, Integer.parseInt(edgeAndWeight[0]), Integer.parseInt(edgeAndWeight[1]), Integer.parseInt(edgeAndWeight[2]));
            }

            int[] dist = shortestDistanceUsingDjikstras(adjList, 0);
            System.out.println("Shortest Distance in UnDirected, weighted Graph:" );
            for(int i = 0; i < V; i++) {
                System.out.print(dist[i] + " ");
            }
            System.out.println("\n--------------- Done! ---------------");
        }
    }

    public static int[] shortestDistanceUsingDjikstras(List<List<int[]>> adjList, int src) {
        int[] distance = new int[adjList.size()];
        PriorityQueue<Pair> pqueue = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        for(int i = 0; i < adjList.size(); i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        pqueue.add(new Pair(src, 0));
        distance[src] = 0;

        while(!pqueue.isEmpty()) {
            Pair polled = pqueue.poll();

            for(int[] vertex: adjList.get(polled.node)) {
                if( distance[vertex[0]] > polled.dist + vertex[1]) {
                    distance[vertex[0]] = polled.dist + vertex[1];
                    pqueue.add(new Pair(vertex[0], distance[vertex[0]]));
                }
            }
        }
        return distance;
    }
}


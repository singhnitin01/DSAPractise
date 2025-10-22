package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellManFordShortestPath {
    //GFG Link: https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

    /*
    * BellMan Ford Algorithm helps us find the shortest path in directed, weighted graph
    * Intuition: We relax all the edges V-1 times
    * And at Vth iteration we can detect if there's negative weight cycle.
    * We relax V-1 times since there is chance that src vertex edge can be at the last
    * */

    /*    Input #of test cases: 2
        Input V: 5
        Input number of edges E: 5
        Enter Edges with weight:
        0 - 1 3 2
        1 - 4 3 -1
        2 - 2 4 1
        3 - 1 2 1
        4 - 0 1 5
        Shortest Distance in UnDirected, weighted Graph:
        0 5 6 6 7
        --------------- Done! ---------------
        Input V: 4
        Input number of edges E: 4
        Enter Edges with weight:
        0 - 0 1 4
        1 - 1 2 -6
        2 - 2 3 5
        3 - 3 1 -2
        Shortest Distance in UnDirected, weighted Graph:
        -1 -1 -1 -1
        --------------- Done! ---------------
    *
    * */

    public static void main(String[] args) throws IOException {
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
            int[][] edges = new int[E][3];
            for(int i = 0; i < E; i++) {
                System.out.print(i + " - ");
                String[] edgeAndWeight = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(edgeAndWeight[0]); // from node
                edges[i][1] = Integer.parseInt(edgeAndWeight[1]); // to node
                edges[i][2] = Integer.parseInt(edgeAndWeight[2]); // weight from to destination node
            }

            int[] dist = shortestDistanceBellManFord(V, edges, 0);
            System.out.println("Shortest Distance in UnDirected, weighted Graph:" );
            for(int i = 0; i < V; i++) {
                System.out.print(dist[i] + " ");
            }
            System.out.println("\n--------------- Done! ---------------");
        }
    }

    static int[] shortestDistanceBellManFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;

        for ( int i = 0; i < V-1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != (int) 1e8 && wt + dist[u] < dist[v]) {
                    dist[v] = wt + dist[u];
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != (int) 1e8 && wt + dist[u] < dist[v]) {
                Arrays.fill(dist, -1);
                return dist;
            }
        }
        return dist;
    }
}

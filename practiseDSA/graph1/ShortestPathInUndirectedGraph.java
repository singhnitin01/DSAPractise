package graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {

    /* Example of test case:
        Input #of test cases: 2
        Input V: 4
        Input list: 1 2
        Input list: 0 2 3
        Input list: 0 1 3
        Input list: 1 2

        Shortest path in undirected graph from 0: 0 1 1 2
        --------------- Done! ---------------
        Input V: 6
        Input list: 1 2 4
        Input list: 0 3
        Input list: 0 3 4
        Input list: 1 2 5
        Input list: 0 2 5
        Input list: 3 4

        Shortest path in undirected graph from 0: 0 1 1 2 1 2
        --------------- Done! ---------------
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input #of test cases: ");
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- > 0) {
            System.out.print("Input V: ");
            int V = Integer.parseInt(br.readLine().trim());
            List<List<Integer>> adjList = new ArrayList<>(V);
            for(int i = 0; i < V; i++) {
                System.out.print("Input list: ");
                String[] vertices = br.readLine().trim().split(" ");
                List<Integer> listOfVertices = new ArrayList<>();
                for(String vertex : vertices) {
                    listOfVertices.add(Integer.parseInt(vertex));
                }
                adjList.add(listOfVertices);
            }
            Solver solver = new Solver();
            int[] shortestPath = solver.shortestPathInUndirectedGraph(adjList);
            System.out.print("\nShortest path in undirected graph from 0: ");
            for(int i = 0; i < adjList.size(); i++) {
                System.out.print(shortestPath[i] +" ");
            }
            System.out.println("\n--------------- Done! ---------------");
        }
    }
}


class Solver {
    public int[] shortestPathInUndirectedGraph(List<List<Integer>> adjList) {
        int[] dist = new int[adjList.size()];
        for(int i = 0; i < adjList.size(); i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        int[] arr = new int[5];
        int length = arr.length;
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        dist[0] = 0;
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int i = 0; i < adjList.get(u).size(); i++) {
                int v = adjList.get(u).get(i);
                if(visited[v] == false) {
                    dist[v] = dist[u] + 1;
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        return dist;
    }
}
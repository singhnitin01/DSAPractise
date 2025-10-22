package graph2;

// https://leetcode.com/problems/critical-connections-in-a-network/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bridges {
    static int timer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input #of test cases: ");
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- > 0) {
            timer = 0;
            System.out.print("Input V: ");
            int V = Integer.parseInt(br.readLine().trim());
            List<List<Integer>> adjList = new ArrayList<>(V);
            for(int i = 0; i < V; i++) {
                System.out.print("Input list: ");
                String[] vertices = br.readLine().trim().split(" ");
                List<Integer> listOfVertices = new ArrayList<>();
                if(!vertices[0].isEmpty()) {
                    for(String vertex : vertices) {
                        listOfVertices.add(Integer.parseInt(vertex));
                    }
                }
                adjList.add(listOfVertices);
            }
            System.out.println("Bridges in graph are: " + findBridges(V, adjList));
            System.out.println("\n--------------- Done! ---------------");
        }
    }

    public static List<List<Integer>> findBridges(int n, List<List<Integer>> adjList) {
        List<List<Integer>> bridges = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] disc = new int[n];
        int[] low = new int[n];

        dfsRecursive(adjList, bridges, visited, disc, low, -1, 0);
        return bridges;
    }

    public static void dfsRecursive(List<List<Integer>> adjList, List<List<Integer>> bridges,
                             boolean[] visited, int[] disc, int[] low, int parent, int node) {
        visited[node] = true;
        disc[node] = low[node] = timer++;

        for(int adjNode : adjList.get(node)) {
            if(adjNode == parent) continue;
            if(!visited[adjNode]) {
                dfsRecursive(adjList, bridges, visited, disc, low, node, adjNode);
                low[node] = Math.min(low[node], low[adjNode]);
                if(low[adjNode] > disc[node]) {
                    bridges.add(Arrays.asList(node, adjNode));
                }
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
                // if we can reach adjNode then even though we remove adjNode, we can reach its parents too.
            }
        }
    }
}

package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class TarjansStronglyConnectedGraph {

//    https://www.geeksforgeeks.org/problems/strongly-connected-component-tarjanss-algo-1587115621/1
    // Tarjan's Algorithm for find Strongly Connected Graph in Directed Graph.

    static int timer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input #of test cases: ");
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- > 0) {
            timer = 0;
            System.out.print("Input V: ");
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(V);
            for(int i = 0; i < V; i++) {
                System.out.print("Input list: ");
                String[] vertices = br.readLine().trim().split(" ");
                ArrayList<Integer> listOfVertices = new ArrayList<>();
                if(!vertices[0].isEmpty()) {
                    for(String vertex : vertices) {
                        listOfVertices.add(Integer.parseInt(vertex));
                    }
                }
                adjList.add(listOfVertices);
            }
            System.out.println("Strongly Connected graphs are: " + tarjans(V, adjList));
            System.out.println("\n--------------- Done! ---------------");
        }
    }

    // Function to return a list of lists of integers denoting the members
    // of strongly connected components in the given graph.
    public static ArrayList<ArrayList<Integer>> tarjans(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<ArrayList<Integer>> sccs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] recurStack = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        for (int i = 0; i < V; i++) {
            disc[i] = -1;
            low[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1)
                dfs(adj, sccs, stack, recurStack, disc, low, i);
        }
        return sccs;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> sccs,
             Stack<Integer> stack, boolean[] recurStack, int[] disc, int[] low,
             int node) {
        recurStack[node] = true;
        stack.push(node);
        disc[node] = low[node] = timer++;

        for(int adjNode: adj.get(node)) {
            if(disc[adjNode] == -1) {
                dfs(adj, sccs, stack,recurStack, disc, low, adjNode);
                low[node] = Math.min(low[node], low[adjNode]);
            } else {
                // i.e. it's not a cross edge i.e. it's part of same recursion stack
                // i.e. it's a back edge
                if(recurStack[adjNode] == true) {
                    low[node] = Math.min(low[node], disc[adjNode]);
                }
            }

        }

        // if discovery time and lowest discovery time from node is same
        // then all the edges from this till end of stack are part of Strongly connected component.
        if(disc[node] == low[node]) {
            ArrayList<Integer> scc = new ArrayList<>();
            int popped = -1;
            do {
                popped = stack.pop();
                recurStack[popped] = false;
                scc.add(popped);
            } while(popped != node);
            sccs.add(scc);
        }
    }

}

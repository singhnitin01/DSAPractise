package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuStronglyConnectedGraph {

    //https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
    // Kosraju's Algorithm also helps us find the Strongly connected components in graph in O(V+E) time same
    // as Tarjan's algorithm

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input #of test cases: ");
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- > 0) {
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
            System.out.println("Number of strongly connected components are: " + kosaraju( adjList));
            System.out.println("\n--------------- Done! ---------------");
        }
    }

    public static int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        //1. sort the vertex in decreasing order of finish time using topoSort
        Stack<Integer> stack = topoSort(V, adj);

        //2. reverse the edges i.e. transpose the graph
        ArrayList<ArrayList<Integer>> transposedAdj = reverseEdges(V, adj);

        //3. we do normal DFS and count the number DFS is called and it's the number or
        //Strongly Connected Component
        int sccCount = getCountOfScc(stack, transposedAdj);

        return sccCount;
    }

    // topoSort creates a decreasing order of finish time
    static Stack<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                dfs(adj, visited, stack, i);
            }
        }
        return stack;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack,
             int node) {
        visited[node] = true;
        for(int adjNode: adj.get(node)) {
            if(visited[adjNode] == false) {
                dfs(adj, visited, stack, adjNode);
            }
        }
        stack.push(node);
    }

    static ArrayList<ArrayList<Integer>> reverseEdges(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> transposedAdj = new ArrayList<>(V);
        for(int i = 0; i < V; i++) {
            transposedAdj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < V; i++) {
            for(int adjNode: adj.get(i)) {
                transposedAdj.get(adjNode).add(i);
            }
        }
        return transposedAdj;
    }

    static int getCountOfScc(Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        int countOfSccs = 0;

        Stack<Integer> auxStack = new Stack<>();

        while(!stack.isEmpty()) {
            int popped = stack.pop();
            if(visited[popped] == false) {
                dfs(adj, visited, auxStack, popped);
                countOfSccs++;
            }
        }
        return countOfSccs;
    }
}

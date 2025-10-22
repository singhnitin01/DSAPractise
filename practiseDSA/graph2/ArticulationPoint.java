package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {

    /*https://www.geeksforgeeks.org/problems/articulation-point-1/1
    *
    * */

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
            System.out.println("Articulation Points are: " + articulationPoints(V, adjList));
            System.out.println("\n--------------- Done! ---------------");
        }
    }
    // Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> articulationPoints(int V,
                                                        List<List<Integer>> adj) {
        ArrayList<Integer> articulationPoints = new ArrayList<>();
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] mark = new boolean[V];

        dfs(adj, visited, mark, disc, low, 0, -1);

        for(int i = 0; i < V; i++) {
            if(mark[i])
                articulationPoints.add(i);
        }
        if(articulationPoints.isEmpty())
            articulationPoints.add(-1);
        return articulationPoints;
    }

    public static void dfs(List<List<Integer>>  adj, boolean[] visited, boolean[] mark, int[] disc,
                    int[] low, int node, int parent) {
        visited[node] = true;
        disc[node] = low[node] = timer++;
        int child = 0;

        for(int adjNode: adj.get(node)) {
            if(adjNode == parent) continue;
            if(!visited[adjNode]) {
                dfs(adj, visited, mark, disc, low, adjNode, node);
                low[node] = Math.min(low[node], low[adjNode]);
                if(low[adjNode] >= disc[node] && parent != -1) {
                    mark[node] = true;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], disc[adjNode]);
                // because if we remove adjNode then node could not reach ancestors of adjNode.
            }
        }

        if(child > 1 && parent == -1){ // root node condition
            mark[node] = true;
        }
    }

}

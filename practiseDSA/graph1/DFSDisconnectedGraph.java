package graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DFSDisconnectedGraph {

    /* Example of test case:
        Input #of test cases: 2
        Input V: 5
        Input list: 1 2
        Input list: 0 2
        Input list: 0 1
        Input list: 4
        Input list: 3

        DFS traversal for disconnected graph: 0 1 2 3 4
        Total islands are: 2
        --------------- Done! ---------------
        Input V: 7
        Input list: 1 2
        Input list: 0 3
        Input list: 0 3
        Input list: 1 2
        Input list: 5 6
        Input list: 4 6
        Input list: 4 5

        DFS traversal for disconnected graph: 0 1 3 2 4 5 6
        Total islands are: 2
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
            DFSDisconnectedGraphTraversal dfsDisconnectedGraphTraversal = new DFSDisconnectedGraphTraversal();
            System.out.print("\nDFS traversal for disconnected graph: ");
            dfsDisconnectedGraphTraversal.dfsForDisconnectedGraph(adjList);
            System.out.println("\n--------------- Done! ---------------");
        }
    }
}

class DFSDisconnectedGraphTraversal {
    public void dfsForDisconnectedGraph(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        int island = 0;
        for(int i = 0; i < adjList.size(); i++) {
            if(visited[i] == false) {
                dfsRecursive(adjList, visited, i);
                island++;
            }
        }
        System.out.print("\nTotal islands are: " + island);
    }

    private void dfsRecursive(List<List<Integer>> adjList, boolean[] visited, int source) {
        System.out.print(source + " ");
        visited[source] = true;
        for(int i = 0; i < adjList.get(source).size(); i++) {
            int vertex = adjList.get(source).get(i);
            if(visited[vertex] == false) {
                dfsRecursive(adjList, visited, vertex);
            }
        }
    }
}

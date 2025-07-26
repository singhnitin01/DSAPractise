package graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS traversal of disconnected graph and also number of island problem in disconnected graph
public class BFSDisconnectedGraph {
    /* Example of test case:
        #of Test Cases: 1
                -----------------TEST CASE--------------------
        Enter the number of vertices: 7
        Enter the list of vertices: 1 2
        Enter the list of vertices: 0 3
        Enter the list of vertices: 0 3
        Enter the list of vertices: 1 2
        Enter the list of vertices: 5 6
        Enter the list of vertices: 4 6
        Enter the list of vertices: 4 5
        Number of islands are: 2
        BFS Traversal for disconnected graph is: [0, 1, 2, 3, 4, 5, 6]
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("#of Test Cases: ");
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- > 0) {
            System.out.println("-----------------TEST CASE--------------------");
            System.out.print("Enter the number of vertices: ");
            int V = Integer.parseInt(br.readLine().trim());
            List<List<Integer>> adjList = new ArrayList<>(V);

            for(int i = 0; i < V; i++) {
                System.out.print("Enter the list of vertices: ");
                String[] vertices = br.readLine().trim().split(" ");
                List<Integer> listOfVertices = new ArrayList<>();
                for(String vertex: vertices) {
                    listOfVertices.add(Integer.parseInt(vertex));
                }
                adjList.add(listOfVertices);
            }

            BFSDisconnectedGraphTraversal bfsDSGraph = new BFSDisconnectedGraphTraversal();
            List<Integer> bfsTraversalInDisconnectedGraph = bfsDSGraph.bfsDisconnectedTraversal(adjList);

            System.out.print("BFS Traversal for disconnected graph is: " + bfsTraversalInDisconnectedGraph);
        }

    }
}

class BFSDisconnectedGraphTraversal {
    public List<Integer> bfsDisconnectedTraversal(List<List<Integer>> adjList) {
        List<Integer> bfsTraversalInDisconnectedGraph = new ArrayList<>();
        boolean[] visited = new boolean[adjList.size()];
        int numberOfIslands = 0;
        for(int i = 0; i < adjList.size(); i++) {
            if(!visited[i]) {
                List<Integer> bfsTraversedList = bfsTraversal(adjList, visited, i);
                bfsTraversalInDisconnectedGraph.addAll(bfsTraversedList);
                numberOfIslands++;
            }
        }
        System.out.println("Number of islands are: " + numberOfIslands);
        return bfsTraversalInDisconnectedGraph;
    }

    private List<Integer> bfsTraversal(List<List<Integer>> adjList, boolean[] visited, int source) {
        List<Integer> bfsTraversal = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()) {
            int polled = queue.poll();
            bfsTraversal.add(polled);
            for(int i = 0; i < adjList.get(polled).size(); i++) {
                int vertex = adjList.get(polled).get(i);
                if(!visited[vertex]) {
                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }
        }
        return bfsTraversal;
    }
}

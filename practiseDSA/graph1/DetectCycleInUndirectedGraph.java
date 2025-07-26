package graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {
    /*e.g.
        Input #of test cases: 3
        Input V: 5
        Input list: 1
        Input list: 0 2 3
        Input list: 1 4
        Input list: 1 4
        Input list: 2 3
        Graph is cyclic: true

        --------------- Done! ---------------
        Input V: 5
        Input list: 1
        Input list: 0 2 3
        Input list: 1
        Input list: 1 4
        Input list: 3
        Graph is cyclic: false

        --------------- Done! ---------------
        Input V: 6
        Input list: 1
        Input list: 0
        Input list: 3 4
        Input list: 2 5
        Input list: 2 5
        Input list: 3 4
        Graph is cyclic: true

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
            System.out.println("Graph is cyclic using BFS: " + isCycleInGraphDisconnectedUsingBFS(adjList));
            System.out.println("Graph is cyclic using DFS: " + isCycleInGraphDisconnectedUsingDFS(adjList));
            System.out.println("\n--------------- Done! ---------------");
        }
    }
    public static boolean isCycleInGraphDisconnectedUsingBFS(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];

        for(int i = 0;  i < adjList.size(); i++) {
            if(!visited[i]) {
                if(isCyclic(adjList, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclic(List<List<Integer>> adjList, boolean[] visited, int source) {
        Queue<int[]> queue = new LinkedList<>();

        int[] pair = new int[]{source, -1};
        queue.add(pair);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int[] popped = queue.poll();
            int poppedVal = popped[0];
            int parentOfVal = popped[1];

            for(int i = 0; i < adjList.get(poppedVal).size(); i++) {
                int vertex = adjList.get(poppedVal).get(i);

                if(!visited[vertex]) {
                    queue.add(new int[]{vertex, poppedVal});
                    visited[vertex] = true;
                } else if (vertex != parentOfVal) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleInGraphDisconnectedUsingDFS(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];

        for(int i = 0;  i < adjList.size(); i++) {
            if(!visited[i]) {
                if(isCyclicRecursive(adjList, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicRecursive(List<List<Integer>> adjList, boolean[] visited, int source, int parent) {
        visited[source] = true;
        for(int i = 0; i < adjList.get(source).size(); i++) {
            int vertex = adjList.get(source).get(i);
            if(visited[vertex] == false) {
                boolean isCyclic = isCyclicRecursive(adjList, visited, vertex, source);
                if(isCyclic)
                    return true;
            } else if( vertex != parent){
                return true;
            }
        }
        return false;
    }
}

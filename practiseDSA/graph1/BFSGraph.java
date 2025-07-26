package graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {
/*
    Test case:
    Input #of test cases: 1
    Input V: 5
    Input list: 2 3 1
    Input list: 0
    Input list: 0 4
    Input list: 0
    Input list: 2

    BFS traversal: [0, 2, 3, 1, 4]
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
            BFSTraversal bfsTraversal = new BFSTraversal();
            System.out.print("\nBFS traversal: " + bfsTraversal.bfs(adjList) + "\n");
            System.out.println("--------------- Done! ---------------");
        }
    }
}

class BFSTraversal {
    public ArrayList<Integer> bfs(List<List<Integer>> adjList) {
        ArrayList<Integer> bfsTraversedList = new ArrayList<>(adjList.size());
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);

        while(!queue.isEmpty()) {
            Integer polled = queue.poll();
            bfsTraversedList.add(polled);
            for(int i = 0; i < adjList.get(polled).size(); i++) {
                Integer vertex = adjList.get(polled).get(i);
                // if vertex is not visited
                if(visited[vertex] == false) {
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }
        }

        return bfsTraversedList;
    }
}



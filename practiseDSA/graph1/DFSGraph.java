package graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSGraph {
    /* Example of test case:
        Input #of test cases: 1
        Input V: 6
        Input list: 1 2
        Input list: 0 3 4
        Input list: 0 3
        Input list: 1 2
        Input list: 1 5
        Input list: 4

        DFS traversal: 0 1 3 2 4 5
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
            DFSTraversal dfsTraversal = new DFSTraversal();
            System.out.print("\nDFS traversal: ");
            dfsTraversal.dfsTraversal(adjList);
            System.out.println("\nDFS using stack: " + dfsTraversal.dfsUsingStack(adjList));
            System.out.println("\n--------------- Done! ---------------");
        }
    }
}

class DFSTraversal {
    public void dfsTraversal(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        dfsRecursive(adjList, visited, 0);
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

    //https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
    //Check my gfg solution in submission using stack


    //Here we mark the node as visited only once popped because there are chances if we mark it as visited when we push
    // that we won't push to stack if it's visited. That way if the node should have been reached via depth won't get reached
    // as it was not allowed to push on to stack.
    public ArrayList<Integer> dfsUsingStack(List<List<Integer>> adjList) {
        ArrayList<Integer> dfsTraversedList = new ArrayList<>(adjList.size());
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        while(!stack.isEmpty()) {
            int popped = stack.pop();

            if(visited[popped] == true)
                continue;

            dfsTraversedList.add(popped);
            visited[popped] = true;

            // start from last of adjacent vertex since we always pop last in element
            for(int i = adjList.get(popped).size() - 1; i >= 0; i--) {
                int vertex = adjList.get(popped).get(i);
                if(visited[vertex] == false) {
                    //NOTE: we don't mark the vertex as visited since it could get visited first from other path in DFS.
                    stack.push(vertex);
                }
            }
        }
        return dfsTraversedList;
    }
}


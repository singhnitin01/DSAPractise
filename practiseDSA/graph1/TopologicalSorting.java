package graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Kahn's BFS algorithm to get topological sorting of directed acyclic graph (DAG)
public class TopologicalSorting {

    /*
        sInput #of test cases: 1
        Input V: 5
        Input list: 1
        Input list: 3
        Input list: 3 4
        Input list: 4
        Input list:
        Kahn's BFS topological sorting: [0, 2, 1, 3, 4]
        Topological sorting using DFS: [2, 0, 1, 3, 4]
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
                if(!vertices[0].equals("") ) {
                    for(String vertex : vertices) {
                        listOfVertices.add(Integer.parseInt(vertex));
                    }
                }
                adjList.add(listOfVertices);
            }
            System.out.println("Kahn's BFS topological sorting: " + topologicalSortBFS(adjList));
            System.out.println("Topological sorting using DFS: " + topologicalSortDFS(adjList));
            System.out.println("\n--------------- Done! ---------------");
        }
    }

    //Here we don't need to worry about missing any vertex since it adds indegree for all the vertices
    public static List<Integer> topologicalSortBFS(List<List<Integer>> adjList) {
        List<Integer> toposort = new ArrayList<>(adjList.size());
        int[] indegree = new int[adjList.size()];

        for(int i = 0; i < adjList.size(); i++) {
            for(int vertex: adjList.get(i))
                indegree[vertex]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < adjList.size(); i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int polled = queue.poll();
            toposort.add(polled);
            for(int vertex: adjList.get(polled)) {
                indegree[vertex]--;
                if(indegree[vertex] == 0) {
                    queue.add(vertex);
                }
            }
        }
        return toposort;
    }

    public static List<Integer> topologicalSortDFS(List<List<Integer>> adjList) {
        List<Integer> toposort = new ArrayList<>(adjList.size());
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adjList.size()];

        for(int i = 0; i < adjList.size(); i++) {
            if(visited[i] == false) {
                recursiveDFS(adjList, i, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            toposort.add(stack.pop());
        }
        return toposort;
    }

    public static void recursiveDFS(List<List<Integer>> adjList, int src, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;
        for(int vertex: adjList.get(src)) {
            if(visited[vertex] == false) {
                recursiveDFS(adjList, vertex, visited, stack);
            }
        }
        stack.push(src);
    }

}

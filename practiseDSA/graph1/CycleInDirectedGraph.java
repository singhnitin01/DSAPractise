package graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//check out my solution at gfg https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class CycleInDirectedGraph {
    /*
        Input #of test cases: 2
        Input V: 4
        Input list: 1 2
        Input list: 2
        Input list: 0 3
        Input list:
        Graph is cyclic using DFS: true
        Graph is cyclic using BFS(Kahn's topological sorting): true

        --------------- Done! ---------------
        Input V: 4
        Input list: 1 2
        Input list: 2
        Input list: 3
        Input list:
        Graph is cyclic using DFS: false
        Graph is cyclic using BFS(Kahn's topological sorting): false*/

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
            System.out.println("Graph is cyclic using DFS: " + isCycleInDirectedGraph(adjList));
            System.out.println("Graph is cyclic using BFS(Kahn's topological sorting): " + isCycleInDirectedGraphUsingTopologicalSorting(adjList));
            System.out.println("\n--------------- Done! ---------------");
        }
    }

    //Topological Sorting can only be applied to DAGs (Directed Acyclic Graph) and this can be used
    // to determine if the graph is cyclic if all the vertex are not traversed in topological sorting
    static boolean isCycleInDirectedGraphUsingTopologicalSorting(List<List<Integer>> adjList) {
        int[] indegree = new int[adjList.size()];
        for(int i = 0; i < adjList.size(); i++) {
            for(int vertex: adjList.get(i)) {
                indegree[vertex]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < adjList.size(); i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        int countVertex = 0;

        while(!queue.isEmpty()) {
            int polled = queue.poll();
            countVertex++;
            for(int vertex: adjList.get(polled)) {
                indegree[vertex]--;
                if(indegree[vertex] == 0) {
                    queue.add(vertex);
                }
            }
        }
        return countVertex != adjList.size();
    }

    static boolean isCycleInDirectedGraph(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        boolean[] recurStack = new boolean[adjList.size()];

        for(int i = 0; i < adjList.size(); i++) {
            if(visited[i] == false) {
                if(isCycleInDirectedGraphUsingDFS(adjList, visited, recurStack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isCycleInDirectedGraphUsingDFS(List<List<Integer>> adjList, boolean[] visited, boolean[] recurStack,
                                           int source) {

        visited[source] = true;
        recurStack[source] = true;

        for(int vertex: adjList.get(source)) {
            if(visited[vertex] == false) {
                if(isCycleInDirectedGraphUsingDFS(adjList, visited, recurStack, vertex)) {
                    return true;
                }
            } else if(recurStack[vertex] == true) {
                return true;
            }
        }
        recurStack[source] = false;
        /*Why Setting to False Matters
        Suppose you start journey from one junction and
        If you don't pick up your breadcrumb (set to false) as you leave, the next time you visit that
        junction from another route, you'll falsely think it's still part of your path,
        and incorrectly detect a cycle.*/


        return false;
    }
}

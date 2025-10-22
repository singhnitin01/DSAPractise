package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*Given a connected, undirected, and weighted graph, a Minimum Spanning Tree is a subset of the edges that:
- Connects all vertices (spans the graph),
- Has no cycles (is a tree),
- Has the minimum possible total edge weight.

Below uses PRIM's algorithm to find the minimum spanning tree.
*/

public class MinimumSpanningTreeUsingPrimsAlgo {


    /*Input #of test cases: 1
    Input V: 5
    Input list with space separated vertex,weight: 1,2 2,1
    Input list with space separated vertex,weight: 0,2 2,1
    Input list with space separated vertex,weight: 0,1 1,1 3,2 4,2
    Input list with space separated vertex,weight: 2,2 4,1
    Input list with space separated vertex,weight: 2,2 3,1
    Total weight of minimum spanning tree is : 5*/


    static class Pair {
        int node;
        int distance;
        Pair(int node, int dist) {
            this.node = node;
            this.distance = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input #of test cases: ");
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- > 0) {
            System.out.print("Input V: ");
            int V = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> adjList = new ArrayList<>(V);
            for(int i = 0; i < V; i++) {
                System.out.print("Input list with space separated vertex,weight: ");
                String[] VertexWeightList = br.readLine().trim().split(" ");
                List<int[]> listOfVertexWeights = new ArrayList<>();
                for(String vertexWeight : VertexWeightList) {
                    listOfVertexWeights.add(new int[]{Integer.parseInt(vertexWeight.split(",")[0]), Integer.parseInt(vertexWeight.split(",")[1])});
                }
                adjList.add(listOfVertexWeights);
            }
            System.out.println("Total weight of minimum spanning tree is : " + minimumSpanningTree(adjList));
            System.out.println("\n--------------- Done! ---------------");
        }
    }
    static int minimumSpanningTree(List<List<int[]>> adj) {
        boolean[] visited = new boolean[adj.size()];
        PriorityQueue<Pair> pqueue = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
        // a should come before b if a.distance < b.distance
        pqueue.add(new Pair(0, 0)); //enqueue node 0 with distance 0 since it's first node;
        // Pair contains destination node and weight to reach it.
        int sumOfWeight = 0;

        while (!pqueue.isEmpty()) {
            Pair pair = pqueue.poll();
            int node = pair.node;
            int dist = pair.distance;

            if (visited[node])
                continue;

            visited[node] = true; // this is when node is added to MST, if we wanted MST we would have added node and its parent
            sumOfWeight += dist;

            for (int[] adjVertex : adj.get(node)) {
                int vertex = adjVertex[0];
                int weight = adjVertex[1];

                if (visited[vertex] != true) { //we don't add vertex to queue if it's already visited since later it won't be considered for sum of weight
                    pqueue.add(new Pair(vertex, weight));
                }
            }
        }
        return sumOfWeight;
    }

}
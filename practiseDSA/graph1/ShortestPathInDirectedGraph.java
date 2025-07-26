package graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInDirectedGraph {

    /*
    Input #of test cases: 1
    Input V: 6
    Input number of edges E: 7
    Enter Edges with weight:
            0 - 0 1 2
            1 - 0 4 1
            2 - 1 2 3
            3 - 4 5 4
            4 - 4 2 2
            5 - 2 3 6
            6 - 5 3 1
    Shortest Distance in Directed Graph: [0, 2, 3, 6, 1, 5]

            --------------- Done! ---------------*/

    class AdjacencyNode {
        int vertex;
        int weight;


        AdjacencyNode(int _v, int _w) { vertex = _v;  weight = _w; }

//        int getVertex() { return vertex; }
//        int getWeight()  { return weight; }
    }

    public void addEdgesToDirectedGraph(List<List<AdjacencyNode>> adjList, int u, int v, int weight) {
        AdjacencyNode node = new AdjacencyNode(v,weight);
        adjList.get(u).add(node);
    }

    public static void main(String[] args) throws IOException {
        ShortestPathInDirectedGraph obj = new ShortestPathInDirectedGraph();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input #of test cases: ");
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- > 0) {
            System.out.print("Input V: ");
            int V = Integer.parseInt(br.readLine().trim());
            List<List<AdjacencyNode>> adjList = new ArrayList<>(V);
            for(int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }

            System.out.print("Input number of edges E: ");
            int E = Integer.parseInt(br.readLine().trim());

            System.out.println("Enter Edges with weight:"); // first u , then v and then weight
            for(int i = 0; i < E; i++) {
                System.out.print(i + " - ");
                String[] edgeAndWeight = br.readLine().trim().split(" ");
                obj.addEdgesToDirectedGraph(adjList, Integer.parseInt(edgeAndWeight[0]), Integer.parseInt(edgeAndWeight[1]), Integer.parseInt(edgeAndWeight[2]));
            }
            System.out.println("Shortest Distance in Directed Graph: " + getShortestPathInDirectedGraph(adjList, 0));
            System.out.println("\n--------------- Done! ---------------");
        }
    }

    public static List<Integer> getShortestPathInDirectedGraph(List<List<AdjacencyNode>> adjList, int source) {

        ArrayList<Integer> dist = new ArrayList<>(adjList.size());
        for(int i = 0; i < adjList.size(); i++) {
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(source, 0);
        ArrayList<Integer> topoSort = getTopologicalSort(adjList);

        for(int i = 0; i < topoSort.size(); i++) {
            int u = topoSort.get(i);
            //if the distance to u from source is max which means no path to u from source, then we skip.
            if(dist.get(u) != Integer.MAX_VALUE) {
                for(AdjacencyNode node : adjList.get(u)) {
                    int v = node.vertex;
                    int w = node.weight;
                    if(dist.get(u) + w < dist.get(v)) {
                        dist.set(v, dist.get(u) + w);
                    }
                }
            }
        }
        return dist;
    }

    public static ArrayList<Integer> getTopologicalSort(List<List<AdjacencyNode>> adjList) {
        ArrayList<Integer> toposort = new ArrayList<>(adjList.size());
        int[] indegree = new int[adjList.size()];

        for(int i = 0; i < adjList.size(); i++) {
            for(AdjacencyNode adjNode: adjList.get(i))
                indegree[adjNode.vertex]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < adjList.size(); i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int polled = queue.poll();
            toposort.add(polled);
            for(AdjacencyNode adjNode: adjList.get(polled)) {
                indegree[adjNode.vertex]--;
                if(indegree[adjNode.vertex] == 0) {
                    queue.add(adjNode.vertex);
                }
            }
        }
        return toposort;
    }
}

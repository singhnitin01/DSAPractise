package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlyodWarshallsMutliSourceShortesPath {

    //GFG Link: https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

    /*
    * Flyod Warshall Algorithm helps us find multisource shortest path, it uses dynamic approach since we re-use already
    * computed value.
    * It also helps detect negative cycle in case adjMatrix[i][i] < 0 since it will always be zero
    * */

    /*  Input #of test cases: 1
        Input V: 5
        Enter all the adjacent node weights for node 0: 0 4 1e8 5 1e8
        Enter all the adjacent node weights for node 1: 1e8 0 1 1e8 6
        Enter all the adjacent node weights for node 2: 2 1e8 0 3 1e8
        Enter all the adjacent node weights for node 3: 1e8 1e8 1 0 2
        Enter all the adjacent node weights for node 4: 1 1e8 1e8 4 0
        All the shortest distance for all the nodes (Multi Source Shortest Path):
        0 4 5 5 7
        3 0 1 4 6
        2 6 0 3 5
        3 7 1 0 2
        1 5 5 4 0
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input #of test cases: ");
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- > 0) {
            System.out.print("Input V: ");
            int V = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> adjList = new ArrayList<>(V);
            for(int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }

            int[][] adjMatrix = new int[V][V];

            for(int i = 0; i < V; i++) {
                System.out.print("Enter all the adjacent node weights for node " + i + ": ");
                String[] adjacentNodeWeights = br.readLine().trim().split(" ");

                for (int j = 0; j < V; j++) {
                    if(Objects.equals(adjacentNodeWeights[j], "1e8")) {
                        adjMatrix[i][j] = (int)1e8;
                    } else {
                        adjMatrix[i][j] = Integer.parseInt(adjacentNodeWeights[j]);
                    }
                }
            }
            System.out.println("All the shortest distance for all the nodes (Multi Source Shortest Path):" );

            flyodWarshallMultiSourceShortestPath(adjMatrix);

            for(int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("\n--------------- Done! ---------------");
        }
    }

    static void flyodWarshallMultiSourceShortestPath(int[][] adjMatrix) {
        int V = adjMatrix.length;
        for (int via = 0; via < V; via++) {
            for(int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(adjMatrix[i][via] != (int)1e8 && adjMatrix[via][j] != (int)1e8) {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][via] + adjMatrix[via][j]);
                    }
                }
            }
        }
    }
}

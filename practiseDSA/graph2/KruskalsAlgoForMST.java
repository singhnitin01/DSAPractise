package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgoForMST {

    //GFG: https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1

   /*
   *Given a connected, undirected, and weighted graph, we use Kruskal's Algorithm to get the Minimum spanning tree
   * It follows greedy approach.
   *
   *    Input #of test cases: 1
        Input V: 3
        Input number of edges E: 3
        Enter Edges with weight:
        0 - 0 1 5
        1 - 1 2 3
        2 - 0 2 1
        Weight of Minimum Spanning Tree is: 4
   *
   * */


    static class EdgeWeight implements Comparable<EdgeWeight> {
        int src, dest, wt;

        EdgeWeight(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }

        @Override
        public int compareTo(EdgeWeight o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input #of test cases: ");
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- > 0) {
            System.out.print("Input V: ");
            int V = Integer.parseInt(br.readLine().trim());

            System.out.print("Input number of edges E: ");
            int E = Integer.parseInt(br.readLine().trim());

            System.out.println("Enter Edges with weight:"); // first u , then v and then weight
            ArrayList<EdgeWeight> edgesList = new ArrayList<>();
            for(int i = 0; i < E; i++) {
                System.out.print(i + " - ");
                String[] edgeAndWeight = br.readLine().trim().split(" ");
                edgesList.add(new EdgeWeight(Integer.parseInt(edgeAndWeight[0]), Integer.parseInt(edgeAndWeight[1]), Integer.parseInt(edgeAndWeight[2])));
            }

            int weightOfMST = new KruskalsAlgoForMST().kruskalsAlgoForMST(V, edgesList) ;
            System.out.println("Weight of Minimum Spanning Tree is: " + weightOfMST );
            System.out.println("\n--------------- Done! ---------------");
        }
    }

    public int kruskalsAlgoForMST(int V, ArrayList<EdgeWeight> edgesList) {
        Collections.sort(edgesList);

        DisjointSetsUnionByRank ds = new DisjointSetsUnionByRank(V);
        int weightOfMST = 0;

        for(EdgeWeight ew: edgesList) {
            int src = ew.src;
            int dest = ew.dest;
            int wt = ew.wt;

            if(!ds.isConnected(src, dest)) {
                ds.unionByRank(src, dest);
                weightOfMST += wt;
            }
        }
        return  weightOfMST;
    }
}

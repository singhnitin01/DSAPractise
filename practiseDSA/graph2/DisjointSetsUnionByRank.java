package graph2;

public class DisjointSetsUnionByRank {

    //GFG: 1. Union By Rank: https://www.geeksforgeeks.org/problems/union-find/1
    //GFG: 2. Union By Size: https://www.geeksforgeeks.org/problems/union-find/1

    /*This implements disjoin set with union by rank
    * Here two functions are important
    * 1. find(a) - this finds the ultimate parent and also does path compression by assigning the values of parents
    *           and hence bringing the search of parent in constant time
    * 2. unionByRank(a,b) - this unites the a group with b group based on rank (find more details in functions)
    * */

    int[] rank, parent;
    int n;

    // Constructor
    public DisjointSetsUnionByRank(int n)
    {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            // Initially, all elements are in
            // their own set.
            parent[i] = i;
        }
    }

    public int find(int i) {
        if(parent[i] != i) {
            parent[i] = find(parent[i]); //full path compression
        }
        return parent[i];
    }

    public void unionByRank(int a, int b) {
        int rootA = find(a); // finds the ultimate parent of a
        int rootB = find(b); // finds the ultimate parent of b

        // if rank is lesser for rootA then we assign par[rootA] as rootB
        if(rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootB] < rank[rootA]) {
            parent[rootB] = rootA;
        } else {
            // when the ranks are equal we can assign any one to other's parent
            // And increase the rank by 1 for parent node
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }

    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }


    public static void main(String[] args) {
        int n = 6;
        DisjointSetsUnionByRank dus =
                new DisjointSetsUnionByRank(n);
        dus.unionByRank(1,3);
        System.out.println(dus.isConnected(1,2));
        dus.unionByRank(1,5);
        System.out.println(dus.isConnected(3,5));
    }

}

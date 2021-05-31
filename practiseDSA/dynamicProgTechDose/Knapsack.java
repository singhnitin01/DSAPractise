package dynamicProgTechDose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Knapsack {
    public static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            String[] inp = br.readLine().trim().split(" ");
            int []weights = new int[inp.length];
            for(int i=0; i< inp.length; i++)
                weights[i] = Integer.parseInt(inp[i]);

            inp = br.readLine().trim().split(" ");
            int[] profits = new int[inp.length];
            for(int i=0; i< inp.length; i++)
                profits[i] = Integer.parseInt(inp[i]);

            int totWeight = Integer.parseInt(br.readLine().trim());
            int n = weights.length;

            dp = new int[totWeight+1][n+1];
            for(int i=0; i<totWeight+1; i++)
                for(int j=0; j<n+1; j++)
                    dp[i][j] =-1;

            System.out.println(knapSack(totWeight, weights, profits,  n));

            //System.out.println(knapSack01_1(totWeight, weights, profits, weights.length-1));
        }
    }

    // knapsack with memoization : recursion + storage
    public static int knapSack(int W, int []weights, int []profits, int n){
        if(W == 0 || n == 0) // when bag is empty or there are no items left to put in bag
            return 0;

        if(dp[W][n] != -1)
            return dp[W][n];

        if(weights[n-1] > W)         // when item weight is more than bag weight, hence we donot choose this item and go for next
            return dp[W][n]= knapSack(W, weights, profits, n-1);

        else
            return dp[W][n] = Math.max(knapSack(W, weights, profits, n-1),      // do not include this item
                    profits[n-1]+ knapSack(W-weights[n-1], weights, profits, n-1));   // when we include this item
    }


    // 1st way
    /*public static int knapSack01(int totWeight, int profit,  int index, int []weights, int []profits){
        int maxProfit = profit;
        for(int i= index; i<weights.length; i++){
            int w = weights[i];
            int p =0;
            if(totWeight - w >= 0){
                 p = knapSack01(totWeight-w, profit+ profits[i],i+1, weights, profits);

            }
            *//*else {
                p=  knapSack01(totWeight, profit,i+1, weights, profits);
            }*//*
            if(maxProfit < p)
                maxProfit = p;
        }
        return maxProfit;
    }*/
}

/*
1st line weights
2nd line profits
3rd line totalWeight allowed

3 2 4
6 8 7
8
ans - 15
3 4 1
5 6 2
6
ans - 8
4 5 1
1 2 3
4
ans - 3
4 5 6
1 2 3
3
ans - 0

83 84 85 76 13 87 2 23 33 82 79 100 88 85 91 78 83 44 4 50 11 68 90 88 73 83 46 16 7 35 76 31 40 49 65 2 18 47 55 38 75 58 86 77 96 94 82 92 10 86 54 49 65 44 77 22 81 52
57 95 13 29 1 99 34 77 61 23 24 70 73 88 33 61 43 5 41 63 8 67 20 72 98 59 46 58 64 94 97 70 46 81 42 7 1 52 20 54 81 3 73 78 81 11 41 45 18 94 24 82 9 19 59 48 2 72
41
ans - 223

*/

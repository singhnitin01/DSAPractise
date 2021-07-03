package DynamicProgramming2;

import java.util.Arrays;

// This is called 01Knapsack since each item can be taken or not only once
public class Knapsack01 {

    static int memo[][];

    public static void main(String[] args) {
        int val[] = new int[]{10, 40, 30, 50};//new int[]{60, 100, 120}; //
        int weight[] = new int[]{5, 4, 6, 3};//new int[]{10, 20, 30};
        int W = 10;//50;

        memo = new int[W+1][weight.length+1];
        for(int []arr: memo)
            Arrays.fill(arr, -1);
        System.out.println(maximizeProfit(weight, val, W, weight.length));
        System.out.println(maximizeProfitTab(weight, val, W, weight.length));
    }

    public static int maximizeProfit(int weight[], int value[], int W, int n){

        if(memo[W][n] != -1)
            return memo[W][n];

        if(n == 0 || W <= 0) // == will work since we're already checking weight[n-1] <= W which handles the negative case
            return 0;

        int profit1 =0;
        if(weight[n-1] <= W)
            profit1 = value[n-1] + maximizeProfit(weight, value, W- weight[n-1], n-1);

        int profit2 = maximizeProfit(weight, value, W, n-1);

        memo[W][n] = Math.max(profit1, profit2);
        return memo[W][n];
    }

    public static int maximizeProfitTab(int weight[], int value[], int W, int n){
        int dp[][] = new int[W+1][n+1];

        for(int i=0; i<= W; i++){ // this is current weight
            for(int j=0; j<=n; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(weight[j-1] > i)
                    dp[i][j] = dp[i][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], value[j-1] + dp[ i - weight[j-1]][j-1]);
            }
        }
        return dp[W][n];
    }
}
// Time Complexity is O(W*n) which is psuedo-polynomial which means it can perform bad than recursive solution of O(2^n) when W is too large
// Hence Knapsack problem is considered as NP hard problem in Computer Science
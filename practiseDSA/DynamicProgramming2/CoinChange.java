package DynamicProgramming2;

import java.util.Arrays;


// Here we need to find out total possible ways to get the sum
public class CoinChange {

    static int memo[][];

    public static void main(String[] args) {
        memo = new int[11][5];
        for(int[] arr: memo)
            Arrays.fill(arr, -1);
        System.out.println(getCount(10, new int[]{2,5,3,6}, 4));
        System.out.println(getCountTab(8, new int[]{2, 5, 3}, 3));
    }

    public static int getCount(int sum, int[] arr, int n){
        if(memo[sum][n] != -1)
            return memo[sum][n];

        if(sum == 0)
            return 1;

        if(n==0)
            return 0;

        int tot = getCount(sum, arr, n-1);
        if(arr[n-1] <= sum)
            tot += getCount(sum-arr[n-1],arr, n);
        memo[sum][n] = tot;
        return tot;
    }

    public static int getCountTab(int sum, int[] coin, int n){

        int dp[][] = new int[sum+1][n+1];

        for(int i=0; i<= sum; i++){
            for(int j =0; j<= n; j++){
                if(i==0)
                    dp[i][j] = 1;
                else if(j == 0)
                    dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i][j-1];
                    if(coin[j-1] <= i){
                        dp[i][j] += dp[i- coin[j-1]][j];
                    }
                }
            }
        }
        return dp[sum][n];
    }
}

package DynamicProgramming2;

import java.util.Arrays;

public class EditDistance {

    static int [][]memo;
    public static void main(String[] args) {
        String s1 = "saturday";
        String s2 = "sunday";

        memo = new int [s1.length()+1][s2.length()+1];
        for(int[] arr: memo)
            Arrays.fill(arr, -1);
        System.out.println(countDistance(s1, s2, s1.length(),s2.length()));
        System.out.println(countDistanceTab(s1,s2));

    }

    public static int countDistance(String s1, String s2, int m, int n){

        if(memo[m][n] != -1)
            return memo[m][n];
        if(m==0)
            return n;
        if(n==0)
            return m;

        if(s1.charAt(m-1) == s2.charAt(n-1))
            memo[m][n] =  countDistance(s1, s2, m-1, n-1);
        else {
            memo[m][n] = 1+ Math.min(Math.min(countDistance(s1, s2, m, n-1), //inserting in s1
                    countDistance(s1, s2, m-1, n)), // deleting from s1
                    countDistance(s1, s2, m-1, n-1));

        }
        return memo[m][n];
    }

    public static int countDistanceTab(String s1, String s2){
        int m = s1.length(), n= s2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0)
                    dp[i][j] = j;
                else if(j==0)
                    dp[i][j] = i;
                else{
                    if(s1.charAt(i-1) == s2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1];
                    else
                        dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}

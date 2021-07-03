package DynamicProgramming2;


// below is similar to rope cutting already added in recursion

// DP solution time complexity is O(n) which is too good compared to O(3^n) from recursive solution
public class MaxRodCutting {

    public static void main(String[] args) {
        System.out.println(maximizeCutsUtil(23, 12, 11, 13));
                //(3, 2, 4, 2));
                //(23, 12, 11, 13));
                //
    }

    // recursive solution
    public static int maximizeCutsUtil(int n, int x, int y, int z){
        if(n==0)
            return 0;
        if(n < 0)
            return -1;

        int res = Math.max(Math.max(maximizeCutsUtil(n-x, x, y, z), maximizeCutsUtil(n-y, x, y, z)),
                maximizeCutsUtil(n-z, x, y, z));

        if(res == -1)
            return res;
        else
            return res+1;
    }

    // DP solution
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int []dp = new int[n+1];
        dp[0] = 0;

        for(int i=1; i<=n; i++){
            dp[i] = -1;

            if(x <= i)
                dp[i] = Math.max(dp[i], dp[i-x]);
            if(y <= i)
                dp[i] = Math.max(dp[i], dp[i-y]);
            if(z <= i)
                dp[i] = Math.max(dp[i], dp[i-z]);

            if(dp[i] != -1)
                dp[i]++;
        }

        return dp[n] == -1 ? 0 : dp[n];
    }

}

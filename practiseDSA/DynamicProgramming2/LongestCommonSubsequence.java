package DynamicProgramming2;

import java.util.Arrays;

public class LongestCommonSubsequence {

    static int memo[][];
    static String memo1[][];

    public static void main(String[] args) {
        lcsMemo(6,6,"ABCDGH", "AEDFHR");
        lcsMemo(4,3,"AXYZ", "BAZ");
        lcsMemo(4,3,"abac", "cab");
        System.out.println(lcsTab(6,6,"ABCDGH", "AEDFHR"));
        System.out.println(lcsTab(4,3,"AXYZ", "BAZ"));
        System.out.println(generateLcsTab(6,6,"ABCDGH", "AEDFHR"));
    }

    static int lcsTab(int x, int y, String s1, String s2){
        int dp[][] = new int[x+1][y+1];

        for(int i=0; i<=x; i++){
            for(int j= 0; j<=y; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[x][y];
    }

    static String generateLcsTab(int x, int y, String s1, String s2){
        String dp[][] = new String[x+1][y+1];

        for(int i=0; i<=x; i++){
            for(int j= 0; j<=y; j++){
                if(i==0 || j==0)
                    dp[i][j] = "";
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                else{
                    String first = dp[i-1][j];
                    String second = dp[i][j-1];
                    dp[i][j] = first.length() >= second.length() ? first : second;
                }
            }
        }
        return dp[x][y];
    }


    static void lcsMemo(int x, int y, String s1, String s2)
    {
        memo = new int[x+1][y+1];
        memo1 = new String[x+1][y+1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println( lcsUtil(x, y, s1, s2));
        System.out.println(generateLCS(x, y, s1, s2));


    }

    static int lcsUtil(int x, int y, String s1, String s2){

        if(memo[x][y] != -1)
            return memo[x][y];

        if(x ==0 || y==0)
            return 0;

        if(s1.charAt(x-1) == s2.charAt(y-1)){
            memo[x][y] = 1+ lcsUtil(x-1, y-1, s1, s2);
        }
        else
            memo[x][y] = Math.max(lcsUtil(x-1, y, s1, s2), lcsUtil(x, y-1, s1, s2));

        return memo[x][y];
    }

    static String generateLCS(int x, int y, String s1, String s2){

        if(memo1[x][y] != null)
            return memo1[x][y];

        if(x==0 || y==0)
            return "";

        if(s1.charAt(x-1) == s2.charAt(y-1)){
            memo1[x][y] = generateLCS(x-1, y-1, s1, s2) + s1.charAt(x-1);
        }
        else{
            String first = generateLCS(x-1, y, s1, s2);
            String second = generateLCS(x, y-1, s1, s2);
            memo1[x][y] = first.length() >= second.length() ? first : second;
        }
        return memo1[x][y];
    }
}

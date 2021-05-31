package dyanmicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GridTravellerTab {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            String[] inp = (br.readLine().trim().split(" "));
            int m = Integer.parseInt(inp[0]);
            int n = Integer.parseInt(inp[1]);

            long[][] tab = new long[m+1][n+1];

            System.out.println(totalPaths(m,n,tab));
        }
    }

    public static long totalPaths(int m, int n, long [][]tab){
        tab[1][1] = 1;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){

                if(i+1 <= m)
                    tab[i+1][j] += tab[i][j];

                if(j+1 <= n)
                    tab[i][j+1] += tab[i][j];
            }
        }
        return tab[m][n];
    }
}
/*
test cases
3 3 --- 6
2 3 --- 3
18 18 ---- 2333606220
*/

package recursion;

import java.util.*;

public class RobotInGrid {

    static Map<String, Integer> memo;

    public static void main(String[] args) {
        //obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        memo = new HashMap<>();
        return totalPaths(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
    }

    public static int totalPaths(int [][]grid, int r, int c){
        String key = r +","+ c;

        int m = grid.length;
        int n = grid[0].length;

        if(memo.containsKey(key))
            return memo.get(key);

        if(r == 1 && c == 1 && grid[m-1][n-1] == 0)
            return 1;
        if(r <= 0 || c <= 0)
            return 0;

        int right=0 , left=0;
        //System.out.println(r+" -- "+c);
        if( grid[m - r ][n - c] != 1)
            right = totalPaths(grid, r-1, c);

        if(grid[m - r][n - c] != 1)
            left = totalPaths(grid, r, c-1);

        memo.put(key, right+left);

        return right+left;

    }
}

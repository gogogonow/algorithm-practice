package week6;

import java.util.Arrays;

/**
 * @author 61404
 */
public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {
        int[] cost = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            cost[i] = i == 0 ? grid[0][0] : cost[i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    cost[j] = cost[j] + grid[i][j];
                    continue;
                }
                cost[j] = Math.min(cost[j], cost[j - 1]) + grid[i][j];
            }
        }
        return cost[grid[0].length - 1];
    }
}

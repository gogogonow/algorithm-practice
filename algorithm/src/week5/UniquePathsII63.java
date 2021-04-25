package week5;

/**
 * @author 61404
 */
public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] steps = new int[m][n];
        steps[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                steps[0][i] = 0;
            }
            else {
                steps[0][i] = steps[0][i-1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                steps[i][0] = 0;
            }
            else {
                steps[i][0] = steps[i-1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    steps[i][j] = 0;
                }
                else {
                    steps[i][j] = steps[i-1][j] + steps[i][j-1];
                }
            }
        }
        return steps[m-1][n-1];
    }


    // 滚动数组
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[] pre = new int[n];
        int[] cur = new int[n];
        pre[0] = 1;
        cur[0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                pre[i] = 0;
                cur[i] = 0;
            }
            else {
                pre[i] = pre[i-1];
                cur[i] = cur[i-1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[j] = cur[j];
                if (obstacleGrid[i][j] == 1) {
                    cur[j] = 0;
                }
                else {
                    if (j == 0) {
                        cur[j] = pre[j];
                    }
                    else {
                        cur[j] = pre[j] + cur[j-1];
                    }
                }
            }
        }
        return cur[n-1];
    }

    // 单数组
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[] cur = new int[n];
        cur[0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                cur[i] = 0;
            }
            else {
                cur[i] = cur[i-1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    cur[j] = 0;
                }
                else {
                    if (j != 0) {
                        cur[j] = cur[j] + cur[j-1];
                    }
                }
            }
        }
        return cur[n-1];
    }
}

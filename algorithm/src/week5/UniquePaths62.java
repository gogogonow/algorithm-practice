package week5;

import java.util.Arrays;

/**
 * @author 61404
 */
public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] steps = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    steps[i][j] = 1;
                }
                else {
                    steps[i][j] = steps[i-1][j] + steps[i][j-1];
                }
            }
        }
        return steps[m-1][n-1];
    }


    // 滚动数组
    public int uniquePaths1(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[j] = cur[j];
                if (j == 0) {
                    cur[j] = 1;
                }
                else {
                    cur[j] = pre[j] + cur[j-1];
                }
            }
        }
        return cur[n-1];
    }


    // 单数组
    public int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j-1] + cur[j];
            }
        }
        return cur[n-1];
    }
}

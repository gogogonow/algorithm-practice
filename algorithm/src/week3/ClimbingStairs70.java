package week3;

/**
 * 题目：
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @author 61404
 */
public class ClimbingStairs70 {

    /**
     * 递归
     * @param n 阶数
     * @return ways
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 动态规划
     * @param n 阶数
     * @return ways
     */
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }

    /**
     * 动态规划 + 空间优化
     * @param n 阶数
     * @return ways
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int prev2 = 1;
        int prev1 = 2;
        for (int i = 3; i < n; i++) {
            int tmp = prev1 + prev2;
            prev2 = prev1;
            prev1 = tmp;
        }
        return prev1 + prev2;
    }

    /**
     * 矩阵快速幂
     * @param n 阶数
     * @return ways
     */
    public int climbStairs3(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[1][0];
    }

    private int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    /**
     * 变种：
     * 修改条件：
     * 1、每次你可以爬 1 或 2 个台阶。 2、不能连续跳两个台阶。
     */
}

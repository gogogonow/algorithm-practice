package week6;

/**
 * @author 61404
 */
public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        int maxEdge = 0;
        int[][] map = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == 0 || j == 0) {
                    map[i][j] = matrix[i][j] - '0';
                    maxEdge = Math.max(map[i][j], maxEdge);
                    continue;
                }
                if (matrix[i][j] == '0') {
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = Math.min(Math.min(map[i - 1][j - 1], map[i - 1][j]), map[i][j - 1]) + 1;
                    maxEdge = Math.max(map[i][j], maxEdge);
                }
            }
        }
        return maxEdge * maxEdge;
    }
}

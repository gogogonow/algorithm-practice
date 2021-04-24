package week4;

/**
 * @author 61404
 */
public class NumberofIslands200 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int xLen = 0;
    int yLen = 0;
    public int numIslands(char[][] grid) {
        int ret = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return ret;
        }
        xLen = grid.length;
        yLen = grid[0].length;
        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                char c = grid[x][y];
                if (c == '1') {
                    ret++;
                    dfsSet(grid, x, y);
                }
            }
        }
        return ret;
    }

    private void dfsSet(char[][] grid, int x, int y) {
        if (x >= xLen || x < 0 || y >= yLen || y < 0) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            for (int pos = 0; pos < 4; pos++) {
                dfsSet(grid, x + dx[pos], y + dy[pos]);
            }
        }
    }
}

package week4;

/**
 * @author 61404
 */
public class Minesweeper529 {
    int xLen = 0;
    int yLen = 0;
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return board;
        }
        int sX = click[0];
        int sY = click[1];
        xLen = board.length;
        yLen = board[0].length;
        dfsSet(board, sX, sY);
        return board;
    }

    private void dfsSet(char[][] board, int x, int y) {
        if (x >= xLen || x < 0 || y >= yLen || y < 0) {
            return;
        }
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        if (board[x][y] == 'E') {
            int cnt = 0;
            for (int i = 0; i < 8; i++) {
                if (x + dx[i] < xLen && x + dx[i] >= 0 && y + dy[i] >=0 && y + dy[i] < yLen) {
                    char cur = board[x + dx[i]][y + dy[i]];
                    if (cur == 'M' || cur == 'X') {
                        cnt++;
                    }
                }
            }
            if (cnt == 0) {
                board[x][y] = 'B';
                for (int i = 0; i < 8; i++) {
                    dfsSet(board, x + dx[i], y + dy[i]);
                }
            }
            else {
                board[x][y] = (char) (cnt + 48);
                return;
            }
        }
    }
}

package week7;

import java.util.Arrays;

/**
 * @author 61404
 */
public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        Arrays.fill(row, 0);
        Arrays.fill(col, 0);
        Arrays.fill(box, 0);
        int[] nums = {1, 1<<1, 1<<2, 1<<3, 1<<4, 1<<5, 1<<6, 1<<7, 1<<8};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    int num = board[i][j] - '0';
                    if ((row[i] & nums[num - 1]) + (col[j] & nums[num - 1]) + (box[boxIndex] & nums[num - 1]) == 0) {
                        row[i] |= nums[num - 1];
                        col[j] |= nums[num - 1];
                        box[boxIndex] |= nums[num - 1];
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

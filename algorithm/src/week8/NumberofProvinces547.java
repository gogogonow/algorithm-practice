package week8;

/**
 * @author 61404
 */
public class NumberofProvinces547 {
    public int findCircleNum(int[][] isConnected) {
        int provinceLen = isConnected.length;
        int[] parent = new int[provinceLen];
        for (int i = 0; i < provinceLen; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinceLen; i++) {
            for (int j = i + 1; j < provinceLen; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinceLen; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = parent[find(parent, parent[index])];
        }
        return parent[index];
    }
}

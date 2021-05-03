package week6;

import java.util.List;

/**
 * @author 61404
 */
public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int index = triangle.size() - 1;
        while (index >= 0) {
            if (index == triangle.size() - 1) {
                index--;
                continue;
            }
            for (int i = 0; i <= index; i++) {
                int cur = triangle.get(index).get(i);
                cur += Math.min(triangle.get(index + 1).get(i), triangle.get(index + 1).get(i + 1));
                triangle.get(index).set(i, cur);
            }
            index--;
        }
        return triangle.get(0).get(0);
    }
}

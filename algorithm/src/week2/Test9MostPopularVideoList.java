package week2;

import java.util.*;

/**
 * @author 61404
 */
public class Test9MostPopularVideoList {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = 0;
            if (map.containsKey(num)) {
                count = map.get(num);
            }
            count++;
            map.put(num, count);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(map.size(), (o1, o2) -> o2.getValue() - o1.getValue());
        map.forEach((key, val) -> queue.add(new AbstractMap.SimpleEntry<>(key, val)));
        k = Math.min(k, map.size());
        int[] ret = new int[k];
        int index = 0;
        while (!queue.isEmpty() && index < k) {
            ret[index++] = queue.poll().getKey();
        }
        return ret;
    }
}

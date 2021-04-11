package week2;

import java.util.*;

/**
 * @author 61404
 */
public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>(k, Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int num : nums) {
            Integer integer = map.getOrDefault(num, 0);
            map.put(num, integer + 1);
        }
        priorityQueue.addAll(map.entrySet());
        for (int i = 0; i < k; i++) {
            ret[i] = Objects.requireNonNull(priorityQueue.poll()).getKey();
        }
        return ret;
    }
}

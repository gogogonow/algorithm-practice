package week7;

import java.util.*;

/**
 * @author 61404
 */
public class MinimumGeneticMutation433 {
    public int minMutation(String start, String end, String[] bank) {
        ArrayList<String> banList = new ArrayList<>(Arrays.asList(bank));
        Set<String> wordSet = new HashSet<>(banList);
        if (!wordSet.contains(start) && !wordSet.contains(end)) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int ret = 0;
        banList.remove(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ret++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                Iterator<String> iterator = banList.iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    if (isAdjacent(next, poll)) {
                        if (next.equals(end)) {
                            return ret;
                        }
                        queue.offer(next);
                        iterator.remove();
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isAdjacent(String next, String poll) {
        if (next.length() != poll.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < next.length(); i++) {
            if (next.charAt(i) != poll.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}

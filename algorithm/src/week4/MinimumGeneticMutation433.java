package week4;

import java.util.*;

/**
 * @author 61404
 */
public class MinimumGeneticMutation433 {
    public int minMutation(String start, String end, String[] bank) {
        if (Objects.equals(start, end)) {
            return 0;
        }
        Set<String> bankSet = new HashSet<>(new ArrayList<>(Arrays.asList(bank)));
        if (!bankSet.contains(end)) {
            return -1;
        }
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String poll = queue.poll();
                if (Objects.equals(poll, end)) {
                    return step;
                }
                char[] oriChars = poll.toCharArray();
                for (int i = 0; i < oriChars.length; i++) {
                    char old = oriChars[i];
                    for (char c : charSet) {
                        oriChars[i] = c;
                        String next = new String(oriChars);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                    oriChars[i] = old;
                }
            }
            step++;
        }
        return -1;
    }
}

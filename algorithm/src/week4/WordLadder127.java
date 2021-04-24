package week4;

import java.util.*;

/**
 * @author 61404
 */
public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> notVisited = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String poll = queue.poll();
                if (Objects.equals(poll, endWord)) {
                    return step;
                }
                Iterator<String> iterator = notVisited.iterator();
                while (iterator.hasNext()) {
                    String str = iterator.next();
                    if (canPutIntoQueue(str, poll)) {
                        queue.offer(str);
                        iterator.remove();
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private boolean canPutIntoQueue(String str, String poll) {
        char[] chars = poll.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != str.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}

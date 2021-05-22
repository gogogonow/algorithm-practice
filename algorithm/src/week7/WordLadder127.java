package week7;

import java.util.*;

/**
 * @author 61404
 */
public class WordLadder127 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(beginWord) && !wordSet.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int ret = 1;
        wordList.remove(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ret++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    if (isAdjacent(next, poll)) {
                        if (next.equals(endWord)) {
                            return ret;
                        }
                        queue.offer(next);
                        iterator.remove();
                    }
                }
            }
        }
        return 0;
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

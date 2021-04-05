package week1.preview;

import java.util.Arrays;

/**
 * @author 61404
 */
public class ValidAnagram242 {
    public static boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        String sortedS = Arrays.toString(sChars);
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        String sortedT = Arrays.toString(tChars);
        return sortedS.equals(sortedT);
    }

    public static boolean isAnagram1(String s, String t) {
        int[] counts = new int[26];
        char[] sChars = s.toCharArray();
        for (char sChar : sChars) {
            counts[sChar - 'a']++;
        }
        char[] tChars = t.toCharArray();
        for (char tChar : tChars) {
            counts[tChar - 'a']--;
        }
        for (int i : counts) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}

package week4;

import java.util.Arrays;

/**
 * @author 61404
 */
public class AssignCookies455 {
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(s);
        Arrays.sort(g);
        int ret = 0;
        int index = 0;
        for (int si : s) {
            if (index >= g.length) {
                break;
            }
            if (si >= g[index]) {
                ret++;
                index++;
            }
        }
        return ret;
    }
}

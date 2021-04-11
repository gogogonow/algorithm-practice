package week2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 61404
 */
public class UglyNumLCOF49 {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i=1; i<n; i++) {
            int n2 = uglyNums[a] * 2;
            int n3 = uglyNums[b] * 3;
            int n5 = uglyNums[c] * 5;
            uglyNums[i] = Math.min(n2, Math.min(n3, n5));
            if (uglyNums[i] == n2) {
                a++;
            }
            if (uglyNums[i] == n3) {
                b++;
            }
            if (uglyNums[i] == n5) {
                c++;
            }
        }
        return uglyNums[n - 1];
    }
}

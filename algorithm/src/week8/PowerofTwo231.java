package week8;

/**
 * @author 61404
 */
public class PowerofTwo231 {
    public boolean isPowerOfTwo(int n) {
        int cnt = 0;
        if (n < 0) {
            return false;
        }
        while (n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt == 1;
    }
}

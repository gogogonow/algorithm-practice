package week4;

/**
 * @author 61404
 */
public class SqrtX69 {
    public int mySqrt(int x) {
        int ret = 0;
        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ret = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ret;
    }
}

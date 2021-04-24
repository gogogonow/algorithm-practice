package week4;

/**
 * @author 61404
 */
public class ValidPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid == num) {
                return true;
            }
            else if ((long) mid * mid < num) {
                l = mid + 1;
            }
            else if ((long) mid * mid > num) {
                r = mid - 1;
            }
        }
        return false;
    }
}

package week8;

/**
 * @author 61404
 */
public class ReverseBits190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            ret |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return ret;
    }
}

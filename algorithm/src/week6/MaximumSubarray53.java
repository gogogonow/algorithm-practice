package week6;

/**
 * @author 61404
 */
public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int ret = Integer.MIN_VALUE;
        int pre = 0;
        int cur;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(pre + nums[i], nums[i]);
            ret = Math.max(cur, ret);
            pre = cur;
        }
        return ret;
    }
}

package week6;

/**
 * @author 61404
 */
public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        int ret = Integer.MIN_VALUE;
        int minVal = 1;
        int maxVal = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = minVal;
                minVal = maxVal;
                maxVal = tmp;
            }
            minVal = Math.min(nums[i], minVal * nums[i]);
            maxVal = Math.max(nums[i], maxVal * nums[i]);
            ret = Math.max(ret, maxVal);
        }
        return ret;
    }
}

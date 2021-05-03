package week6;

import java.util.Arrays;

/**
 * @author 61404
 */
public class HouseRobberII213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(calRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                calRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int calRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}

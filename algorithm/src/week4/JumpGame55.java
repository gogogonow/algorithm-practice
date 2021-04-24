package week4;

/**
 * @author 61404
 */
public class JumpGame55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int rightMost = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > rightMost) {
                return false;
            }
            rightMost = Math.max(rightMost, i + nums[i]);
            if (rightMost >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

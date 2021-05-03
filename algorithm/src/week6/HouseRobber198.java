package week6;

/**
 * @author 61404
 */
public class HouseRobber198 {
    public int rob(int[] nums) {
        int len = nums.length;
        int preSteal = nums[0];
        int preNotSteal = 0;
        int curSteal = preSteal;
        int curNotSteal = preNotSteal;
        for (int i = 1; i < len; i++) {
            curNotSteal = Math.max(preSteal, preNotSteal);
            curSteal = preNotSteal + nums[i];
            preNotSteal = curNotSteal;
            preSteal = curSteal;
        }
        return Math.max(curNotSteal, curSteal);
    }
}

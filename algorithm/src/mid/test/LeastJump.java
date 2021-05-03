package mid.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 61404
 */
public class LeastJump {
    public int jump(int[] nums) {
        int target = nums.length - 1;
        int ret = 0;
        int maxIndex = -1;
        int pre = 0;
        for (int i = 0; i < target; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (i == pre) {
                pre = maxIndex;
                ret++;
            }
        }
        return ret;
    }
}

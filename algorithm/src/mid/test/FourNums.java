package mid.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 61404
 */
public class FourNums {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(11);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ret;
        }
        Arrays.sort(nums);
        // 选定第一个数
        for (int i = 0; i <= nums.length - 4; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            // 选定第二个数
            for (int j = i + 1; j <= nums.length - 3; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int b = nums[j];
                int k = j + 1, l = nums.length - 1;
                // 双指针遍历第三、四个数找到组合
                while (k < l) {
                    int c = nums[k];
                    int d = nums[l];
                    // 组合满足条件
                    if (a + b + c + d == target) {
                        ret.add(Arrays.asList(a, b, c, d));
                        // 去重
                        while(k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        while(k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }
                        k++;
                        l--;
                    }
                    // 组合偏小，增大第三个数
                    else if (a + b + c + d < target) {
                        k++;
                    }
                    // 组合偏大，减小第四个数
                    else {
                        l--;
                    }
                }
            }
        }
        return ret;
    }
}

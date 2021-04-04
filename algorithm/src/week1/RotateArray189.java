package week1;

/**
 * @author 61404
 */
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int index = len -1;
        k = k % len;
        for (int i = len - k - 1; i >= 0; i--) {
            int tmp = nums[i];
            for (int j = i; j < i + k; j++) {
                nums[j] = nums[j + 1];
            }
            nums[index--] = tmp;
        }
    }
}

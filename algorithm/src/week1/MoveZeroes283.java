package week1;

/**
 * @author 61404
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}

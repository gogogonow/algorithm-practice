package week1;

/**
 * @author 61404
 */
public class RemoveDuplicatesFromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int index = 1;
        int prev = nums[0];
        for(int i=1; i<len; i++) {
            if (nums[i] != prev) {
                nums[index++] = nums[i];
                prev = nums[i];
            }
        }
        return index;
    }
}

package week4;

import java.util.Arrays;

/**
 * @author 61404
 */
public class SearchinRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyNums);
        int targetIndex = findIndex(copyNums, 0, nums.length - 1, target);
        if (targetIndex == -1) {
            return -1;
        }
        if (nums[0] == copyNums[0]) {
            return targetIndex;
        }
        else {
            int revIndex = findIndex(copyNums, 0, nums.length - 1, nums[0]);
            if (targetIndex >= revIndex) {
                return targetIndex - revIndex;
            }
            else {
                return nums.length - revIndex + targetIndex;
            }
        }
    }

    private int findIndex(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }
}

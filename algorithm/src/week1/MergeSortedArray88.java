package week1;

/**
 * @author 61404
 */
public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i = m-1;
        int j = n-1;
        int index = m + n -1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i];
                i--;
            }
            else {
                nums1[index--] = nums2[j];
                j--;
            }
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}

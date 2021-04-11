package week2;

/**
 * @author 61404
 */
public class Test8VerifyPostOrder {
    public boolean verifyPostorder(int[] postorder) {
        return recVerify(postorder, 0, postorder.length - 1);
    }

    private boolean recVerify(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int l = i;
        while (postorder[l] < postorder[j]) {
            l++;
        }
        int m = l;
        while (postorder[l] > postorder[j]) {
            l++;
        }
        return l == j && recVerify(postorder, i, m - 1) && recVerify(postorder, m, j - 1);
    }
}

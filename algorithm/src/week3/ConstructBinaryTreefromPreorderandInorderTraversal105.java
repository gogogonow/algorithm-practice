package week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 61404
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal105 {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return recBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode recBuildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR) {
            return null;
        }
        int root = preorder[preL];
        int rootIndex = indexMap.get(root);
        int lefSize = rootIndex - inL;
        TreeNode ret = new TreeNode(root);
        ret.left = recBuildTree(preorder, preL + 1, preL + lefSize, inorder, inL, inL + lefSize - 1);
        ret.right = recBuildTree(preorder, preL + lefSize + 1, preR, inorder, rootIndex + 1, inR);
        return ret;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

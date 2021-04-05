package week1.preview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        ret.addAll(inorderTraversal(root.right));
        return ret;
    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            TreeNode node = stk.pop();
            ret.add(node.val);
            root = node.right;
        }
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

package week3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 61404
 */
public class SerializeandDeserializeBinaryTree297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ret = new StringBuilder();
        if (root == null) {
            return ret.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    ret.append(",null");
                    queue.add(null);
                    queue.add(null);
                }
                else {
                    ret.append(",").append(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return ret.toString().substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode ret = null;
        if (data == null || "".equals(data)) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] arr = data.split(",");
        ret = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(ret);
        int index = 1;
        while (!queue.isEmpty() && index < arr.length) {
            TreeNode node = queue.poll();
            String l = arr[index++];
            String r = arr[index++];
            if ("null".equals(l)) {
                node.left = null;
                queue.add(null);
            }
            else {
                TreeNode left = new TreeNode(Integer.parseInt(l));
                node.left = left;
                queue.add(left);
            }
            if ("null".equals(r)) {
                node.right = null;
                queue.add(null);
            }
            else {
                TreeNode right = new TreeNode(Integer.parseInt(r));
                node.right = right;
                queue.add(right);
            }
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

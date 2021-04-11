package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 61404
 */
public class NaryTreePreorderTraversal589 {

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();
        ret.add(root.val);
        for (Node child : root.children) {
            ret.addAll(preorder(child));
        }
        return ret;
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            Node node = stk.pop();
            ret.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0 ; i--) {
                    stk.push(node.children.get(i));
                }
            }
        }
        return ret;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

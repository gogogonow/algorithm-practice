package week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @author 61404
 */
public class GenerateParentheses22 {

    /**
     * 暴力递归
     * @param n 括号对数
     * @return 有效括号对
     */
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n == 0) {
            return ret;
        }
        List<String> tmp = new ArrayList<>();
        recGenParentheses("", tmp, n);
        for (String s : tmp) {
            if (isValid(s)) {
                ret.add(s);
            }
        }
        return ret;
    }

    private boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            }
            if (c == ')') {
                balance--;
            }
            if (balance < 0 || balance > s.length() / 2) {
                return false;
            }
        }
        return balance == 0;
    }

    private void recGenParentheses(String cur, List<String> ret, int n) {
        if (cur.length() == 2 * n) {
            ret.add(cur);
            return;
        }
        cur = cur + "(";
        recGenParentheses(cur, ret, n);
        cur = cur.substring(0, cur.length() - 1);
        cur = cur + ")";
        recGenParentheses(cur, ret, n);
    }


    /**
     * 递归+剪枝
     * @param n 括号对数
     * @return 有效括号对
     */
    public List<String> generateParenthesis1(int n) {
        List<String> ret = new ArrayList<>();
        if (n == 0) {
            return ret;
        }
        recGenParenthesesWithPruning("", ret, n, 0, 0);
        return ret;
    }

    private void recGenParenthesesWithPruning(String s, List<String> ret, int n, int left, int right) {
        if (left == n && right == n) {
            ret.add(s);
            return;
        }
        if (left < n) {
            recGenParenthesesWithPruning(s + "(", ret, n, left + 1, right);
        }
        if (right < left) {
            recGenParenthesesWithPruning(s + ")", ret, n, left, right + 1);
        }
    }
}

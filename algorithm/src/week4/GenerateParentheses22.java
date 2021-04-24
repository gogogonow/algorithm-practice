package week4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 61404
 */
public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> ret = new ArrayList<>();
        recGen("", 0, 0, n, ret);
        return ret;
    }

    private void recGen(String s, int lCnt, int rCnt, int n, List<String> ret) {
        if (lCnt > n || rCnt > n) {
            return;
        }
        if (s.length() == 2*n) {
            ret.add(s);
            return;
        }
        if (rCnt < lCnt) {
            s += ")";
            recGen(s + ")", lCnt, rCnt + 1, n, ret);
            s = s.substring(0, s.length() - 1);
        }
        if (lCnt < n) {
            s += "(";
            recGen(s, lCnt + 1, rCnt, n, ret);
            s = s.substring(0, s.length() - 1);
        }
    }
}

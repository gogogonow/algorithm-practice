package week6;

/**
 * @author 61404
 */
public class DecodeWays91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1, cur = 1, tmp;
        for (int i = 1; i < s.toCharArray().length; i++) {
            tmp = cur;
            int num = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (s.charAt(i) == '0') {
                if (num == 10 || num == 20) {
                    cur = pre;
                }
                else {
                    return 0;
                }
            }
            else if (num > 10 && num <= 26) {
                cur = pre + cur;
            }
            pre = tmp;
        }
        return cur;
    }
}

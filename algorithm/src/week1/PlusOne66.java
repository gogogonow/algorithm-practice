package week1;

/**
 * @author 61404
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int inc = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (inc == 1) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                }
                else {
                    digits[i]++;
                    inc = 0;
                }
            }
            else {
                return digits;
            }
        }
        if (inc == 1) {
            int[] ret = new int[digits.length + 1];
            for (int i = digits.length - 1; i >= 0; i--) {
                ret[i + 1] = digits[i];
            }
            ret[0] = 1;
            return ret;
        }
        else {
            return digits;
        }
    }

    public int[] plusOne1(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

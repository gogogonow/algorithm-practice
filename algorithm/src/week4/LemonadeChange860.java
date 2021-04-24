package week4;

/**
 * @author 61404
 */
public class LemonadeChange860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }
        if (bills[0] == 10 || bills[0] == 20) {
            return false;
        }
        int[] remCnt = {0, 0, 0};
        for (int bill : bills) {
            if (bill == 5) {
                remCnt[0]++;
            }
            if (bill == 20) {
                if (remCnt[1] > 0 && remCnt[0] > 0) {
                    remCnt[1]--;
                    remCnt[0]--;
                    remCnt[2]++;
                }
                else if (remCnt[1] == 0 && remCnt[0] >= 3){
                    remCnt[0] -= 3;
                    remCnt[2]++;
                }
                else {
                    return false;
                }
            }
            if (bill == 10) {
                if (remCnt[0] > 0) {
                    remCnt[0]--;
                    remCnt[1]++;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}

package week6;

/**
 * @author 61404
 */
public class BestTimetoBuyandSellStock121 {
    public int maxProfit(int[] prices) {
        int ret = 0;
        int preMin = Integer.MAX_VALUE;
        for (int price : prices) {
            preMin = Math.min(preMin, price);
            ret = Math.max(price - preMin, ret);
        }
        return ret;
    }
}

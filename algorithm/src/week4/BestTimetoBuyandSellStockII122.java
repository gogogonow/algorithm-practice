package week4;

/**
 * @author 61404
 */
public class BestTimetoBuyandSellStockII122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int ret = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                ret += prices[i] - pre;
            }
            pre = prices[i];
        }
        return ret;
    }
}

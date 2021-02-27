//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 690 👎 0


import java.util.logging.Logger;

public class _309_BestTimeToBuyAndSellStockWithCooldown {

    private static final Logger logger = Logger.getLogger(_309_BestTimeToBuyAndSellStockWithCooldown.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _309_BestTimeToBuyAndSellStockWithCooldown().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.maxProfit(new int[]{6, 1, 3, 2, 4, 7})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            return this.maxProfit(prices, prices.length - 1, new Integer[prices.length][2])[1];
        }

        /**
         * @return 0:cost, 1: profit
         */
        private Integer[] maxProfit(int[] prices, int i, Integer[][] profit) {
            if (profit[i] != null) {
                return profit[i];
            }
            if (i <= 0) {
                profit[0] = new Integer[]{0, 0};
            } else if (i == 1) {
                if (prices[1] > prices[0]) {
                    profit[1] = new Integer[]{prices[1] - prices[0], prices[0]};
                } else {
                    profit[1] = new Integer[]{0, 0};
                }
            } else if (i == 2) {

//
//                profit[2] = Math.max(Math.max(
//                        prices[1] > prices[0] ? prices[1] - prices[0] : 0,
//                        prices[2] > prices[1] ? prices[2] - prices[1] : 0),
//                        prices[2] > prices[0] ? prices[2] - prices[0] : 0);
            } else {
                profit[i - 1] = this.maxProfit(prices, i - 1, profit);
                profit[i - 2] = this.maxProfit(prices, i - 2, profit);
                profit[i - 3] = this.maxProfit(prices, i - 3, profit);

                profit[i] = profit[i - 1][1] > profit[i - 2][1] ? profit[i - 1] : profit[i - 2];

                Integer tempProfit1[] = new Integer[]{(profit[i - 3][1] +
                                                       (prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0))};
                Integer tempProfit2[] =
                        prices[i] > profit[i - 3][0] ? new Integer[]{profit[i - 3][0],
                                prices[i] - profit[i - 3][0]} : new Integer[]{0};

            }
            return profit[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

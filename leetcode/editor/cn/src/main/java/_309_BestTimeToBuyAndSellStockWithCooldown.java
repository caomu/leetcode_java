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

//        assert solution.maxProfit(new int[]{1, 2, 3, 0, 2}) == 3;
        logger.warning(String.valueOf(solution.maxProfit(new int[]{8, 6, 4, 3, 3, 2, 3, 5, 8, 3, 8, 2, 6})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            Integer[][] profit = new Integer[prices.length][3];
            this.maxProfit(prices, prices.length - 1, profit);
            return Math.max(profit[prices.length - 1][1], profit[prices.length - 1][2]);
        }

        /**
         * @return 0: 持有一支股票，对应的「累计最大收益」
         * 1: 不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」
         * 2: 不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」
         * dp[i][0]=max(dp[i−1][0],dp[i−1][2]−prices[i])
         * dp[i][1]=dp[i−1][0]+prices[i]
         * dp[i][2]=max(dp[i−1][1],dp[i−1][2])
         */
        private Integer[] maxProfit(int[] prices, int i, Integer[][] profit) {
            if (i == 0) {
                profit[0] = new Integer[]{-prices[0], 0, 0};
            } else {
                /*
                 * dp[i][0]=max(dp[i−1][0],dp[i−1][2]−prices[i])
                 * dp[i][1]=dp[i−1][0]+prices[i]
                 * dp[i][2]=max(dp[i−1][1],dp[i−1][2])
                 */
                if (profit[i][0] == null) {
                    profit[i][0] = Math.max(this.maxProfit(prices, i - 1, profit)[0],
                            this.maxProfit(prices, i - 1, profit)[2] - prices[i]);
                }
                if (profit[i][1] == null) {
                    profit[i][1] = this.maxProfit(prices, i - 1, profit)[0] + prices[i];
                }
                if (profit[i][2] == null) {
                    profit[i][2] = Math.max(this.maxProfit(prices, i - 1, profit)[1],
                            this.maxProfit(prices, i - 1, profit)[2]);
                }
            }
            return profit[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

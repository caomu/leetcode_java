//数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
//
// 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
//
// 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
//
//
//
// 示例 1：
//
//
//输入：cost = [10, 15, 20]
//输出：15
//解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
//
//
// 示例 2：
//
//
//输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出：6
//解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
//
//
//
//
// 提示：
//
//
// cost 的长度范围是 [2, 1000]。
// cost[i] 将会是一个整型数据，范围为 [0, 999] 。
//
// Related Topics 数组 动态规划
// 👍 529 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-21 16:19:17
 */
public class _746_MinCostClimbingStairs {

    private static final Logger logger = Logger.getLogger(_746_MinCostClimbingStairs.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _746_MinCostClimbingStairs().new Solution();

        // assert solution == ;
//        logger.warning(String.valueOf(solution.minCostClimbingStairs(new int[]{10, 15, 20})));
//        logger.warning(String.valueOf(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})));
        logger.warning(String.valueOf(solution.minCostClimbingStairs(new int[]{0, 0, 1, 1})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            return this.minCostClimbingStairs(cost, cost.length, new int[cost.length + 1]);
        }

        private int minCostClimbingStairs(int[] cost, int n, int[] dp) {
            if (n <= 1) {
                dp[n] = cost[n];
            } else if (dp[n] == 0) {
                dp[n] = Math.min(this.minCostClimbingStairs(cost, n - 1, dp),
                        this.minCostClimbingStairs(cost, n - 2, dp)) + (n == cost.length ? 0 : cost[n]);
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

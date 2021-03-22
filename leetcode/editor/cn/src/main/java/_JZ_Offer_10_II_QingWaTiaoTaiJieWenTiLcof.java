//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
// 示例 1：
//
// 输入：n = 2
//输出：2
//
//
// 示例 2：
//
// 输入：n = 7
//输出：21
//
//
// 示例 3：
//
// 输入：n = 0
//输出：1
//
// 提示：
//
//
// 0 <= n <= 100
//
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
//
//
// Related Topics 递归
// 👍 137 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-20 01:20:41
 */
public class _JZ_Offer_10_II_QingWaTiaoTaiJieWenTiLcof {

    private static final Logger logger = Logger.getLogger(_JZ_Offer_10_II_QingWaTiaoTaiJieWenTiLcof.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _JZ_Offer_10_II_QingWaTiaoTaiJieWenTiLcof().new Solution();

        assert solution.numWays(2) == 2;
        assert solution.numWays(7) == 21;
        assert solution.numWays(0) == 0;
//        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n) {
            if (n == 0) {
                return 1;
            }
            return this.numWays(n, new int[n + 1]);
        }

        private int numWays(int n, int[] dp) {
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            }
            if (dp[n] > 0) {
                return dp[n];
            }
            dp[n] = (this.numWays(n - 1, dp) + this.numWays(n - 2, dp)) % 1000000007;
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

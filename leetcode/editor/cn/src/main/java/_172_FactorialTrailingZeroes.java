//给定一个整数 n，返回 n! 结果尾数中零的数量。
//
// 示例 1:
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。
//
// 示例 2:
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零.
//
// 说明: 你算法的时间复杂度应为 O(log n) 。
// Related Topics 数学
// 👍 449 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * create time: 2021-04-20 08:23:02
 */
public class _172_FactorialTrailingZeroes {

    private static final Logger logger = Logger.getLogger(_172_FactorialTrailingZeroes.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-20 08:23:02").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _172_FactorialTrailingZeroes().new Solution();

        assert solution.trailingZeroes(3) == 0;
        assert solution.trailingZeroes(5) == 1;
        assert solution.trailingZeroes(0) == 0;
        assert solution.trailingZeroes(10) == 2;

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
        logger.info("solution cost: [" +
                    Duration.ofSeconds((System.currentTimeMillis() - startTimestamp) / 1000).toString() + "]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int cnt5 = 0;
            Integer[] dp5 = new Integer[n + 1];
            for (int i = 1; i <= n; i++) {
                cnt5 += this.cnt(5, i, dp5);
            }
            return cnt5;
        }

        private int cnt(int factor, int num, Integer[] dp) {
            if (num < factor) {
                dp[num] = 0;
            } else if (dp[num] == null && num % factor != 0) {
                dp[num] = 0;
            } else if (dp[num] == null) {
                dp[num] = this.cnt(factor, num / factor, dp) + 1;
            }
            return dp[num];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

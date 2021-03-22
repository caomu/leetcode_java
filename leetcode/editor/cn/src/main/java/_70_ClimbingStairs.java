//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1535 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-16 16:41:35
 */
public class _70_ClimbingStairs {

    private static final Logger logger = Logger.getLogger(_70_ClimbingStairs.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _70_ClimbingStairs().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            return this.climbStairs(n, new int[n + 1]);
        }

        int climbStairs(int n, int[] dp) {
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else if (dp[n] > 0) {
                return dp[n];
            }
            dp[n] = this.climbStairs(n - 1, dp) + this.climbStairs(n - 2, dp);
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

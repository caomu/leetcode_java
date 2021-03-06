//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
//输入：m = 3, n = 7
//输出：28
//
// 示例 2：
//
//
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
//
//
// 示例 3：
//
//
//输入：m = 7, n = 3
//输出：28
//
//
// 示例 4：
//
//
//输入：m = 3, n = 3
//输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 109
//
// Related Topics 数组 动态规划
// 👍 907 👎 0


import java.util.logging.Logger;

public class _62_UniquePaths {

    private static final Logger logger = Logger.getLogger(_62_UniquePaths.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _62_UniquePaths().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            return this.uniquePaths(m - 1, n - 1, new int[m][n]);
        }

        private int uniquePaths(int m, int n, int[][] dp) {
            if (dp[m][n] > 0) {
                return dp[m][n];
            }
            if (m == 0 && n == 0) {
                return 1;
            }
            if (m > 0) {
                dp[m][n] += this.uniquePaths(m - 1, n, dp);
            }
            if (n > 0) {
                dp[m][n] += this.uniquePaths(m, n - 1, dp);
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

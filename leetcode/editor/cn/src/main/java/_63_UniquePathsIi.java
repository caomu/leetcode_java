//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
//
//
// 示例 1：
//
//
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
//
// 示例 2：
//
//
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
//
//
//
//
// 提示：
//
//
// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] 为 0 或 1
//
// Related Topics 数组 动态规划
// 👍 500 👎 0


import java.util.logging.Logger;

public class _63_UniquePathsIi {

    private static final Logger logger = Logger.getLogger(_63_UniquePathsIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _63_UniquePathsIi().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[m - 1][n - 1] == 1) {
                return 0;
            }
            return this.uniquePathsWithObstacles(obstacleGrid, m - 1, n - 1, new int[m][n]);
        }

        private int uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n, int[][] dp) {
            if (dp[m][n] > 0) {
                return dp[m][n];
            }
            if (m == 0 && n == 0) {
                return 1;
            }
            if (m > 0 && obstacleGrid[m - 1][n] == 0) {
                dp[m][n] += this.uniquePathsWithObstacles(obstacleGrid, m - 1, n, dp);
            }
            if (n > 0 && obstacleGrid[m][n - 1] == 0) {
                dp[m][n] += this.uniquePathsWithObstacles(obstacleGrid, m, n - 1, dp);
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

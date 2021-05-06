//在一个小城市里，有 m 个房子排成一排，你需要给每个房子涂上 n 种颜色之一（颜色编号为 1 到 n ）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要
//被重新涂色。
//
// 我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区 [{1}, {2,2}
//, {3,3}, {2}, {1,1}] 。）
//
// 给你一个数组 houses ，一个 m * n 的矩阵 cost 和一个整数 target ，其中：
//
//
// houses[i]：是第 i 个房子的颜色，0 表示这个房子还没有被涂色。
// cost[i][j]：是将第 i 个房子涂成颜色 j+1 的花费。
//
//
// 请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 target 个街区。如果没有可用的涂色方案，请返回 -1 。
//
//
//
// 示例 1：
//
// 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n
// = 2, target = 3
//输出：9
//解释：房子涂色方案为 [1,2,2,1,1]
//此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
//涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
//
//
// 示例 2：
//
// 输入：houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n
// = 2, target = 3
//输出：11
//解释：有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
//此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
//给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
//
//
// 示例 3：
//
// 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5,
//n = 2, target = 5
//输出：5
//
//
// 示例 4：
//
// 输入：houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3
//, target = 3
//输出：-1
//解释：房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
//
//
//
//
// 提示：
//
//
// m == houses.length == cost.length
// n == cost[i].length
// 1 <= m <= 100
// 1 <= n <= 20
// 1 <= target <= m
// 0 <= houses[i] <= n
// 1 <= cost[i][j] <= 10^4
//
// Related Topics 动态规划
// 👍 97 👎 0


import com.caomu.util.Utils;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-05-04 15:08:38
 */
public class _1473_PaintHouseIii {

    private static final Logger logger = Logger.getLogger(_1473_PaintHouseIii.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-05-04 15:08:38").getTime();

    public static void main(String[] args) {
        var startTimeMillis = System.currentTimeMillis();
        var solution = new _1473_PaintHouseIii().new Solution();

        assert solution.minCost(new int[]{2, 2, 1}, Utils.stringTo2DArray("[[1,1],[3,4],[4,2]]"), 3, 2, 2) ==
               0;

        assert solution.minCost(new int[]{2, 3, 0}, Utils.stringTo2DArray("[[5,2,3],[3,4,1],[1,2,1]]"), 3, 3, 3) ==
               1;

        assert solution.minCost(new int[]{0, 2, 1, 2, 0}, Utils.stringTo2DArray("[[1,10],[10,1],[10,1],[1,10],[5,1]]"), 5, 2, 3) ==
               11;

        assert solution.minCost(new int[]{0, 0, 0, 0, 0}, Utils.stringTo2DArray("[[1,10],[10,1],[10,1],[1,10],[5,1]]"), 5, 2, 3) ==
               9;

        assert solution.minCost(new int[]{0, 0, 0, 0, 0}, Utils.stringTo2DArray("[[1,10],[10,1],[1,10],[10,1],[1,10]]"), 5, 2, 5) ==
               5;

        assert solution.minCost(new int[]{3, 1, 2, 3}, Utils.stringTo2DArray("[[1,1,1],[1,1,1],[1,1,1],[1,1,1]]"), 4, 3, 3) ==
               -1;

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            Integer[][][] dp = new Integer[m][n + 1][target + 1];
            var minCost = Integer.MAX_VALUE;
            var neighborhoods = 1;
            for (var i = m - 1; i > -1; i--) {
                if (houses[i] == 0) {
                    for (var j = 1; j <= n; j++) {
                        var minCostLeft = this.minCost(houses, cost, m, n, target, i, j,
                                i == m - 1 ?
                                        target - 1 : (
                                        j != houses[i + 1] ? target - neighborhoods - 1 : target - neighborhoods), dp);
                        if (minCostLeft >= 0) {
                            minCost = Math.min(minCost, minCostLeft + cost[i][j - 1]);
                        }
                    }
                    break;
                } else if (houses[i] > 0 && i < m - 1 && houses[i] != houses[i + 1]) {
                    neighborhoods++;
                }
                if (neighborhoods == target && i == 0) {
                    minCost = 0;
                }
            }
            return minCost == Integer.MAX_VALUE ? -1 : minCost;
        }

        private int minCost(int[] houses, int[][] cost, int m, int n, int target, int houseIndex, int colorIndex, int targetLeft, Integer[][][] dp) {
            if (targetLeft < 0) {
                return -1;
            } else if (dp[houseIndex][colorIndex][targetLeft] == null) {
                if (targetLeft == 0 && houseIndex == 0) {
                    dp[0][colorIndex][0] = 0;
                } else {
                    dp[houseIndex][colorIndex][targetLeft] = Integer.MAX_VALUE;
                    var newTargetLeft = targetLeft;
                    for (var i = houseIndex - 1; i > -1; i--) {
                        if (houses[i] == 0) {
                            for (var j = 1; j <= n; j++) {
                                var minCostLeft = this.minCost(houses, cost, m, n, target, i, j,
                                        j == (houses[i + 1] == 0 ? colorIndex : houses[i + 1]) ? newTargetLeft :
                                                newTargetLeft - 1, dp);
                                if (minCostLeft >= 0) {
                                    dp[houseIndex][colorIndex][targetLeft] = Math.min(dp[houseIndex][colorIndex][targetLeft],
                                            minCostLeft + cost[i][j - 1]);
                                }
                            }
                            break;
                        } else if ((i == houseIndex - 1 && houses[i] != colorIndex) ||
                                   (i < houseIndex - 1 && houses[i] != houses[i + 1])) {
                            newTargetLeft--;
                        }
                        if (newTargetLeft == 0 && i == 0) {
                            dp[houseIndex][colorIndex][targetLeft] = 0;
                        }
                    }
                }
                if (dp[houseIndex][colorIndex][targetLeft] == Integer.MAX_VALUE) {
                    dp[houseIndex][colorIndex][targetLeft] = -1;
                }
            }
            return dp[houseIndex][colorIndex][targetLeft];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
//
// 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,0,1],[0,-2,3]], k = 2
//输出：2
//解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
//
//
// 示例 2：
//
//
//输入：matrix = [[2,2,-1]], k = 3
//输出：3
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -100 <= matrix[i][j] <= 100
// -105 <= k <= 105
//
//
//
//
// 进阶：如果行数远大于列数，该如何设计解决方案？
// Related Topics 队列 二分查找 动态规划
// 👍 273 👎 0


import com.caomu.util.Utils;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-22 21:07:18
 */
public class _363_MaxSumOfRectangleNoLargerThanK {

    private static final Logger logger = Logger.getLogger(_363_MaxSumOfRectangleNoLargerThanK.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-22 21:07:18").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _363_MaxSumOfRectangleNoLargerThanK().new Solution();

        assert solution.maxSumSubmatrix(Utils.stringTo2DArray("[[1,0,1],[0,-2,3]]"), 2) == 2;
        assert solution.maxSumSubmatrix(Utils.stringTo2DArray("[[2,2,-1]]"), 3) == 3;

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] matrixSum = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrixSum[i][j] = (i > 0 ? matrixSum[i - 1][j] : 0) + matrix[i][j];
                }
            }
            int max = Integer.MIN_VALUE;
            loop:
            for (int i = 0; i < m; i++) {
                for (int j = i; j < m; j++) {
                    int[] arraySum = new int[n];
                    for (int l = 0; l < n; l++) {
                        arraySum[l] =
                                (l > 0 ? arraySum[l - 1] : 0) + matrixSum[j][l] - (i > 0 ? matrixSum[i - 1][l] : 0);
                        if (l == 0 && arraySum[0] <= k) {
                            max = Math.max(max, arraySum[0]);
                        }
                        for (int o = 0; o < l; o++) {
                            int sum = arraySum[l] - (o > 0 ? arraySum[o] : 0);
                            if (sum == k) {
                                max = sum;
                                break loop;
                            } else if (sum < k) {
                                max = Math.max(max, sum);
                            }
                        }
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
// Related Topics 数组
// 👍 332 👎 0


import com.caomu.util.Utils;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * create time: 2021-03-16 10:12:26
 */
public class _59_SpiralMatrixIi {

    private static final Logger logger = Logger.getLogger(_59_SpiralMatrixIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _59_SpiralMatrixIi().new Solution();

        assert Arrays.deepEquals(solution.generateMatrix(3), Utils.stringTo2DArray("[[1,2,3],[8,9,4],[7,6,5]]"));
        assert Arrays.deepEquals(solution.generateMatrix(1), Utils.stringTo2DArray("[[1]]"));
//        logger.warning(Arrays.deepToString(solution.generateMatrix(3)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int p = 1;
            for (int i = 0; i < (n + 1) / 2; i++) {
                int border = n - i - 1;
                for (int j = i; j <= border; j++) {
                    matrix[i][j] = p++;
                }
                for (int j = i + 1; j <= border; j++) {
                    matrix[j][border] = p++;
                }
                for (int j = border - 1; j >= i + 1; j--) {
                    matrix[border][j] = p++;
                }
                for (int j = border; j >= i + 1; j--) {
                    matrix[j][i] = p++;
                }
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
//
//
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
//
// 示例:
//
// 给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
//
//
// 说明:
//
//
// 你可以假设矩阵不可变。
// 会多次调用 sumRegion 方法。
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
//
// Related Topics 动态规划
// 👍 157 👎 0


import com.caomu.util.Utils;

import java.util.logging.Logger;

public class _304_RangeSumQuery2dImmutable {

    private static final Logger logger = Logger.getLogger(_304_RangeSumQuery2dImmutable.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        NumMatrix numMatrix = new _304_RangeSumQuery2dImmutable().new NumMatrix(
                Utils.stringTo2DArray("[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]"));

        // assert solution == ;
        logger.warning(String.valueOf(numMatrix.sumRegion(2, 1, 4, 3)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        int[][] prefixSum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }
            this.prefixSum = new int[matrix.length][matrix[0].length];
            this.prefixSum[0][0] = matrix[0][0];
            for (int i = 1; i < matrix.length; i++) {
                this.prefixSum[i][0] = this.prefixSum[i - 1][0] + matrix[i][0];
            }
            for (int j = 1; j < matrix[0].length; j++) {
                this.prefixSum[0][j] = this.prefixSum[0][j - 1] + matrix[0][j];
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    this.prefixSum[i][j] =
                            this.prefixSum[i][j - 1] + this.prefixSum[i - 1][j] - this.prefixSum[i - 1][j - 1] +
                            matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return this.prefixSum[row2][col2] - (row1 > 0 ? this.prefixSum[row1 - 1][col2] : 0) -
                   (col1 > 0 ? this.prefixSum[row2][col1 - 1] : 0) +
                   (row1 > 0 && col1 > 0 ? this.prefixSum[row1 - 1][col1 - 1] : 0);
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

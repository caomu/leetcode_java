//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
//
//
//
// 示例:
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
//
//
//
//
// 说明:
//
//
// 给定矩阵中的元素总数不会超过 100000 。
//
// 👍 172 👎 0


import com.caomu.util.Utils;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * create time: 2021-03-13 20:28:39
 */
public class _498_DiagonalTraverse {

    private static final Logger logger = Logger.getLogger(_498_DiagonalTraverse.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _498_DiagonalTraverse().new Solution();

        // assert solution == ;
        logger.warning(Arrays.toString(solution.findDiagonalOrder(Utils.stringTo2DArray("[[1,2,3],[4,5,6],[7,8,9],[10,11,12]]"))));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new int[0];
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[] diagonalOrder = new int[m * n];
            int k = 0;
            boolean isUp = true;
            for (int i = 0; i < (Math.max(m, n) * 2 - 1); i++) {
                int j = isUp ? m - 1 : 0;
                while (j >= 0 && j < m) {
                    if (i - j >= 0 && i - j < n) {
                        diagonalOrder[k++] = matrix[j][i - j];
                    }
                    j += isUp ? -1 : 1;
                }
                isUp = !isUp;
            }
            return diagonalOrder;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

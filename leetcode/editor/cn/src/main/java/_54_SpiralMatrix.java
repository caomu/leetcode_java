//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组
// 👍 638 👎 0


import com.caomu.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * create time: 2021-03-15 09:27:16
 */
public class _54_SpiralMatrix {

    private static final Logger logger = Logger.getLogger(_54_SpiralMatrix.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _54_SpiralMatrix().new Solution();

        assert Objects.equals(solution.spiralOrder(Utils.stringTo2DArray("[[1,2,3],[4,5,6],[7,8,9]]")),
                Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
        assert Objects.equals(solution.spiralOrder(Utils.stringTo2DArray("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]")),
                Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
        assert Objects.equals(solution.spiralOrder(Utils.stringTo2DArray("[[3],[2]]")), Arrays.asList(3, 2));
        assert Objects.equals(solution.spiralOrder(Utils.stringTo2DArray("[[6,9,7]]")), Arrays.asList(6, 9, 7));
//        logger.warning(solution.spiralOrder(Utils.stringTo2DArray("[[1,2,3],[4,5,6],[7,8,9],[10,11,12]]")).toString());
//        logger.warning(solution.spiralOrder(Utils.stringTo2DArray("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]")).toString());
//        logger.warning(solution.spiralOrder(Utils.stringTo2DArray("[[3],[2]]")).toString());
//        logger.warning(solution.spiralOrder(Utils.stringTo2DArray("[[6,9,7]]")).toString());


        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> spiralOrder = new ArrayList<>(m * n);
            for (int i = 0; i < (Math.min(m, n) + 1) / 2; i++) {
                int bottom = m - i - 1;
                int right = n - i - 1;
                for (int j = i; j <= right; j++) {
                    spiralOrder.add(matrix[i][j]);
                }
                for (int j = i + 1; j <= bottom; j++) {
                    spiralOrder.add(matrix[j][right]);
                }
                if (bottom > i) {
                    for (int j = right - 1; j >= i + 1; j--) {
                        spiralOrder.add(matrix[bottom][j]);
                    }
                }
                if (right > i) {
                    for (int j = bottom; j >= i + 1; j--) {
                        spiralOrder.add(matrix[j][i]);
                    }
                }
            }
            return spiralOrder;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

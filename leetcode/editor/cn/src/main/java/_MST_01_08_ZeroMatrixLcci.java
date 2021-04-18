//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//
//
//
// 示例 1：
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//
//
// 示例 2：
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//
// Related Topics 数组
// 👍 29 👎 0


import java.util.Arrays;
import java.util.logging.Logger;

/**
 * create time: 2021-04-17 09:18:58
 */
public class _MST_01_08_ZeroMatrixLcci {

    private static final Logger logger = Logger.getLogger(_MST_01_08_ZeroMatrixLcci.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _MST_01_08_ZeroMatrixLcci().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean isZeroOnColumn0 = false;
            boolean isZeroOnRow0 = false;
            for (int i = 0; i < matrix.length; i++) {
                isZeroOnColumn0 = matrix[i][0] == 0;
                if (isZeroOnColumn0) {
                    break;
                }
            }
            for (int i = 0; i < matrix[0].length; i++) {
                isZeroOnRow0 = matrix[0][i] == 0;
                if (isZeroOnRow0) {
                    break;
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (isZeroOnColumn0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (isZeroOnRow0) {
                Arrays.fill(matrix[0], 0);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

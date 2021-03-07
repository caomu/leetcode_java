//给你两个 稀疏矩阵 A 和 B，请你返回 AB 的结果。你可以默认 A 的列数等于 B 的行数。
//
// 请仔细阅读下面的示例。
//
//
//
// 示例：
//
// 输入：
//
//A = [
//  [ 1, 0, 0],
//  [-1, 0, 3]
//]
//
//B = [
//  [ 7, 0, 0 ],
//  [ 0, 0, 0 ],
//  [ 0, 0, 1 ]
//]
//
//输出：
//
//     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
//AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                  | 0 0 1 |
//
// Related Topics 哈希表
// 👍 41 👎 0


import java.util.logging.Logger;

public class _311_SparseMatrixMultiplication {

    private static final Logger logger = Logger.getLogger(_311_SparseMatrixMultiplication.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _311_SparseMatrixMultiplication().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] multiply(int[][] A, int[][] B) {
            int[][] multiply = new int[A.length][B[0].length];
            for (int i = 0; i < multiply.length; i++) {
                for (int j = 0; j < multiply[0].length; j++) {
                    for (int k = 0; k < A[0].length; k++) {
                        multiply[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return multiply;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

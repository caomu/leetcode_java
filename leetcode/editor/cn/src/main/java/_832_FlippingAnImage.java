//给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。 
//
// 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。 
//
// 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。 
//
// 
//
// 示例 1： 
//
// 
//输入：[[1,1,0],[1,0,1],[0,0,0]]
//输出：[[1,0,0],[0,1,0],[1,1,1]]
//解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = A[0].length <= 20 
// 0 <= A[i][j] <= 1 
// 
// Related Topics 数组 
// 👍 238 👎 0


import java.util.logging.Logger;

public class _832_FlippingAnImage {

    private static final Logger logger = Logger.getLogger(_832_FlippingAnImage.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _832_FlippingAnImage().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            for (int i = 0; i < A.length; i++) {
                int p = 0;
                int q = A[0].length - 1;
                while (p < q) {
                    if (A[i][p] == A[i][q]) {
                        A[i][p] = A[i][p] == 1 ? 0 : 1;
                        A[i][q] = A[i][q] == 1 ? 0 : 1;
                    }
                    p++;
                    q--;
                }
                if (p == q) {
                    A[i][p] = A[i][p] == 1 ? 0 : 1;
                }
            }
            return A;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

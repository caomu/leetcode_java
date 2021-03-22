//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
// 示例:
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// Related Topics 树 动态规划
// 👍 1061 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-19 20:57:12
 */
public class _96_UniqueBinarySearchTrees {

    private static final Logger logger = Logger.getLogger(_96_UniqueBinarySearchTrees.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _96_UniqueBinarySearchTrees().new Solution();

//        assert solution.numTrees(4) == 5;
        assert solution.numTrees(3) == 5;
        assert solution.numTrees(2) == 2;
        assert solution.numTrees(1) == 1;
//        logger.warning(String.valueOf(solution.numTrees(3)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            return this.numTrees(n, new int[n + 1]);
        }

        private int numTrees(int n, int[] dp) {
            if (n <= 1) {
                return n;
            }
            if (dp[n] > 0) {
                return dp[n];
            }
            for (int i = 2; i <= n - 1; i++) {
                dp[n] += this.numTrees(i - 1, dp) * this.numTrees(n - i, dp);
            }
            dp[n] += this.numTrees(n - 1, dp) * 2;
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

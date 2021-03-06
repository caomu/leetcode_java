//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
// 示例 1:
//
// 输入: 2
//输出: [0,1,1]
//
// 示例 2:
//
// 输入: 5
//输出: [0,1,1,2,1,2]
//
// 进阶:
//
//
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
// 要求算法的空间复杂度为O(n)。
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
//
// Related Topics 位运算 动态规划
// 👍 630 👎 0


import java.util.logging.Logger;
import java.util.stream.IntStream;

public class _338_CountingBits {

    private static final Logger logger = Logger.getLogger(_338_CountingBits.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _338_CountingBits().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int num) {
            int[] bits = new int[num + 1];
            bits[0] = 0;
            IntStream.rangeClosed(0, num).forEach(n -> this.countBits(n, bits));
            return bits;
        }

        private int countBits(int n, int[] dp) {
            if (dp[n] > 0 || n == 0) {
                return dp[n];
            }
            dp[n] = this.countBits(n & (n - 1), dp) + 1;
            return dp[n];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
//
//
//
// 示例 1：
//
//
//输入：n = 27
//输出：true
//
//
// 示例 2：
//
//
//输入：n = 0
//输出：false
//
//
// 示例 3：
//
//
//输入：n = 9
//输出：true
//
//
// 示例 4：
//
//
//输入：n = 45
//输出：false
//
//
//
//
// 提示：
//
//
// -231 <= n <= 231 - 1
//
//
//
//
// 进阶：
//
//
// 你能不使用循环或者递归来完成本题吗？
//
// Related Topics 数学
// 👍 141 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-13 19:58:43
 */
public class _326_PowerOfThree {

    private static final Logger logger = Logger.getLogger(_326_PowerOfThree.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _326_PowerOfThree().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfThree(int n) {
            return n > 0 && 1162261467 % n == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 *
// 3 * 2 * 1。
//
// 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)
//和减法(-)。
//
// 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我
//们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
//
// 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
//
// 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
//
//
//
// 示例 1：
//
// 输入：4
//输出：7
//解释：7 = 4 * 3 / 2 + 1
//
//
// 示例 2：
//
// 输入：10
//输出：12
//解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
//
//
//
//
// 提示：
//
//
// 1 <= N <= 10000
// -2^31 <= answer <= 2^31 - 1 （答案保证符合 32 位整数。）
//
// Related Topics 数学
// 👍 113 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-04-01 22:37:30
 */
public class _1006_ClumsyFactorial {

    private static final Logger logger = Logger.getLogger(_1006_ClumsyFactorial.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1006_ClumsyFactorial().new Solution();

        assert solution.clumsy(4) == 7;
        assert solution.clumsy(10) == 12;
        logger.warning(String.valueOf(solution.clumsy(5)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int clumsy(int N) {
            if (N == 1) {
                return 1;
            } else if (N == 2) {
                return 2;
            } else if (N == 3) {
                return 6;
            }
            return (N * (N - 1) / (N - 2)) + this._clumsy(N - 3);
        }

        private int _clumsy(int N) {
            if (N <= 3) {
                return 1;
            } else if (N == 4) {
                return -2;
            }
            return N - ((N - 1) * (N - 2) / (N - 3)) + this._clumsy(N - 4);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

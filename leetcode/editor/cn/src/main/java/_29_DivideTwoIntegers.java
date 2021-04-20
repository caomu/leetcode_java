//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//
//
//
// 示例 1:
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
//
// 示例 2:
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2
//
//
//
// 提示：
//
//
// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//
// Related Topics 数学 二分查找
// 👍 556 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-20 22:18:45
 */
public class _29_DivideTwoIntegers {

    private static final Logger logger = Logger.getLogger(_29_DivideTwoIntegers.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-20 22:18:45").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _29_DivideTwoIntegers().new Solution();

        assert solution.divide(10, 3) == 3;
        assert solution.divide(-2147483648, -1) == 2147483647;
        assert solution.divide(-2147483648, 1) == -2147483648;

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            long longDividend = dividend;
            long longDivisor = divisor;
            if (dividend > 0 && divisor > 0) {
                return this.dividePositive(longDividend, longDivisor);
            } else if (dividend < 0 && divisor < 0) {
                return this.dividePositive(-longDividend, -longDivisor);
            } else if (dividend < 0 && divisor > 0) {
                return -this.dividePositive(-longDividend, longDivisor);
            } else if (dividend > 0 && divisor < 0) {
                return -this.dividePositive(longDividend, -longDivisor);
            } else {
                return 0;
            }
        }

        private int dividePositive(long dividend, long divisor) {
            if (dividend < divisor) {
                return 0;
            }
            long left = 1;
            long right = dividend;
            long mid = 0;
            while (left <= right) {
                mid = left + ((right - left) >> 1);
                long mult = this.multiplication(mid, divisor);
                long mult1 = this.multiplication(mid + 1, divisor);
                if (mult <= dividend && mult1 > dividend) {
                    return (int) mid;
                } else if (mult1 == dividend) {
                    return (int) mid + 1;
                } else if (mult1 < dividend) {
                    left = mid + 1;
                } else if (mult > dividend) {
                    right = mid - 1;
                }
            }
            return (int) mid;
        }

        //倍增乘法解法
        private long multiplication(long a, long k) {
            long ans = 0;
            while (k > 0) {
                if ((k & 1) == 1) {
                    ans += a;
                }
                k >>= 1;
                a += a;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

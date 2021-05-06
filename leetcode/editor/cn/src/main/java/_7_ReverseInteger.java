//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -231 <= x <= 231 - 1
//
// Related Topics 数学
// 👍 2741 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-05-03 09:17:46
 */
public class _7_ReverseInteger {

    private static final Logger logger = Logger.getLogger(_7_ReverseInteger.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-05-03 09:17:46").getTime();

    public static void main(String[] args) {
        var startTimeMillis = System.currentTimeMillis();
        var solution = new _7_ReverseInteger().new Solution();

        assert solution.reverse(123) == 321;
        assert solution.reverse(-123) == -321;
        assert solution.reverse(120) == 21;
        assert solution.reverse(0) == 0;
        assert solution.reverse(Integer.MAX_VALUE) == 0;
        assert solution.reverse(Integer.MIN_VALUE) == 0;

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            var y = 0;
            var max = Integer.MAX_VALUE / 10;
            var min = Integer.MIN_VALUE / 10;
            while (x != 0) {
                if (y > max || y < min) {
                    return 0;
                }
                y = y * 10 + x % 10;
                x /= 10;
            }
            return y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

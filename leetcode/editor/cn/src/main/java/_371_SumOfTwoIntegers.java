//不使用运算符 + 和 - ，计算两整数 a 、b 之和。
//
// 示例 1:
//
// 输入: a = 1, b = 2
//输出: 3
//
//
// 示例 2:
//
// 输入: a = -2, b = 3
//输出: 1
// Related Topics 位运算
// 👍 389 👎 0


import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-20 22:10:25
 */
public class _371_SumOfTwoIntegers {

    private static final Logger logger = Logger.getLogger(_371_SumOfTwoIntegers.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-20 22:10:25").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _371_SumOfTwoIntegers().new Solution();

        assert solution == null;
        // logger.log(Level.WARNING, solution);

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int temp = a ^ b;
                b = (a & b) << 1;
                a = temp;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

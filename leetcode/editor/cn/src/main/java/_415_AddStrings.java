//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//
//
// 提示：
//
//
// num1 和num2 的长度都小于 5100
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
//
// Related Topics 字符串
// 👍 333 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-03-20 01:37:38
 */
public class _415_AddStrings {

    private static final Logger logger = Logger.getLogger(_415_AddStrings.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _415_AddStrings().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.addStrings("999", "666")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            boolean isCarry = false;
            StringBuilder sb = new StringBuilder();
            char[] num1Ch = num1.toCharArray();
            char[] num2Ch = num2.toCharArray();
            for (int i = 0; i < Math.max(num1Ch.length, num2Ch.length); i++) {
                int n;
                if (i >= num1Ch.length) {
                    n = num2Ch[num2Ch.length - 1 - i] - '0';
                } else if (i >= num2Ch.length) {
                    n = num1Ch[num1Ch.length - 1 - i] - '0';
                } else {
                    n = (num2Ch[num2Ch.length - 1 - i] - '0') + (num1Ch[num1Ch.length - 1 - i] - '0');
                }

                if (isCarry) {
                    n++;
                }
                isCarry = n >= 10;
                sb.insert(0, n % 10);
            }
            if (isCarry) {
                sb.insert(0, 1);
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

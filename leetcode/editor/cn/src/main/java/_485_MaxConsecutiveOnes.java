//给定一个二进制数组， 计算其中最大连续 1 的个数。
//
//
//
// 示例：
//
//
//输入：[1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
//
//
//
//
// 提示：
//
//
// 输入的数组只包含 0 和 1 。
// 输入数组的长度是正整数，且不超过 10,000。
//
// Related Topics 数组
// 👍 228 👎 0


import java.util.logging.Logger;

/**
 * create time: 2021-04-17 09:48:26
 */
public class _485_MaxConsecutiveOnes {

    private static final Logger logger = Logger.getLogger(_485_MaxConsecutiveOnes.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _485_MaxConsecutiveOnes().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int cnt = 0;
            for (int num : nums) {
                if (num != 1) {
                    cnt = 0;
                } else {
                    max = Math.max(++cnt, max);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
//
//
//
// 示例 1：
//
//
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1690
//
// Related Topics 堆 数学 动态规划
// 👍 617 👎 0


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.logging.Logger;

/**
 * create time: 2021-04-11 22:18:59
 */
public class _264_UglyNumberIi {

    private static final Logger logger = Logger.getLogger(_264_UglyNumberIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _264_UglyNumberIi().new Solution();

        assert solution.nthUglyNumber(10) == 12;
        assert solution.nthUglyNumber(11) == 15;
        logger.warning(String.valueOf(solution.nthUglyNumber(1690)));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            PriorityQueue<Long> heap = new PriorityQueue<>();
            heap.add(1L);
            Set<Long> uglyNumbers = new HashSet<>();
            uglyNumbers.add(1L);
            long result = 1;
            for (int i = 0; i < n; i++) {
                result = heap.poll();
                long nextUglyNumber = result * 2;
                if (uglyNumbers.add(nextUglyNumber)) {
                    heap.offer(nextUglyNumber);
                }
                nextUglyNumber = result * 3;
                if (uglyNumbers.add(nextUglyNumber)) {
                    heap.offer(nextUglyNumber);
                }
                nextUglyNumber = result * 5;
                if (uglyNumbers.add(nextUglyNumber)) {
                    heap.offer(nextUglyNumber);
                }
            }
            return ((Long) result).intValue();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

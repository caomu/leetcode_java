//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < a
//j。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
//
// 注意：n 的值小于15000。
//
// 示例1:
//
//
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
//
//
// 示例 2:
//
//
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
//
//
// 示例 3:
//
//
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
//
// Related Topics 栈
// 👍 293 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * create time: 2021-03-24 01:08:17
 */
public class _456_One32Pattern {

    private static final Logger logger = Logger.getLogger(_456_One32Pattern.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _456_One32Pattern().new Solution();

//        assert solution.find132pattern(new int[]{1, 2, 3, 4}) == false;
//        assert solution.find132pattern(new int[]{3, 1, 4, 2}) == true;
//        assert solution.find132pattern(new int[]{-1, 3, 2, 0}) == true;
        assert solution.find132pattern(new int[]{3, 5, 0, 3, 4}) == true;
//        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            Deque<Integer> stack = new LinkedList<>();
            int length = nums.length;
            stack.push(nums[length - 1]);
            int maxK = Integer.MIN_VALUE;
            for (int i = length - 2; i >= 0; i--) {
                if (nums[i] < maxK) {
                    return true;
                }
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    maxK = stack.pop();
                }
                if (nums[i] > maxK) {
                    stack.push(nums[i]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

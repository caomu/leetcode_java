//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
//
// 示例 1:
//
//
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数；
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
//
//
// 注意: 输入数组的长度不会超过 10000。
// Related Topics 栈
// 👍 327 👎 0


import java.util.*;
import java.util.logging.Logger;

public class _503_NextGreaterElementIi {

    private static final Logger logger = Logger.getLogger(_503_NextGreaterElementIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _503_NextGreaterElementIi().new Solution();

        // assert solution == ;
//        logger.warning(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 1})));
        logger.warning(Arrays.toString(solution.nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Deque<Integer> stack = new LinkedList<>();
            Map<Integer, Integer> nextGreeterElementMap = new HashMap<>();
            for (int i = 0; i < nums.length * 2; i++) {
                int ii = i % nums.length;
                while (!stack.isEmpty() && nums[stack.peek()] < nums[ii]) {
                    nextGreeterElementMap.put(stack.pop(), ii);
                }
                stack.push(ii);
            }
            while (!stack.isEmpty()) {
                int i = stack.pop();
                if (!nextGreeterElementMap.containsKey(i)) {
                    nextGreeterElementMap.put(i, -1);
                }
            }
            int[] nextGreaterElement = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                nextGreaterElement[i] = nextGreeterElementMap.get(i) == -1 ? -1 : nums[nextGreeterElementMap.get(i)];
            }
            return nextGreaterElement;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

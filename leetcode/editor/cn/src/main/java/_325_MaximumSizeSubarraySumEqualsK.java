//给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。 
//
// 注意: 
// nums 数组的总和是一定在 32 位有符号整数范围之内的。 
//
// 示例 1: 
//
// 输入: nums = [1, -1, 5, -2, 3], k = 3
//输出: 4 
//解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
// 
//
// 示例 2: 
//
// 输入: nums = [-2, -1, 2, 1], k = 1
//输出: 2 
//解释: 子数组 [-1, 2] 和等于 1，且长度最长。 
//
// 进阶: 
//你能使时间复杂度在 O(n) 内完成此题吗? 
// Related Topics 哈希表 
// 👍 97 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class _325_MaximumSizeSubarraySumEqualsK {

    private static final Logger logger = Logger.getLogger(_325_MaximumSizeSubarraySumEqualsK.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _325_MaximumSizeSubarraySumEqualsK().new Solution();
        logger.warning(String.valueOf(solution.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3)));
        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            if (nums.length == 0) {
                return 0;
            }
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            Map<Integer, Integer> sumIndexMap = new HashMap<>();
            sumIndexMap.put(sum[0], 0);
            int maxLength = sum[0] == k ? 1 : 0;
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
                sumIndexMap.putIfAbsent(sum[i], i);
                if (sum[i] == k) {
                    maxLength = Math.max(maxLength, i + 1);
                } else if (sumIndexMap.containsKey(sum[i] - k)) {
                    maxLength = Math.max(maxLength, i - sumIndexMap.get(sum[i] - k));
                }
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

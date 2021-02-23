//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 774 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class _560_SubarraySumEqualsK {

    private static final Logger logger = Logger.getLogger(_560_SubarraySumEqualsK.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _560_SubarraySumEqualsK().new Solution();
        assert 1 == solution.subarraySum(new int[]{-1, -1, 1}, 0);
        assert 3 == solution.subarraySum(new int[]{1, -1, 0}, 0);
        assert 2 == solution.subarraySum(new int[]{1, 1, 1}, 2);
        logger.warning(String.valueOf(solution.subarraySum(new int[]{1, 1, 1}, 2)));
        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            int cnt = sum[0] == k ? 1 : 0;
            Map<Integer, Integer> sumIndexMap = new HashMap<>();
            sumIndexMap.put(nums[0], 1);
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
                if (sum[i] == k) {
                    cnt++;
                }
                if (sumIndexMap.containsKey(sum[i] - k)) {
                    cnt += sumIndexMap.get(sum[i] - k);
                }
                sumIndexMap.put(sum[i], sumIndexMap.getOrDefault(sum[i], 0) + 1);
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

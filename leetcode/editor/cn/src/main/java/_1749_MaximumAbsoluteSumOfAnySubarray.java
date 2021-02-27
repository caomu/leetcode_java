//给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl
// + numsl+1 + ... + numsr-1 + numsr) 。 
//
// 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。 
//
// abs(x) 定义如下： 
//
// 
// 如果 x 是负整数，那么 abs(x) = -x 。 
// 如果 x 是非负整数，那么 abs(x) = x 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-3,2,3,-4]
//输出：5
//解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,-5,1,-4,3,-2]
//输出：8
//解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
// Related Topics 贪心算法 
// 👍 5 👎 0


import java.util.logging.Logger;

public class _1749_MaximumAbsoluteSumOfAnySubarray {

    private static final Logger logger = Logger.getLogger(_1749_MaximumAbsoluteSumOfAnySubarray.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1749_MaximumAbsoluteSumOfAnySubarray().new Solution();

//        assert solution.maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}) == 5;
//        assert solution.maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}) == 8;
//        assert solution.maxAbsoluteSum(new int[]{-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9}) ==
//               44;
        assert solution.maxAbsoluteSum(new int[]{-3, -5, -3, -2, -6, 3, 10, -10, -8, -3, 0, 10, 3, -5, 8, 7, -9, -9, 5, -8}) ==
               27;

//        logger.warning(String.valueOf(solution.maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            int max = sum[0];
            int maxIdx = 0;
            int min = sum[0];
            int minIdx = 0;
            int maxAbsoluteSum = Math.max(Math.abs(min), max);
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
                if (sum[i] > max) {
                    max = sum[i];
                    maxIdx = i;
                    maxAbsoluteSum = Math.max(maxAbsoluteSum, max);
                }
                if (sum[i] < min) {
                    min = sum[i];
                    minIdx = i;
                    maxAbsoluteSum = Math.max(maxAbsoluteSum, Math.abs(min));
                }
                if (sum[i] < 0 && sum[maxIdx] > 0) {
                    maxAbsoluteSum = Math.max(maxAbsoluteSum, sum[maxIdx] - sum[i]);
                } else if (sum[i] > 0 && sum[minIdx] < 0) {
                    maxAbsoluteSum = Math.max(maxAbsoluteSum, sum[i] - sum[minIdx]);
                }
            }
            return maxAbsoluteSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

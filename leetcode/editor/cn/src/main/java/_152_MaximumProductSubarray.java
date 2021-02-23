//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 952 👎 0


import java.util.logging.Logger;

public class _152_MaximumProductSubarray {

    private static final Logger logger = Logger.getLogger(_152_MaximumProductSubarray.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _152_MaximumProductSubarray().new Solution();
        assert 6 == solution.maxProduct(new int[]{2, 3, -2, 4});
        assert -2 == solution.maxProduct(new int[]{-2});
        assert 2 == solution.maxProduct(new int[]{0, 2});
        assert 0 == solution.maxProduct(new int[]{-2, 0, -1});
        assert 2 == solution.maxProduct(new int[]{-1, 0, -2, 2});
//        logger.warning(String.valueOf(solution.maxProduct(new int[]{0, 2})));
        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int product = 0;
            int maxPostive = 0;
            int maxNegative = Integer.MIN_VALUE;
            boolean hasZero = false;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    if (nums[0] == 0) {
                        hasZero = true;
                        product = 1;
                        continue;
                    } else {
                        product = nums[0];
                    }
                } else {
                    if (nums[i] == 0) {
                        hasZero = true;
                        maxNegative = Integer.MIN_VALUE;
                        product = 1;
                        continue;
                    } else {
                        product *= nums[i];
                    }
                }

                if (product > 0) {
                    maxPostive = Math.max(maxPostive, product);
                } else {
                    if (maxNegative != Integer.MIN_VALUE) {
                        maxPostive = Math.max(maxPostive, product / maxNegative);
                    }
                    maxNegative = Math.max(maxNegative, product);
                }
            }
            if (maxPostive != 0) {
                return maxPostive;
            }
            if (hasZero) {
                return 0;
            }
            return maxNegative;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
//
//
//
//
//
//
// 示例 1：
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
//
// 示例 2：
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
//
//
// 示例 3：
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 4 * 10^4
// 1 <= nums[i] <= 10^4
//
// Related Topics 动态规划
// 👍 113 👎 0


import java.util.Arrays;
import java.util.logging.Logger;

/**
 * create time: 2021-03-23 09:14:13
 */
public class _1262_GreatestSumDivisibleByThree {

    private static final Logger logger = Logger.getLogger(_1262_GreatestSumDivisibleByThree.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1262_GreatestSumDivisibleByThree().new Solution();

        assert solution.maxSumDivThree(new int[]{3, 6, 5, 1, 8}) == 18;
        assert solution.maxSumDivThree(new int[]{2, 6, 2, 2, 7}) == 15;
//        assert solution.maxSumDivThree(new int[]{4}) == 0;
//        assert solution.maxSumDivThree(new int[]{1, 2, 3, 4, 4}) == 12;
//        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumDivThree(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int remainder = sum % 3;
            if (remainder == 0) {
                return sum;
            }
            Arrays.sort(nums);
            if (remainder == 1) {
                boolean isFoundMinuend1 = false;
                boolean[] isFoundMinuend2 = new boolean[]{false, false};
                int minuend1 = 0;
                int minuend2 = 0;
                for (int num : nums) {
                    if (!isFoundMinuend1 && num % 3 == 1) {
                        isFoundMinuend1 = true;
                        minuend1 = num;
                    }
                    if (!isFoundMinuend2[0] && num % 3 == 2) {
                        minuend2 = num;
                        isFoundMinuend2[0] = true;
                    } else if (!isFoundMinuend2[1] && num % 3 == 2) {
                        minuend2 += num;
                        isFoundMinuend2[1] = true;
                    }
                    if (isFoundMinuend2[1] && isFoundMinuend1) {
                        break;
                    }
                }
                if (isFoundMinuend1 && !isFoundMinuend2[1]) {
                    return sum - minuend1;
                } else if (!isFoundMinuend1 && isFoundMinuend2[1]) {
                    return sum - minuend2;
                } else if (isFoundMinuend1) {
                    return sum - Math.min(minuend1, minuend2);
                } else {
                    return 0;
                }
            }
            boolean[] isFoundMinuend1 = new boolean[]{false, false};
            boolean isFoundMinuend2 = false;
            int minuend1 = 0;
            int minuend2 = 0;
            for (int num : nums) {
                if (!isFoundMinuend1[0] && num % 3 == 1) {
                    isFoundMinuend1[0] = true;
                    minuend1 = num;
                } else if (!isFoundMinuend1[1] && num % 3 == 1) {
                    isFoundMinuend1[1] = true;
                    minuend1 += num;
                }
                if (num % 3 == 2) {
                    minuend2 = num;
                    isFoundMinuend2 = true;
                    break;
                }
            }
            if (isFoundMinuend1[1] && !isFoundMinuend2) {
                return sum - minuend1;
            } else if (!isFoundMinuend1[1] && isFoundMinuend2) {
                return sum - minuend2;
            } else if (isFoundMinuend1[1]) {
                return sum - Math.min(minuend1, minuend2);
            } else {
                return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

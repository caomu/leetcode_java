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
// 👍 770 👎 0


public class _560_SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new _560_SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int result = 0;
            int[] sum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (i > 0) {
                        sum[j] -= nums[i - 1];
                    } else {
                        sum[j] = (j > 0 ? sum[j - 1] : 0) + nums[j];
                    }
                    if (sum[j] == k) {
                        result++;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
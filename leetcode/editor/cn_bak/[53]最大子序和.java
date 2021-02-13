//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2824 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        return this.division(nums, 0, nums.length - 1)[2];
    }

    /**
     * @param nums
     * @param i
     * @param j
     * @return 0:lSum 表示 [l,r] 内以 l 为左端点的最大子段和
     * 1:rSum 表示 [l,r] 内以 r 为右端点的最大子段和
     * 2:mSum 表示 [l,r] 内的最大子段和
     * 3:iSum 表示 [l,r] 的区间和
     */
    private int[] division(int[] nums, int i, int j) {
        if (i == j) {
            return new int[]{nums[i], nums[i], nums[i], nums[i]};
        }
        int m = (i + j) >> 1;
        int[] lDiv = this.division(nums, i, m);
        int[] rDiv = this.division(nums, m + 1, j);
        int[] res = new int[4];
        res[0] = Math.max(lDiv[0], lDiv[3] + rDiv[0]);
        res[1] = Math.max(rDiv[1], rDiv[3] + lDiv[1]);
        res[2] = Math.max(Math.max(lDiv[2], rDiv[2]), lDiv[1] + rDiv[0]);
        res[3] = lDiv[3] + rDiv[3];
//        System.out.println("i:" + i + ",j:" + j + "," + Arrays.toString(res));
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

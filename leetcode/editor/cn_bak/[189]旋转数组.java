//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 759 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2 || k % nums.length == 0) {
            return;
        }
        int endIndex = nums.length - 1;
        reverse(nums, 0, endIndex);
//        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, (k - 1) % nums.length);
//        System.out.println(Arrays.toString(nums));
        reverse(nums, k % nums.length, endIndex);
//        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int s, int e) {
        for (int i = 0; i < (e - s + 1) / 2; i++) {
            int t = nums[s + i];
            nums[s + i] = nums[e - i];
            nums[e - i] = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

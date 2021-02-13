//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 867 👎 0


public class _169_MajorityElement {
    public static void main(String[] args) {
        Solution solution = new _169_MajorityElement().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            return this.majorityElement(nums, 0, nums.length - 1);
        }

        private int majorityElement(int[] nums, int p, int q) {
            if (p == q) {
                return nums[p];
            }
            int m = (p + q) >> 1;
            int left = this.majorityElement(nums, p, m);
            int right = this.majorityElement(nums, m + 1, q);
            if (left == right) {
                return left;
            }
            int cntLeft = 0;
            int cntRight = 0;
            for (int i = p; i <= q; i++) {
                if (nums[i] == left) {
                    cntLeft++;
                } else if (nums[i] == right) {
                    cntRight++;
                }
            }
            return cntLeft > cntRight ? left : right;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
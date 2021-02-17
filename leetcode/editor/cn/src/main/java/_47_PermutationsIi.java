//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 591 👎 0


import java.util.*;

public class _47_PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new _47_PermutationsIi().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Set<List<Integer>> permutes = new HashSet<>();
            this.permute(nums, new int[nums.length], permutes, new ArrayList<>());
            return new ArrayList<>(permutes);
        }

        private void permute(int[] nums, int[] used, Set<List<Integer>> permutes, List<Integer> permute) {
            boolean isAllUsed = true;
            for (int i = 0; i < used.length; i++) {
                if (used[i] > 0) {
                    continue;
                }
                isAllUsed = false;
                List<Integer> newPermute = new ArrayList<>(permute);
                newPermute.add(nums[i]);
                int[] newUsed = Arrays.copyOfRange(used, 0, used.length);
                newUsed[i] = 1;
                this.permute(nums, newUsed, permutes, newPermute);
            }
            if (isAllUsed) {
                permutes.add(permute);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
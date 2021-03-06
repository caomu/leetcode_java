//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1131 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46_Permutations {
    public static void main(String[] args) {
        Solution solution = new _46_Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> permutes = new ArrayList<>();
            this.permute(nums, new int[nums.length], permutes, new ArrayList<>());
            return permutes;
        }

        private void permute(int[] nums, int[] used, List<List<Integer>> permutes, List<Integer> permute) {
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
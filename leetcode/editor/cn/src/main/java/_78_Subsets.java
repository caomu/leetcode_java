//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 996 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _78_Subsets {
    public static void main(String[] args) {
        Solution solution = new _78_Subsets().new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            this.backtrack(nums, new LinkedList<>(), 0, subsets);
            return subsets;
        }

        private void backtrack(int[] nums, Deque<Integer> path, int begin, List<List<Integer>> subsets) {
            subsets.add(new ArrayList<>(path));

            for (int i = begin; i < nums.length; i++) {
                path.addLast(nums[i]);
//                System.out.println(
//                        "递归之前 => begin:" + begin + ",i:" + i + "\t" + path);
                this.backtrack(nums, path, i + 1, subsets);
                path.removeLast();
//                System.out.println(
//                        "递归之后 => begin:" + begin + ",i:" + i + "\t" + path);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
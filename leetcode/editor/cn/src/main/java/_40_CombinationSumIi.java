//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 491 👎 0


import java.util.*;

public class _40_CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new _40_CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            this.backtrack(candidates, target, 0, new ArrayDeque<>(), 0, res);
            return res;
        }

        private void backtrack(int[] candidates, int target, int sum, Deque<Integer> path, int begin, List<List<Integer>> res) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (sum > target) {
                return;
            }

            for (int i = begin; i < candidates.length; i++) {
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.addLast(candidates[i]);
//                System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

                this.backtrack(candidates, target, sum + candidates[i], path, i + 1, res);
                path.removeLast();
//                System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
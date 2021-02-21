//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 499 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class _77_Combinations {
    public static void main(String[] args) {
        Solution solution = new _77_Combinations().new Solution();
        System.out.println(solution.combine(1, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            this.backtrack(IntStream.rangeClosed(1, n).toArray(), k, new LinkedList<>(), 0, result);
            return result;
        }

        private void backtrack(int[] nums, int len, Deque<Integer> path, int begin, List<List<Integer>> res) {
            if (path.size() == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = begin; i < nums.length; i++) {
                if (!path.isEmpty() && nums[i] <= path.peekLast()) {
                    continue;
                }
                path.addLast(nums[i]);
//                System.out.println("递归之前 => " + path);
                this.backtrack(nums, len, path, begin + 1, res);
                path.removeLast();
//                System.out.println("递归之后 => " + path);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
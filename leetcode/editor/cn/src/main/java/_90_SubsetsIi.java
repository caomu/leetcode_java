//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 393 👎 0


import java.util.*;
import java.util.logging.Logger;

public class _90_SubsetsIi {

    private static final Logger logger = Logger.getLogger(_90_SubsetsIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _90_SubsetsIi().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.subsetsWithDup(new int[]{1, 2, 2})));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            this.subsetsWithDup(nums, new LinkedList<>(), 0, result);
            return result;
        }

        private void subsetsWithDup(int[] nums, Deque<Integer> path, int begin, List<List<Integer>> res) {
            res.add(new ArrayList<>(path));

            for (int i = begin; i < nums.length; i++) {
                if (i > begin && nums[i] == nums[i - 1]) {
                    continue;
                }
                path.addLast(nums[i]);
//                System.out.println("递归之前 => " + path);
                this.subsetsWithDup(nums, path, i + 1, res);
                // 只能用一次 backtrack(nums, depth + 1, path, i + 1, res);
                path.removeLast();
//                System.out.println("递归之后 => " + path);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

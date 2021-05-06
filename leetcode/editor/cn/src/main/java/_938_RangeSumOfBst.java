//给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
//
//
//
// 示例 1：
//
//
//输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
//输出：32
//
//
// 示例 2：
//
//
//输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
//输出：23
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 2 * 104] 内
// 1 <= Node.val <= 105
// 1 <= low <= high <= 105
// 所有 Node.val 互不相同
//
// Related Topics 树 深度优先搜索 递归
// 👍 175 👎 0


import com.caomu.util.TreeNode;
import com.caomu.util.TreeNodeUtils;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-27 08:21:05
 */
public class _938_RangeSumOfBst {

    private static final Logger logger = Logger.getLogger(_938_RangeSumOfBst.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-27 08:21:05").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _938_RangeSumOfBst().new Solution();

        assert solution.rangeSumBST(TreeNodeUtils.stringToTreeNode("[10,5,15,3,7,null,18]"), 7, 15) == 32;
        assert solution.rangeSumBST(TreeNodeUtils.stringToTreeNode("[10,5,15,3,7,13,18,1,null,6]"), 6, 10) == 23;
        // logger.log(Level.WARNING, solution);

        logger.log(Level.INFO, "time cost: [{0}] ms", (System.currentTimeMillis() - startTimeMillis));
        logger.log(Level.INFO, "solution cost: [{0}]", Duration.ofSeconds(
                (System.currentTimeMillis() - START_TIMESTAMP) / 1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int rangeSumBST(TreeNode node, int low, int high) {
            var sum = 0;
            if (node != null && node.val < low) {
                sum += this.rangeSumBST(node.right, low, high);
            } else if (node != null && node.val > high) {
                sum += this.rangeSumBST(node.left, low, high);
            } else if (node != null) {
                sum += node.val + this.rangeSumBST(node.right, low, high) + this.rangeSumBST(node.left, low, high);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

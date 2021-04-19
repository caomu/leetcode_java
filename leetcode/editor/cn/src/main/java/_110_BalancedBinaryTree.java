//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索 递归
// 👍 670 👎 0


import com.caomu.util.TreeNode;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * create time: 2021-04-19 13:18:08
 */
public class _110_BalancedBinaryTree {

    private static final Logger logger = Logger.getLogger(_110_BalancedBinaryTree.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-19 13:18:08").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _110_BalancedBinaryTree().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
        logger.info("solution cost: [" +
                    Duration.ofSeconds((System.currentTimeMillis() - startTimestamp) / 1000).toString() + "]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return this.isBalanced(root, 0);
        }

        private boolean isBalanced(TreeNode node, int height) {
            if (node == null) {
                return true;
            }
            return this.isBalanced(node.left, height) && this.isBalanced(node.right, height) &&
                   Math.abs(this.calcHeight(node.left, height) - this.calcHeight(node.right, height)) <= 1;
        }

        private int calcHeight(TreeNode node, int height) {
            if (node == null) {
                return height - 1;
            }
            return Math.max(this.calcHeight(node.left, height + 1), this.calcHeight(node.right, height + 1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

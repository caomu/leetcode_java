//给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
//
//
//
// 示例 1：
//
//
//输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
//
// 示例 2：
//
//
//输入：root = [5,1,7]
//输出：[1,null,5,null,7]
//
//
//
//
// 提示：
//
//
// 树中节点数的取值范围是 [1, 100]
// 0 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索 递归
// 👍 170 👎 0


import com.caomu.util.TreeNode;
import com.caomu.util.TreeNodeUtils;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create time: 2021-04-25 11:11:05
 */
public class _897_IncreasingOrderSearchTree {

    private static final Logger logger = Logger.getLogger(_897_IncreasingOrderSearchTree.class.toString());
    private static final long START_TIMESTAMP = Timestamp.valueOf("2021-04-25 11:11:05").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _897_IncreasingOrderSearchTree().new Solution();

//        assert solution == null;
        TreeNodeUtils.prettyPrintTree(solution.increasingBST(TreeNodeUtils.stringToTreeNode("[5,3,6,2,4,null,8,1,null,null,null,7,9]")));
        TreeNodeUtils.prettyPrintTree(solution.increasingBST(TreeNodeUtils.stringToTreeNode("[5,1,7]")));

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
        TreeNode newNode = null;

        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            this.newNode = new TreeNode(0);
            TreeNode newRoot = this.newNode;
            this.inOrderTraversal(root);
            return newRoot.right;
        }

        private void inOrderTraversal(TreeNode node) {
            if (node == null) {
                return;
            }
            this.inOrderTraversal(node.left);
            this.newNode.right = new TreeNode(node.val);
            this.newNode = this.newNode.right;
            this.inOrderTraversal(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
//
// 例如，
//
//
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
//
//
// 你应该返回如下子树:
//
//
//      2
//     / \
//    1   3
//
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
// Related Topics 树
// 👍 123 👎 0


import com.caomu.util.TreeNode;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * create time: 2021-04-19 13:08:18
 */
public class _700_SearchInABinarySearchTree {

    private static final Logger logger = Logger.getLogger(_700_SearchInABinarySearchTree.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-19 13:08:18").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _700_SearchInABinarySearchTree().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
        logger.info("solution cost: [" +
                    Duration.ofSeconds((System.currentTimeMillis() - startTimestamp) / 1000).toString() + "]");
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
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            } else if (root.val == val) {
                return root;
            } else if (val > root.val) {
                return this.searchBST(root.right, val);
            } else {
                return this.searchBST(root.left, val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

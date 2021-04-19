//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
//示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
//
//
//
// 限制：
//
//
// 0 <= 树的结点个数 <= 10000
//
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
//
//
// Related Topics 树 深度优先搜索
// 👍 140 👎 0


import com.caomu.util.TreeNode;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * create time: 2021-04-19 13:28:51
 */
public class _JZ_Offer_55_II_PingHengErChaShuLcof {

    private static final Logger logger = Logger.getLogger(_JZ_Offer_55_II_PingHengErChaShuLcof.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-19 13:28:51").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _JZ_Offer_55_II_PingHengErChaShuLcof().new Solution();

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
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return this.calcHeight(root) >= 0;
        }

        private int calcHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int rightHeight = this.calcHeight(node.right);
            int leftHeight = this.calcHeight(node.left);
            if (rightHeight == -1 || leftHeight == -1 || Math.abs(rightHeight - leftHeight) > 1) {
                return -1;
            }
            return Math.max(rightHeight, leftHeight) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

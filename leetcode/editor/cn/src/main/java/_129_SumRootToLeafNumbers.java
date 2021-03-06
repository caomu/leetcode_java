//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
// 计算从根到叶子节点生成的所有数字之和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例 1:
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25.
//
// 示例 2:
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026.
// Related Topics 树 深度优先搜索
// 👍 324 👎 0


import com.caomu.util.TreeNode;

import java.util.logging.Logger;

public class _129_SumRootToLeafNumbers {

    private static final Logger logger = Logger.getLogger(_129_SumRootToLeafNumbers.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _129_SumRootToLeafNumbers().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
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
        public int sumNumbers(TreeNode root) {
            return this.sumNumbers(root, 0, 0);
        }

        private int sumNumbers(TreeNode node, int sum, int path) {
            int curPath = path * 10 + node.val;
            if (node.right == null && node.left == null) {
                return sum + curPath;
            }
            return (node.right != null ? this.sumNumbers(node.right, sum, curPath) : 0) +
                   (node.left != null ? this.sumNumbers(node.left, sum, curPath) : 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

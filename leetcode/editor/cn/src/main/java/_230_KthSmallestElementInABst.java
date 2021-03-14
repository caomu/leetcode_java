//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,1,4,null,2], k = 1
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
//
//
//
//
//
//
// 提示：
//
//
// 树中的节点数为 n 。
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
//
//
//
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
// Related Topics 树 二分查找
// 👍 364 👎 0


import com.caomu.util.TreeNode;
import com.caomu.util.TreeNodeUtils;

import java.util.logging.Logger;

/**
 * create time: 2021-03-14 15:19:39
 */
public class _230_KthSmallestElementInABst {

    private static final Logger logger = Logger.getLogger(_230_KthSmallestElementInABst.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _230_KthSmallestElementInABst().new Solution();

        assert solution.kthSmallest(TreeNodeUtils.stringToTreeNode("[3,1,4,null,2]"), 1) == 1;
        assert solution.kthSmallest(TreeNodeUtils.stringToTreeNode("[5,3,6,2,4,null,null,1]"), 3) == 3;
//        logger.warning(String.valueOf(solution));

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
        public int kthSmallest(TreeNode root, int k) {
            return this.inOrderTraversal(root, new int[1], k);
        }

        private Integer inOrderTraversal(TreeNode node, int[] index, int k) {
            if (node == null) {
                return null;
            }
            Integer left = this.inOrderTraversal(node.left, index, k);
            if (left != null) {
                return left;
            }
            index[0]++;
            if (index[0] == k) {
                return node.val;
            }
            return this.inOrderTraversal(node.right, index, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

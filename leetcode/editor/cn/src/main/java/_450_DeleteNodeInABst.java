//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。
//
// 一般来说，删除节点可分为两个步骤：
//
//
// 首先找到需要删除的节点；
// 如果找到了，删除它。
//
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
//
// 示例:
//
//
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
//
// Related Topics 树
// 👍 433 👎 0


import com.caomu.util.TreeNode;
import com.caomu.util.TreeNodeUtils;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * create time: 2021-04-19 13:46:28
 */
public class _450_DeleteNodeInABst {

    private static final Logger logger = Logger.getLogger(_450_DeleteNodeInABst.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-19 13:46:28").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _450_DeleteNodeInABst().new Solution();

//        TreeNodeUtils.prettyPrintTree(solution.deleteNode(TreeNodeUtils.stringToTreeNode("[5,3,6,2,4,null,7]"), 3));
//        TreeNodeUtils.prettyPrintTree(solution.deleteNode(TreeNodeUtils.stringToTreeNode("[0]"), 0));
//        String tree = "[5,3,6,2,4,null,7]";
//        TreeNodeUtils.prettyPrintTree(TreeNodeUtils.stringToTreeNode(tree));
//        TreeNodeUtils.prettyPrintTree(solution.deleteNode(TreeNodeUtils.stringToTreeNode(tree), 5));
        String tree = "[2,0,33,null,1,25,40,null,null,11,31,34,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,35,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6]";
        TreeNodeUtils.prettyPrintTree(TreeNodeUtils.stringToTreeNode(tree));
        TreeNodeUtils.prettyPrintTree(solution.deleteNode(TreeNodeUtils.stringToTreeNode(tree), 33));

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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root != null) {
                root = this._deleteNode(root, null, true, root, key);
            }
            return root;
        }

        private TreeNode _deleteNode(TreeNode root, TreeNode father, boolean isRight, TreeNode node, int key) {
            if (node == null) {
                return null;
            }
            if (node.val == key) {
                if (node.left == null && node.right == null && isRight) {
                    if (father == null) {
                        return null;
                    } else {
                        father.right = null;
                        return root;
                    }
                } else if (node.left == null && node.right == null) {
                    if (father == null) {
                        return null;
                    } else {
                        father.left = null;
                        return root;
                    }
                } else if (node.left == null && isRight) {
                    if (father == null) {
                        return node.right;
                    } else {
                        father.right = node.right;
                        return root;
                    }
                } else if (node.left == null) {
                    if (father == null) {
                        return node.right;
                    } else {
                        father.left = node.right;
                        return root;
                    }
                } else if (node.right == null && isRight) {
                    if (father == null) {
                        return node.left;
                    } else {
                        father.right = node.left;
                        return root;
                    }
                } else if (node.right == null) {
                    if (father == null) {
                        return node.left;
                    } else {
                        father.left = node.left;
                        return root;
                    }
                } else {
                    TreeNode leftMost = this.successorLeftMost(node, true, node.right);
                    leftMost.right = node.right;
                    leftMost.left = node.left;
                    if (father == null) {
                        return leftMost;
                    } else if (isRight) {
                        father.right = leftMost;
                    } else {
                        father.left = leftMost;
                    }
                    return root;
                }
            } else if (node.val < key) {
                this._deleteNode(root, node, true, node.right, key);
                return root;
            } else {
                this._deleteNode(root, node, false, node.left, key);
                return root;
            }
        }

        private TreeNode successorLeftMost(TreeNode father, boolean isRight, TreeNode node) {
            if (node.left == null) {
                if (isRight) {
                    father.right = node.right;
                } else {
                    father.left = node.right;
                }
                return node;
            }
            return this.successorLeftMost(node, false, node.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

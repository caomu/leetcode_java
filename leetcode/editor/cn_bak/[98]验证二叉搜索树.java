//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 895 👎 0


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
    public boolean isValidBST(TreeNode root) {
        return this.recursion(root, null, null);
    }

    private boolean recursion(TreeNode root, Integer lower, Integer upper) {
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean isSelf =
                (root.left == null || (root.left.val < root.val && this.checkRange(root.left.val, lower, upper)))
                &&
                (root.right == null || (root.val < root.right.val && this.checkRange(root.right.val, lower, upper)));
        if (!isSelf) {
            return false;
        }
        return (root.left == null || this.recursion(root.left, lower, root.val)) &&
               (root.right == null || this.recursion(root.right, root.val, upper));
    }

    private boolean checkRange(int value, Integer lower, Integer supper) {
        return (lower == null || value > lower) && (supper == null || value < supper);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

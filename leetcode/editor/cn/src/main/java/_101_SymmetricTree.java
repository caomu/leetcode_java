//给定一个二叉树，检查它是否是镜像对称的。
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1233 👎 0


import com.caomu.util.TreeNode;

public class _101_SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new _101_SymmetricTree().new Solution();
        System.out.println(solution);
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            if ((root.right != null && root.left != null) || (root.right == null && root.left == null)) {
                return this.isSymmetric(root.left, root.right);
            } else {
                return false;
            }
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left == null || right == null || left.val != right.val) {
                //(left != null && right == null) || (left == null && right != null)
                return false;
            }
            return this.isSymmetric(left.right, right.left) && this.isSymmetric(left.left, right.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
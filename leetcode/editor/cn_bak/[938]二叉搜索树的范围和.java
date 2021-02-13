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
// 👍 156 👎 0


public class RangeSumOfBst {
    public static void main(String[] args) {
        Solution solution = new RangeSumOfBst().new Solution();
        System.out.println(solution.rangeSumBST(TreeNodeUtil.arrayToTreeNode("[10,5,15,3,7,null,18]"), 7, 15));
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
        public int rangeSumBST(TreeNode root, int low, int high) {
            // recursion terminator
            if (root == null) {
                return 0;
            }
            // process current layer

            // dig into lower layer
            int lVal = this.rangeSumBST(root.left, low, high);
            int rVal = this.rangeSumBST(root.right, low, high);

            // clean current layer
            if (root.val > high) {
                if (root.left != null && root.left.val <= high) {
                    System.out.println("root.val:" + root.val + ",lVal:" + lVal);
                    return lVal;
                }
                return 0;
            } else if (root.val >= low) {
                //root.val <= high
                System.out.println(
                        "root.val:" + root.val + ",lVal:" + lVal + ",rVal:" + rVal + ",sum:" +
                        (root.val + rVal + lVal));
                return root.val + rVal + lVal;
            } else {
                //root.val < low
                if (root.right != null && root.right.val >= low) {
                    System.out.println("root.val:" + root.val + ",rVal:" + rVal);
                    return rVal;
                }
                return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
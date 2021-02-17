//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 440 👎 0


import com.caomu.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _257_BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new _257_BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> routines = new ArrayList<>();
            this.binaryTreePaths(root, new StringBuilder(), routines);
            return routines;
        }

        private void binaryTreePaths(TreeNode node, StringBuilder curRoutines, List<String> routines) {
            if (node == null) {
                return;
            }
            if (node.right == null && node.left == null) {
                routines.add(curRoutines.append(node.val).toString());
                return;
            }
            curRoutines.append(node.val).append("->");
            this.binaryTreePaths(node.left, new StringBuilder(curRoutines), routines);
            this.binaryTreePaths(node.right, curRoutines, routines);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
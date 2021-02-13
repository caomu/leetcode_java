//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
// node.val 的值之和。 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 示例 3： 
//
// 输入：root = [1,0,2]
//输出：[3,3,2]
// 
//
// 示例 4： 
//
// 输入：root = [3,2,4,1]
//输出：[7,9,4,10]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 0 和 104 之间。 
// 每个节点的值介于 -104 和 104 之间。 
// 树中的所有值 互不相同 。 
// 给定的树为二叉搜索树。 
// 
// Related Topics 树 
// 👍 459 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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

//
//    @Override
//    public String toString() {
//        return "TreeNode{val=" + this.val + '}';
//    }


class Solution {
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> traversal = this.traversal(root);
//        System.out.println(traversal);
        for (int i = 1; i < traversal.size(); i++) {
            traversal.get(i).val += traversal.get(i - 1).val;
        }
        return root;
    }

    /**
     * 递归遍历
     */
    private List<TreeNode> traversal(TreeNode node) {
        if (node == null) { //如果结点为空则返回
            return new ArrayList<>();
        }
        List<TreeNode> traversal = new ArrayList<>(this.traversal(node.right));//访问右孩子
        traversal.add(node);//访问根节点
        traversal.addAll(this.traversal(node.left));//访问左孩子
        return traversal;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

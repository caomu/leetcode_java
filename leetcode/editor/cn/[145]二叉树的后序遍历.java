//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 508 👎 0


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
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        this.postOrderTraversal(root, res);
        return res;
    }

    /**
     * 递归后序遍历
     */
    private void postOrderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) {//如果结点为空则返回
            return;
        }
        this.postOrderTraversal(node.left, res);//访问左孩子
        this.postOrderTraversal(node.right, res);//访问右孩子
        res.add(node.val);//访问根节点
    }
}
//leetcode submit region end(Prohibit modification and deletion)

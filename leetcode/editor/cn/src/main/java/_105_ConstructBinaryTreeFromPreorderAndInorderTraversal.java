//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 870 👎 0


import com.caomu.util.TreeNode;
import com.caomu.util.Utils;

public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new _105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        System.out.println(solution.buildTree(Utils.stringToArray("[1,2]"), Utils.stringToArray("[2,1]")));
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return preorder.length == 0 ? null : this.buildTree(preorder, 0,
                    preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
            if (preL > preR || inL > inR) {
                return null;
            }
            TreeNode node = new TreeNode(preorder[preL]);
            if (preL == preR) {
                return node;
            }
            int idx = -1;
            for (int i = inL; i <= inR; i++) {
                if (inorder[i] == preorder[preL]) {
                    idx = i;
                    break;
                }
            }
            node.left = this.buildTree(preorder,
                    preL + 1, preL + idx - inL, inorder, inL, idx - 1);
            node.right = this.buildTree(preorder,
                    preR + idx - inR + 1, preR, inorder, idx + 1, inR);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
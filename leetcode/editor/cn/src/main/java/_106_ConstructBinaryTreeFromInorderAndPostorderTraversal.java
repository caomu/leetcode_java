//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 449 👎 0


import com.caomu.util.TreeNode;
import com.caomu.util.TreeNodeUtils;

import java.util.logging.Logger;

public class _106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private static final Logger logger = Logger.getLogger(_106_ConstructBinaryTreeFromInorderAndPostorderTraversal.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();

        // assert solution == ;
        TreeNodeUtils.prettyPrintTree(solution.buildTree(new int[]{9, 3, 15, 20, 7},
                new int[]{9, 15, 7, 20, 3}));
        TreeNodeUtils.prettyPrintTree(solution.buildTree(new int[]{-1},
                new int[]{-1}));

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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return this.buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode buildTree(int[] inorder, int i, int j, int[] postorder, int p, int q) {
            if (i > j || p > q || p < 0 || i < 0 || q >= postorder.length || j >= inorder.length) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[q]);
            int rootIndexInInorder = 0;
            for (int k = i; k <= j; k++) {
                if (inorder[k] == postorder[q]) {
                    rootIndexInInorder = k;
                    break;
                }
            }
            root.left = this.buildTree(inorder, i,
                    rootIndexInInorder - 1, postorder, p, p + rootIndexInInorder - i - 1);
            root.right = this.buildTree(inorder,
                    rootIndexInInorder + 1, j, postorder, p + rootIndexInInorder - i, q - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

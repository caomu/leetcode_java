//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
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
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 297 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return preorder.length == 0 ? null : this.buildTree(preorder, 0,
                preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pI, int pJ, int[] inorder, int iI, int iJ) {
        if (pI > pJ || iI > iJ) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pI]);
        if (iI == iJ) {
            return node;
        }
        int rootIdx = -1;
        for (int i = iI; i <= iJ; i++) {
            if (inorder[i] == preorder[pI]) {
                rootIdx = i;
                break;
            }
        }
//        System.out.print(
//                "\nrootIdx:" + rootIdx + "[" + inorder[rootIdx] + "]\tlPreorder[" + (pI + 1) + "," +
//                (pI + rootIdx - iI) + "]:");
//        for (int i = pI + 1; i <= pI + rootIdx - iI; i++) {
//            System.out.print(preorder[i] + ", ");
//        }
//        System.out.print("\nrPreorder[" + (pJ + rootIdx - iJ + 1) + "," + pJ + "]:");
//        for (int i = pJ + rootIdx - iJ + 1; i <= pJ; i++) {
//            System.out.print(preorder[i] + ", ");
//        }
//        System.out.print("\nlInorder[" + iI + "," + (rootIdx - 1) + "]:");
//        for (int i = iI; i <= rootIdx - 1; i++) {
//            System.out.print(inorder[i] + ", ");
//        }
//        System.out.print("\nrInorder[" + (rootIdx + 1) + "," + iJ + "]:");
//        for (int i = rootIdx + 1; i <= iJ; i++) {
//            System.out.print(inorder[i] + ", ");
//        }
        node.left = this.buildTree(preorder,
                pI + 1, pI + rootIdx - iI, inorder, iI, rootIdx - 1);
        node.right = this.buildTree(preorder,
                pJ + rootIdx - iJ + 1, pJ, inorder, rootIdx + 1, iJ);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
//
// (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right
// 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）
//
// 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
//
//
//
// 示例：
//
// 输入：[8,5,1,7,10,12]
//输出：[8,5,10,1,7,null,12]
//
//
//
//
//
// 提示：
//
//
// 1 <= preorder.length <= 100
// 1 <= preorder[i] <= 10^8
// preorder 中的值互不相同
//
// Related Topics 树
// 👍 134 👎 0


import com.caomu.util.TreeNode;
import com.caomu.util.TreeNodeUtils;

import java.util.logging.Logger;

public class _1008_ConstructBinarySearchTreeFromPreorderTraversal {

    private static final Logger logger = Logger.getLogger(_1008_ConstructBinarySearchTreeFromPreorderTraversal.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _1008_ConstructBinarySearchTreeFromPreorderTraversal().new Solution();

        TreeNodeUtils.prettyPrintTree(solution.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
//        TreeNodeUtils.prettyPrintTree(solution.bstFromPreorder(new int[]{4, 2}));
//        TreeNodeUtils.prettyPrintTree(solution.bstFromPreorder(new int[]{4, 1, 3, 6}));

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
        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder.length == 0) {
                return null;
            }
            return this.bstFromPreorder(preorder, 0, preorder.length - 1);
        }

        private TreeNode bstFromPreorder(int[] preorder, int begin, int end) {
            if (begin > end || begin < 0) {
                return null;
            }
            TreeNode node = new TreeNode(preorder[begin]);
            if (end == begin) {
                return node;
            }
            int rightBegin = end + 1;
            for (int i = begin + 1; i <= end; i++) {
                if (preorder[i] > preorder[begin]) {
                    rightBegin = i;
                    break;
                }
            }
            node.left = this.bstFromPreorder(preorder, begin + 1, rightBegin - 1);
            node.right = this.bstFromPreorder(preorder, rightBegin, end);

            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

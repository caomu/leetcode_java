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


public class _938_RangeSumOfBst {
    public static void main(String[] args) {
        Solution solution = new _938_RangeSumOfBst().new Solution();
        System.out.println(solution.rangeSumBST(TreeNodeUtil.arrayToTreeNode("[182,107,257,68,146,221,296,50,89,128,164,203,239,278,314,41,59,80,98,119,137,155,173,194,212,230,248,269,287,305,323,35,47,56,65,74,86,95,104,113,125,134,143,152,161,170,179,188,200,209,218,227,236,245,254,263,275,284,293,302,311,320,329,32,38,44,null,53,null,62,null,71,77,83,null,92,null,101,null,110,116,122,null,131,null,140,null,149,null,158,null,167,null,176,null,185,191,197,null,206,null,215,null,224,null,233,null,242,null,251,null,260,266,272,null,281,null,290,null,299,null,308,null,317,null,326]"), 86, 224));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
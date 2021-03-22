//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
//
//
//
// 示例：
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//
//
//
// 提示：
//
//
// 0 <= n <= 8
//
// Related Topics 树 动态规划
// 👍 816 👎 0


import com.caomu.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * create time: 2021-03-19 21:43:11
 */
public class _95_UniqueBinarySearchTreesIi {

    private static final Logger logger = Logger.getLogger(_95_UniqueBinarySearchTreesIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _95_UniqueBinarySearchTreesIi().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution.generateTrees(3)));

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
        public List<TreeNode> generateTrees(int n) {
            return this.generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int m, int n) {
            List<TreeNode> trees = new ArrayList<>();
            if (m == n) {
                trees.add(new TreeNode(n));
                return trees;
            }

            for (int i = m; i <= n - 2 && (n - m > 1); i++) {
                for (TreeNode left : this.generateTrees(m, i)) {
                    for (TreeNode right : this.generateTrees(i + 2, n)) {
                        TreeNode root = new TreeNode(i + 1);
                        root.right = right;
                        root.left = left;
                        trees.add(root);
                    }
                }
            }
            for (TreeNode right : this.generateTrees(m + 1, n)) {
                TreeNode root = new TreeNode(m);
                root.right = right;
                trees.add(root);
            }

            for (TreeNode left : this.generateTrees(m, n - 1)) {
                TreeNode root = new TreeNode(n);
                root.left = left;
                trees.add(root);
            }
            return trees;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

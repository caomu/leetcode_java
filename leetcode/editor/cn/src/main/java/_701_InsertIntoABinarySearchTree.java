//给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值
//都不同。
//
// 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
//
//
//
// 示例 1：
//
//
//输入：root = [4,2,7,1,3], val = 5
//输出：[4,2,7,1,3,5]
//解释：另一个满足题目要求可以通过的树是：
//
//
//
// 示例 2：
//
//
//输入：root = [40,20,60,10,30,50,70], val = 25
//输出：[40,20,60,10,30,50,70,null,null,25]
//
//
// 示例 3：
//
//
//输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
//输出：[4,2,7,1,3,5]
//
//
//
//
//
//
// 提示：
//
//
// 给定的树上的节点数介于 0 和 10^4 之间
// 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
// -10^8 <= val <= 10^8
// 新值和原始二叉搜索树中的任意节点值都不同
//
// Related Topics 树
// 👍 177 👎 0


import com.caomu.util.TreeNode;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * create time: 2021-04-19 13:35:05
 */
public class _701_InsertIntoABinarySearchTree {

    private static final Logger logger = Logger.getLogger(_701_InsertIntoABinarySearchTree.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-19 13:35:05").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _701_InsertIntoABinarySearchTree().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
        logger.info("solution cost: [" +
                    Duration.ofSeconds((System.currentTimeMillis() - startTimestamp) / 1000).toString() + "]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            this._insertIntoBST(root, val);
            return root;
        }

        private void _insertIntoBST(TreeNode node, int val) {
            if (node == null) {
                return;
            }
            if (val > node.val && node.right == null) {
                node.right = new TreeNode(val);
            } else if (val > node.val) {
                // node.right != null
                this._insertIntoBST(node.right, val);
            } else if (val < node.val && node.left == null) {
                node.left = new TreeNode(val);
            } else if (val < node.val) {
                // node.left != null
                this._insertIntoBST(node.left, val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

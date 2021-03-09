//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
//
//
//
// 示例 1：
//
//
//
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
//
//
// 示例 2：
//
//
//
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
//
//
// 示例 3：
//
//
//
//
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false
//
//
//
// 提示：
//
//
// 二叉树的节点数介于 2 到 100 之间。
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。
//
//
//
// Related Topics 树 广度优先搜索
// 👍 121 👎 0


import com.caomu.util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * create time: 2021-03-08 23:35:17
 */
public class _993_CousinsInBinaryTree {

    private static final Logger logger = Logger.getLogger(_993_CousinsInBinaryTree.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _993_CousinsInBinaryTree().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

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
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) {
                return false;
            }
            Queue<TreeNode> q = new LinkedList<>(); // 核心数据结构
            q.offer(root); // 将起点加入队列

            Map<Integer, Integer> parentMap = new HashMap<>();
            while (!q.isEmpty()) {
                parentMap.clear();
                int width = q.size();
                for (int i = 0; i < width; i++) {
                    TreeNode cur = q.poll();
                    if (cur.left != null) {
                        parentMap.put(cur.left.val, cur.val);
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        parentMap.put(cur.right.val, cur.val);
                        q.offer(cur.right);
                    }
                }
                if (parentMap.containsKey(x) && parentMap.containsKey(y) &&
                    !parentMap.get(x).equals(parentMap.get(y))) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//
//
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/
// Related Topics 树 广度优先搜索
// 👍 85 👎 0


import com.caomu.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * create time: 2021-03-08 23:05:38
 */
public class _JZ_Offer_32_II_CongShangDaoXiaDaYinErChaShuIiLcof {

    private static final Logger logger = Logger.getLogger(_JZ_Offer_32_II_CongShangDaoXiaDaYinErChaShuIiLcof.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _JZ_Offer_32_II_CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();

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
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> levelOrder = new ArrayList<>();
            LinkedList<TreeNode> q = new LinkedList<>(); // 核心数据结构
            q.offer(root); // 将起点加入队列
            while (!q.isEmpty()) {
                int width = q.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < width; i++) {
                    TreeNode cur = q.poll();
                    level.add(cur.val);
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                levelOrder.add(level);
            }
            return levelOrder;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

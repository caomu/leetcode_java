//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
//  [20,9],
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
// Related Topics 树 广度优先搜索
// 👍 77 👎 0


import com.caomu.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * create time: 2021-03-08 23:03:46
 */
public class _JZ_Offer_32_III_CongShangDaoXiaDaYinErChaShuIiiLcof {

    private static final Logger logger = Logger.getLogger(_JZ_Offer_32_III_CongShangDaoXiaDaYinErChaShuIiiLcof.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _JZ_Offer_32_III_CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();

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
            List<List<Integer>> zigzagLevelOrder = new ArrayList<>();
            LinkedList<TreeNode> q = new LinkedList<>(); // 核心数据结构

            q.offer(root); // 将起点加入队列
            int step = 1; // 记录扩散的步数

            while (!q.isEmpty()) {
                /* 将当前队列中的所有节点向四周扩散 */
                int width = q.size();
                List<Integer> zigzagLevel = new ArrayList<>();
                for (int i = 0; i < width; i++) {
                    TreeNode cur = q.poll();
                    zigzagLevel.add(cur.val);
                    /* 将 cur 的相邻节点加入队列 */
                    if ((step & 1) == 0) {
                        if (cur.right != null) {
                            q.offer(cur.right);
                        }
                        if (cur.left != null) {
                            q.offer(cur.left);
                        }
                    } else {
                        if (cur.left != null) {
                            q.offer(cur.left);
                        }
                        if (cur.right != null) {
                            q.offer(cur.right);
                        }
                    }
                }
                /* 划重点：更新步数在这里 */
                step++;
                Collections.reverse(q);
                if (!zigzagLevel.isEmpty()) {
                    zigzagLevelOrder.add(zigzagLevel);
                }
            }
            return zigzagLevelOrder;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

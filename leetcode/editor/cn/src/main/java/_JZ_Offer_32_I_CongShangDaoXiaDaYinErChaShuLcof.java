//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
// 返回：
//
// [3,9,20,15,7]
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
// 👍 63 👎 0


import com.caomu.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * create time: 2021-03-08 22:51:20
 */
public class _JZ_Offer_32_I_CongShangDaoXiaDaYinErChaShuLcof {

    private static final Logger logger = Logger.getLogger(_JZ_Offer_32_I_CongShangDaoXiaDaYinErChaShuLcof.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _JZ_Offer_32_I_CongShangDaoXiaDaYinErChaShuLcof().new Solution();

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
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            List<Integer> levelOrder = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>(); // 核心数据结构
            q.offer(root); // 将起点加入队列

            while (!q.isEmpty()) {
                int width = q.size();
                for (int i = 0; i < width; i++) {
                    TreeNode cur = q.poll();
                    levelOrder.add(cur.val);
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
            }
            int[] levelOrderArray = new int[levelOrder.size()];
            for (int i = 0; i < levelOrder.size(); i++) {
                levelOrderArray[i] = levelOrder.get(i);
            }
            return levelOrderArray;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

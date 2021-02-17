//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 388 👎 0


import com.caomu.util.TreeNode;
import com.caomu.util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new _103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
        System.out.println(solution.zigzagLevelOrder(Utils.arrayToTreeNode("[1,2,3,4,null,null,5]")));
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
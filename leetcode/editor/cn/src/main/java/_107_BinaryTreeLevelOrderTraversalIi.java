//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
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
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 402 👎 0


import com.caomu.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new _107_BinaryTreeLevelOrderTraversalIi().new Solution();
        System.out.println(solution);
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<List<Integer>> order = new LinkedList<>();
            Queue<TreeNode> q = new LinkedList<>(); // 核心数据结构
            q.offer(root); // 将起点加入队列
            while (!q.isEmpty()) {
                /* 将当前队列中的所有节点向四周扩散 */
                int width = q.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < width; i++) {
                    TreeNode cur = q.poll();
                    level.add(cur.val);
                    /* 划重点：这里判断是否到达终点 */
                    /* 将 cur 的相邻节点加入队列 */
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                /* 划重点：更新步数在这里 */
                order.addFirst(level);
            }
            return order;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 447 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>(); // 核心数据结构
//        Set<TreeNode> visited = new HashSet<>(); // 避免走回头路

        q.offer(root); // 将起点加入队列
//        visited.add(root);
        int step = 1; // 记录扩散的步数

        while (!q.isEmpty()) {
            /* 将当前队列中的所有节点向四周扩散 */
            int width = q.size();
//            System.out.println("width:" + width);
            for (int i = 0; i < width; i++) {
                TreeNode cur = q.poll();
//                System.out.print(cur.val + "[" + step + "] ");
                /* 划重点：这里判断是否到达终点 */
                if (cur.left == null && cur.right == null) {
                    return step;
                }
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
//            System.out.println(step);
            /* 划重点：更新步数在这里 */
            step++;
        }
        return step;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

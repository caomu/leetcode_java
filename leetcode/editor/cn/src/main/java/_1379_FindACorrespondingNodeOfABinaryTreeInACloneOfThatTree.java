//给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。 
//
// 其中，克隆树 cloned 是原始树 original 的一个 副本 。 
//
// 请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）
//。 
//
// 
//
// 注意： 
//
// 
// 你 不能 对两棵二叉树，以及 target 节点进行更改。 
// 只能 返回对克隆树 cloned 中已有的节点的引用。 
// 
//
// 
// 
//
// 进阶：如果树中允许出现值相同的节点，你将如何解答？ 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 
//
// 输入: tree = [7,4,3,null,null,6,19], target = 3
//输出: 3
//解释: 上图画出了树 original 和 cloned。target 节点在树 original 中，用绿色标记。答案是树 cloned 中的黄颜色的节点
//（其他示例类似）。 
//
// 示例 2: 
//
// 
//
// 输入: tree = [7], target =  7
//输出: 7
// 
//
// 示例 3: 
//
// 
//
// 输入: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
//输出: 4
// 
//
// 示例 4: 
//
// 
//
// 输入: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
//输出: 5
// 
//
// 示例 5: 
//
// 
//
// 输入: tree = [1,2,null,3], target = 2
//输出: 2 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量范围为 [1, 10^4] 。 
// 同一棵树中，没有值相同的节点。 
// target 节点是树 original 中的一个节点，并且不会是 null 。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 
// 👍 23 👎 0


import com.caomu.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _1379_FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public static void main(String[] args) {
        Solution solution = new _1379_FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree().new Solution();
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
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            Queue<TreeNode> originalQ = new LinkedList<>();
            Queue<TreeNode> clonedQ = new LinkedList<>();// 核心数据结构
            originalQ.offer(original);
            clonedQ.offer(cloned); // 将起点加入队列
            while (!originalQ.isEmpty()) {
                /* 将当前队列中的所有节点向四周扩散 */
                int originalWidth = originalQ.size();
                for (int i = 0; i < originalWidth; i++) {
                    TreeNode originalCur = originalQ.poll();
                    TreeNode clonedCur = clonedQ.poll();
                    /* 划重点：这里判断是否到达终点 */
                    if (originalCur == target) {
                        return clonedCur;
                    }
                    /* 将 cur 的相邻节点加入队列 */
                    if (originalCur.left != null) {
                        originalQ.offer(originalCur.left);
                        clonedQ.offer(clonedCur.left);
                    }
                    if (originalCur.right != null) {
                        originalQ.offer(originalCur.right);
                        clonedQ.offer(clonedCur.right);
                    }
                }
            }
            return null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
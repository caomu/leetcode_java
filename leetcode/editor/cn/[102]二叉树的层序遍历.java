//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 750 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        this.layerTraversal(root, 0, res);
        return res;
    }

    private void layerTraversal(TreeNode node, int layer, List<List<Integer>> res) {
        if (node == null) { //如果结点为空则返回
            return;
        }
        if (res.size() <= layer) {
//            System.out.println(layer);
            res.add(new ArrayList<>());
        }
        res.get(layer).add(node.val);
        layer++;
        this.layerTraversal(node.left, layer, res);
        this.layerTraversal(node.right, layer, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

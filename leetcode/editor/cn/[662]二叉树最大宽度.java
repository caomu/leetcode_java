import java.util.ArrayList;
import java.util.List;

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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> lList = new ArrayList<>();
        List<Integer> rList = new ArrayList<>();
        this.dfs(root, 0, lList, rList, 0);
        int res = 0;
        for (int i = 0; i < Math.max(lList.size(), rList.size()); i++) {
            if (lList.size() > i && rList.size() > i) {
                res = Math.max(res, rList.get(i) - lList.get(i) + 1);
            }
        }
        return res;
    }

    private void dfs(TreeNode node, int level, List<Integer> lList, List<Integer> rList, int p) {
        // check if can end
        if (node == null) {
            return;
        }
        // process current depth level
        if (lList.size() == level) {
            lList.add(p);
        }
        if (rList.size() == level) {
            rList.add(p);
        } else {
            rList.set(level, p);
        }
        // dig into next depth
        level++;
        this.dfs(node.left, level, lList, rList, p * 2);
        this.dfs(node.right, level, lList, rList, p * 2 + 1);
    }
}

//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表 
// 👍 103 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int[] res = this.traversal(root, frequencyMap, 0);
        return frequencyMap.entrySet().stream().filter(entry -> entry.getValue().equals(res[1]))
                .mapToInt(Map.Entry::getKey).toArray();
    }

    /**
     * 递归遍历
     */
    private int[] traversal(TreeNode node, Map<Integer, Integer> frequencyMap, int maxFrequency) {
        if (node == null) { //如果结点为空则返回
            return new int[]{0, 0};
        }
        int[] leftRes = this.traversal(node.left, frequencyMap, maxFrequency);
        int[] rightRes = this.traversal(node.right, frequencyMap, maxFrequency);
        Integer sum = leftRes[0] + rightRes[0] + node.val;
        int frequency = frequencyMap.getOrDefault(sum, 0) + 1;
        maxFrequency = Math.max(Math.max(leftRes[1], rightRes[1]), Math.max(frequency, maxFrequency));
        frequencyMap.put(sum, frequency);
        return new int[]{sum, maxFrequency};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

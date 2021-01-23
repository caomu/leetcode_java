//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 104] 
// 0 <= Node.val <= 104 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
//
// 
//
// 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 
// 👍 149 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

public class Codec {
    /**
     * 递归前序遍历
     */
    private void postOrderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {//如果结点为空则返回
            return;
        }
        this.postOrderTraversal(node.left, sb);//访问左孩子
        this.postOrderTraversal(node.right, sb);//访问右孩子
        sb.append(node.val).append(':');//访问根节点
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        this.postOrderTraversal(root, sb);
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
//        System.out.println("serialize:" + sb);
        return sb.toString();
    }

    private TreeNode deserialize(int upper, int lower, Deque<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        }
        int nodeVal = nums.getLast();
//        System.out.println("[" + nodeVal + "],lower:" + lower + ",upper:" + upper);
        if (nodeVal > upper || nodeVal < lower) {
            return null;
        }
        nums.removeLast();
        TreeNode node = new TreeNode(nodeVal);
        node.right = this.deserialize(upper, nodeVal, nums);
//        System.out.println("------------");
        node.left = this.deserialize(nodeVal, lower, nums);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Deque<Integer> nums = new ArrayDeque<>();
        Arrays.stream(data.split(":")).forEach(n -> nums.addLast(Integer.parseInt(n)));
        return this.deserialize(Integer.MAX_VALUE, Integer.MIN_VALUE, nums);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

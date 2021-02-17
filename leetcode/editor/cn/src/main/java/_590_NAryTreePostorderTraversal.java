//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 125 👎 0


import com.caomu.util.Node;

import java.util.*;

public class _590_NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new _590_NAryTreePostorderTraversal().new Solution();
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<Integer> postorder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> postorder = new ArrayList<>();
            Deque<Node> q = new LinkedList<>(); // 核心数据结构
            q.offer(root); // 将起点加入队列

            while (!q.isEmpty()) {
                /* 将当前队列中的所有节点向四周扩散 */
                Node cur = q.pollLast();
                postorder.add(cur.val);
                /* 将 cur 的相邻节点加入队列 */
                for (int j = 0; j < cur.children.size(); j++) {
                    q.offerLast(cur.children.get(j));
                }
            }
            Collections.reverse(postorder);
            return postorder;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
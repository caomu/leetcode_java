//给定一个二叉树
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//
//
// 示例：
//
//
//
//
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。
//
//
//
// 提示：
//
//
// 树中的节点数小于 6000
// -100 <= node.val <= 100
//
//
//
//
//
//
// Related Topics 树 深度优先搜索
// 👍 393 👎 0

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * create time: 2021-04-19 09:27:29
 */
public class _117_PopulatingNextRightPointersInEachNodeIi {

    private static final Logger logger = Logger.getLogger(_117_PopulatingNextRightPointersInEachNodeIi.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-19 09:27:29").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _117_PopulatingNextRightPointersInEachNodeIi().new Solution();

        // assert solution == ;
//        logger.warning(String.valueOf(solution));
//        TreeNodeUtils.prettyPrintTree(solution.connect(TreeNodeUtils.stringToTreeNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
        logger.info("solution cost: [" +
                    Duration.ofSeconds((System.currentTimeMillis() - startTimestamp) / 1000).toString() + "]");
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            this.val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            this.val = _val;
            this.left = _left;
            this.right = _right;
            this.next = _next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public Node connect(Node root) {
            Node node = root;
            if (root != null) {
                if (node.right != null && node.left != null) {
                    node.left.next = node.right;
                }
                this.connectNode(root.left);
                this.connectNode(root.right);
                Node next = null;
                while (node != null) {
                    if (next == null && node.left != null) {
                        next = node.left;
                    } else if (next == null && node.right != null) {
                        next = node.right;
                    }
                    this.connectNode(node);
                    node = node.next;
                    if (node == null) {
                        node = next;
                        next = null;
                    }
                }
            }
            return root;
        }

        private void connectNode(Node node) {
            if (node == null) {
                return;
            }
            if (node.right != null && node.left != null) {
                node.left.next = node.right;
            }
            Node next = node.next;
            while (next != null) {
                if (next.left != null && node.right != null) {
                    node.right.next = next.left;
                    break;
                } else if (next.left != null && node.left != null) {
                    node.left.next = next.left;
                    break;
                } else if (next.right != null && node.right != null) {
                    node.right.next = next.right;
                    break;
                } else if (next.right != null && node.left != null) {
                    node.left.next = next.right;
                    break;
                }
                next = next.next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

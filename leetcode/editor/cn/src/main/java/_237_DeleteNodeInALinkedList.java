//请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
//
//
//
// 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
//
//
//
//
//
// 示例 1：
//
// 输入：head = [4,5,1,9], node = 5
//输出：[4,1,9]
//解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
//
//
// 示例 2：
//
// 输入：head = [4,5,1,9], node = 1
//输出：[4,5,9]
//解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
//
//
//
//
// 提示：
//
//
// 链表至少包含两个节点。
// 链表中所有节点的值都是唯一的。
// 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
// 不要从你的函数中返回任何结果。
//
// Related Topics 链表
// 👍 857 👎 0


import com.caomu.util.ListNode;

import java.util.logging.Logger;

/**
 * create time: 2021-03-14 16:39:09
 */
public class _237_DeleteNodeInALinkedList {

    private static final Logger logger = Logger.getLogger(_237_DeleteNodeInALinkedList.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _237_DeleteNodeInALinkedList().new Solution();

        // assert solution == ;
        logger.warning(String.valueOf(solution));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void deleteNode(ListNode node) {
            while (node.next != null) {
                node.val = node.next.val;
                if (node.next.next == null) {
                    node.next = null;
                } else {
                    node = node.next;
                }
            }
            System.gc();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

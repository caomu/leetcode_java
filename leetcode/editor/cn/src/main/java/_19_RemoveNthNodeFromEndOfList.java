//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1279 👎 0


import com.caomu.util.ListNode;
import com.caomu.util.ListNodeUtils;

import java.util.logging.Logger;

/**
 * create time: 2021-03-20 00:59:30
 */
public class _19_RemoveNthNodeFromEndOfList {

    private static final Logger logger = Logger.getLogger(_19_RemoveNthNodeFromEndOfList.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _19_RemoveNthNodeFromEndOfList().new Solution();

        // assert solution == ;
//        ListNodeUtils.prettyPrintLinkedList(solution.removeNthFromEnd(ListNodeUtils.stringToListNode("[1]"), 1));
//        ListNodeUtils.prettyPrintLinkedList(solution.removeNthFromEnd(ListNodeUtils.stringToListNode("[1,2,3,4,5]"), 2));
        ListNodeUtils.prettyPrintLinkedList(solution.removeNthFromEnd(ListNodeUtils.stringToListNode("[1,2]"), 2));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head.next == null) {
                return null;
            }
            ListNode prevDelete = head;
            ListNode node = head;
            int count = 0;
            while (node != null) {
                if (count > n) {
                    prevDelete = prevDelete.next;
                }
                count++;
                node = node.next;
            }
            if (count == n) {
                return head.next;
            }
            prevDelete.next = n == 1 ? null : prevDelete.next.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

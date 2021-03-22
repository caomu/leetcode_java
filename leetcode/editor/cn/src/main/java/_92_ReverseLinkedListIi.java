//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
// 👍 723 👎 0


import com.caomu.util.ListNode;
import com.caomu.util.ListNodeUtils;

import java.util.logging.Logger;

/**
 * create time: 2021-03-18 09:00:37
 */
public class _92_ReverseLinkedListIi {

    private static final Logger logger = Logger.getLogger(_92_ReverseLinkedListIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _92_ReverseLinkedListIi().new Solution();

//        ListNodeUtils.prettyPrintLinkedList(solution.reverseBetween(ListNodeUtils.stringToListNode("[1,2,3,4,5]"),
//                2, 4));
//        ListNodeUtils.prettyPrintLinkedList(solution.reverseBetween(ListNodeUtils.stringToListNode("[5]"),
//                1, 1));
        ListNodeUtils.prettyPrintLinkedList(solution.reverseBetween(ListNodeUtils.stringToListNode("[3,5]"),
                1, 2));
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode start = head;
            ListNode node = head;
            ListNode prevNode = null;
            ListNode prevLeft = null;
            ListNode leftNode = null;
            ListNode nextNode;
            int position = 1;
            while (node != null) {
                nextNode = node.next;
                if (leftNode != null) {
                    node.next = prevNode;
                }
                if (position == left) {
                    prevLeft = prevNode;
                    leftNode = node;
                }
                if (position == right) {
                    if (prevLeft != null) {
                        prevLeft.next = node;
                    } else {
                        start = node;
                    }
                    leftNode.next = nextNode;
                    break;
                }
                prevNode = node;
                node = nextNode;
                position++;
            }
            return start;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

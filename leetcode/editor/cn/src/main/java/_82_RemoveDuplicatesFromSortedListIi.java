//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//
//
// 示例 2:
//
// 输入: 1->1->1->2->3
//输出: 2->3
// Related Topics 链表
// 👍 502 👎 0


import com.caomu.util.ListNode;
import com.caomu.util.ListNodeUtils;

import java.util.logging.Logger;

/**
 * create time: 2021-03-25 09:43:32
 */
public class _82_RemoveDuplicatesFromSortedListIi {

    private static final Logger logger = Logger.getLogger(_82_RemoveDuplicatesFromSortedListIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _82_RemoveDuplicatesFromSortedListIi().new Solution();

//        ListNodeUtils.prettyPrintLinkedList(solution.deleteDuplicates(ListNodeUtils.stringToListNode(
//                "[0,0,1,2,3,3,4,4,5,6,6]")));
        ListNodeUtils.prettyPrintLinkedList(solution.deleteDuplicates(ListNodeUtils.stringToListNode(
                "[]")));

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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode node = head;
            ListNode dummy = new ListNode(Integer.MAX_VALUE, head);
            ListNode nonDuplicates = dummy;
            ListNode prev = dummy;
            while (node != null) {
                if (node.val != prev.val && (node.next == null || node.val != node.next.val)) {
                    nonDuplicates.next = node;
                    nonDuplicates = node;
                } else if (node.val == prev.val && node.next == null) {
                    nonDuplicates.next = null;
                }
                prev = node;
                node = node.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

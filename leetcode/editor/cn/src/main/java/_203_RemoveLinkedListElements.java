//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//
// 示例 2：
//
//
//输入：head = [], val = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//
//
//
// 提示：
//
//
// 列表中的节点在范围 [0, 104] 内
// 1 <= Node.val <= 50
// 0 <= k <= 50
//
// Related Topics 链表
// 👍 575 👎 0


import com.caomu.util.ListNode;
import com.caomu.util.ListNodeUtils;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * create time: 2021-04-19 10:13:07
 */
public class _203_RemoveLinkedListElements {

    private static final Logger logger = Logger.getLogger(_203_RemoveLinkedListElements.class.toString());
    private static final long startTimestamp = Timestamp.valueOf("2021-04-19 10:13:07").getTime();

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _203_RemoveLinkedListElements().new Solution();

        // assert solution == ;
        ListNodeUtils.prettyPrintLinkedList(solution.removeElements(ListNodeUtils.stringToListNode("[1,2,2,1]"), 2));
        ListNodeUtils.prettyPrintLinkedList(solution.removeElements(ListNodeUtils.stringToListNode("[6,6,6,6]"), 6));
        ListNodeUtils.prettyPrintLinkedList(solution.removeElements(ListNodeUtils.stringToListNode("[1,2,6,3,4,5,6]"), 6));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
        logger.info("solution cost: [" +
                    Duration.ofSeconds((System.currentTimeMillis() - startTimestamp) / 1000).toString() + "]");
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
        public ListNode removeElements(ListNode head, int val) {
            ListNode node = head;
            ListNode prev = null;
            while (node != null) {
                if (node.val == val && prev == null) {
                    head = node.next;
                } else if (node.val == val) {
                    // prev != null
                    prev.next = node.next;
                } else {
                    prev = node;
                }
                node = node.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

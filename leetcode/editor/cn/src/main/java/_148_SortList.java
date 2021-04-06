//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 排序 链表
// 👍 1079 👎 0


import com.caomu.util.ListNode;
import com.caomu.util.ListNodeUtils;

import java.util.logging.Logger;

/**
 * create time: 2021-04-06 21:38:15
 */
public class _148_SortList {

    private static final Logger logger = Logger.getLogger(_148_SortList.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _148_SortList().new Solution();

        // assert solution == ;
        ListNodeUtils.prettyPrintLinkedList(solution.sortList(ListNodeUtils.stringToListNode("[4,2,1,3]")));
        ListNodeUtils.prettyPrintLinkedList(solution.sortList(ListNodeUtils.stringToListNode("[-1,5,3,4,0]")));
        ListNodeUtils.prettyPrintLinkedList(solution.sortList(ListNodeUtils.stringToListNode("[-1]")));
        ListNodeUtils.prettyPrintLinkedList(solution.sortList(ListNodeUtils.stringToListNode("[]")));

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
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode node = head;
            int length = 0;
            while (node != null) {
                length++;
                node = node.next;
            }
            return this.sortList(new ListNode(Integer.MIN_VALUE, head), head, length, null);
        }

        private ListNode sortList(ListNode prev, ListNode head, int length, ListNode next) {
            if (length == 1) {
                return head;
            }
            ListNode node = head;
            int leftLength = 0;
            while (node != null) {
                node = node.next;
                leftLength++;
                if (leftLength == length / 2) {
                    break;
                }
            }
            ListNode left = this.sortList(prev, head, leftLength, node);
            ListNode prevNode = prev;
            for (int i = 0; i < leftLength; i++) {
                prevNode = prevNode.next;
            }
            int rightLength = length - leftLength;
            ListNode right = this.sortList(prevNode, node, rightLength, next);
            node = prev;
            int leftCount = 0;
            int rightCount = 0;
            while (leftCount < leftLength || rightCount < rightLength) {
                if (leftCount >= leftLength || (rightCount < rightLength && right.val <= left.val)) {
                    node.next = right;
                    right = right.next;
                    rightCount++;
                } else {
                    node.next = left;
                    left = left.next;
                    leftCount++;
                }
                node = node.next;
            }
            node.next = next;
            return prev.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

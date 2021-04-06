//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109
//
// Related Topics 链表 双指针
// 👍 461 👎 0


import com.caomu.util.ListNode;
import com.caomu.util.ListNodeUtils;

import java.util.logging.Logger;

/**
 * create time: 2021-03-27 08:47:33
 */
public class _61_RotateList {

    private static final Logger logger = Logger.getLogger(_61_RotateList.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _61_RotateList().new Solution();

        ListNodeUtils.prettyPrintLinkedList(solution.rotateRight(
                ListNodeUtils.stringToListNode("[1,2,3,4,5]"), 2));
        ListNodeUtils.prettyPrintLinkedList(solution.rotateRight(
                ListNodeUtils.stringToListNode("[0,1,2]"), 4));

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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode node = head;
            int length = 0;
            while (node != null) {
                length++;
                node = node.next;
            }
            if (k % length == 0) {
                return head;
            }
            int rotateCnt = length - k % length;
            node = head;
            ListNode newHead = null;
            while (true) {
                rotateCnt--;
                if (rotateCnt == 0) {
                    ListNode prev = node;
                    newHead = node.next;
                    node = node.next;
                    prev.next = null;
                } else {
                    node = node.next;
                }
                if (node.next == null) {
                    node.next = head;
                    break;
                }
            }

            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

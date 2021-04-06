//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
// 返回同样按升序排列的结果链表。
//
//
//
// 示例 1：
//
//
//输入：head = [1,1,2]
//输出：[1,2]
//
//
// 示例 2：
//
//
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序排列
//
// Related Topics 链表
// 👍 511 👎 0


import com.caomu.util.ListNode;
import com.caomu.util.ListNodeUtils;

import java.util.logging.Logger;

/**
 * create time: 2021-03-26 10:10:27
 */
public class _83_RemoveDuplicatesFromSortedList {

    private static final Logger logger = Logger.getLogger(_83_RemoveDuplicatesFromSortedList.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _83_RemoveDuplicatesFromSortedList().new Solution();

        ListNodeUtils.prettyPrintLinkedList(solution.deleteDuplicates(
                ListNodeUtils.stringToListNode("[1,2,3,3,5]")));

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
            ListNode prev = new ListNode(Integer.MIN_VALUE, head);
            while (node != null) {
                if (node.val != prev.val) {
                    prev.next = node;
                    prev = node;
                }
                node = node.next;
            }
            prev.next = null;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

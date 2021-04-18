//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
//
//
// 示例 2:
//
// 输入: 2->1->3->5->6->4->7->NULL
//输出: 2->3->6->7->1->5->4->NULL
//
// 说明:
//
//
// 应当保持奇数节点和偶数节点的相对顺序。
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
//
// Related Topics 链表
// 👍 412 👎 0


import com.caomu.util.ListNode;
import com.caomu.util.ListNodeUtils;

import java.util.logging.Logger;

/**
 * create time: 2021-04-18 09:17:19
 */
public class _328_OddEvenLinkedList {

    private static final Logger logger = Logger.getLogger(_328_OddEvenLinkedList.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _328_OddEvenLinkedList().new Solution();

        ListNodeUtils.prettyPrintLinkedList(solution.oddEvenList(ListNodeUtils.stringToListNode("[2,1,3,5,6,4,7]")));

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode dummyOdd = new ListNode(0);
            ListNode dummyEven = new ListNode(0);
            ListNode odd = dummyOdd;
            ListNode even = dummyEven;
            ListNode node = head;
            int count = 0;
            while (node != null) {
                if ((count & 1) == 0) {
                    even.next = node;
                    even = even.next;
                } else {
                    odd.next = node;
                    odd = odd.next;
                }
                node = node.next;
                count++;
            }
            even.next = dummyOdd.next;
            odd.next = null;
            return dummyEven.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

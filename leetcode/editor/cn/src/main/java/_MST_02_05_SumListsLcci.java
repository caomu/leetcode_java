//给定两个用链表表示的整数，每个节点包含一个数位。
//
// 这些数位是反向存放的，也就是个位排在链表首部。
//
// 编写函数对这两个整数求和，并用链表形式返回结果。
//
//
//
// 示例：
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
//
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
//
// 示例：
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
//
// Related Topics 链表 数学
// 👍 59 👎 0


import com.caomu.util.ListNode;

import java.util.logging.Logger;

/**
 * create time: 2021-04-07 00:15:17
 */
public class _MST_02_05_SumListsLcci {

    private static final Logger logger = Logger.getLogger(_MST_02_05_SumListsLcci.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _MST_02_05_SumListsLcci().new Solution();

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode dummy = new ListNode(0);
            ListNode result = dummy;
            while (l1 != null || l2 != null) {
                int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
                if (val > 9) {
                    carry = 1;
                    val %= 10;
                } else {
                    carry = 0;
                }
                result.next = new ListNode(val);
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
                result = result.next;
            }
            if (carry > 0) {
                result.next = new ListNode(1);
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

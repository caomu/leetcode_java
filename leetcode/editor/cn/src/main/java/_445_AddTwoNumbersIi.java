//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//
//
// 进阶：
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
//
//
//
// 示例：
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
//
// Related Topics 链表
// 👍 355 👎 0


import com.caomu.util.ListNode;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * create time: 2021-03-21 17:50:44
 */
public class _445_AddTwoNumbersIi {

    private static final Logger logger = Logger.getLogger(_445_AddTwoNumbersIi.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _445_AddTwoNumbersIi().new Solution();

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
            Stack<Integer> stack1 = new Stack();
            ListNode node = l1;
            while (node != null) {
                stack1.add(node.val);
                node = node.next;
            }
            Stack<Integer> stack2 = new Stack();
            node = l2;
            while (node != null) {
                stack2.add(node.val);
                node = node.next;
            }
            boolean isCarray = false;
            Stack<Integer> sum = new Stack<>();
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                int s = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) +
                        (isCarray ? 1 : 0);
                isCarray = s > 9;
                sum.push(s % 10);
            }
            if (isCarray) {
                sum.push(1);
            }
            ListNode l3 = new ListNode(sum.pop());
            node = l3;
            while (!sum.isEmpty()) {
                ListNode next = new ListNode(sum.pop());
                node.next = next;
                node = next;
            }
            return l3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

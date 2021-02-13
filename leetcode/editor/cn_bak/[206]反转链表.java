//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1401 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int x) {
//		val = x;
//	}
//}

class Solution {

	public ListNode reverseList(ListNode head) {
		if (null == head) {
			return null;
		}
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = head.next;

		while (next != null) {
//			System.out.println("begin\tprev:" + (null == prev ? null : prev.val + "->" + (null == prev.next ? null : prev.next.val))
//					+ "\tcurr:" + (null == curr ? null : curr.val + "->" + (null == curr.next ? null : curr.next.val))
//					+ "\tnext:" + (null == next ? null : next.val + "->" + (null == next.next ? null : next.next.val)));
			curr.next = prev;
			prev = curr;
			curr = next;
			next = curr.next;
//			System.out.println("end\t\tprev:" + (null == prev ? null : prev.val + "->" + (null == prev.next ? null : prev.next.val))
//					+ "\tcurr:" + (null == curr ? null : curr.val + "->" + (null == curr.next ? null : curr.next.val))
//					+ "\tnext:" + (null == next ? null : next.val + "->" + (null == next.next ? null : next.next.val)));
		}
		curr.next = prev;
		return curr;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

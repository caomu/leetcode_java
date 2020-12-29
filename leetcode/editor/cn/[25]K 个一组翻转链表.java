//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 827 👎 0


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
//public class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode() {
//	}
//
//	ListNode(int val) {
//		this.val = val;
//	}
//
//	ListNode(int val, ListNode next) {
//		this.val = val;
//		this.next = next;
//	}
//}

class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		ListNode[] reverseArr = new ListNode[k];
		for (int i = 0; i < k; i++, curr = curr.next) {
			if (null == curr) {
				return head;
			}
			reverseArr[i] = curr;
		}
		ListNode last = reverseArr[k - 1];
		ListNode res = last;
		ListNode prev = null, next = last.next;

		while (null != last) {
//			System.out.print("begin\tprev:" + (null == prev ? null : (prev.val + "->" + (null == prev.next ? null : prev.next.val))));
//			for (int i = 0; i < k; i++) {
//				System.out.print("\tp" + i + ":" + (null == reverseArr[i] ? null : (reverseArr[i].val + "->" + (null == reverseArr[i].next ? null : reverseArr[i].next.val))));
//			}
//			System.out.println("\tnext:" + (null == next ? null : (next.val + "->" + (null == next.next ? null : next.next.val))));
			if (null != prev) {
				prev.next = last;
			}
			reverseArr[0].next = next;
			for (int i = 1; i < k; i++) {
				reverseArr[i].next = reverseArr[i - 1];
			}
//			System.out.print("middle\tprev:" + (null == prev ? null : (prev.val + "->" + (null == prev.next ? null : prev.next.val))));
//			for (int i = 0; i < k; i++) {
//				System.out.print("\tp" + i + ":" + (null == reverseArr[i] ? null : (reverseArr[i].val + "->" + (null == reverseArr[i].next ? null : reverseArr[i].next.val))));
//			}
//			System.out.println("\tnext:" + (null == next ? null : (next.val + "->" + (null == next.next ? null : next.next.val))));

			prev = reverseArr[0];
			curr = next;
			boolean isEnd = false;
			for (int i = 0; i < k; i++, curr = curr.next) {
				if (null == curr) {
					isEnd = true;
					break;
				}
				reverseArr[i] = curr;
			}
			if (!isEnd) {
				last = reverseArr[k - 1];
				next = last.next;
			} else {
				last = null;
				next = null;
			}
//			System.out.print("end\t\tprev:" + (null == prev ? null : (prev.val + "->" + (null == prev.next ? null : prev.next.val))));
//			for (int i = 0; i < k; i++) {
//				System.out.print("\tp" + i + ":" + (null == reverseArr[i] ? null : (reverseArr[i].val + "->" + (null == reverseArr[i].next ? null : reverseArr[i].next.val))));
//			}
//			System.out.println("\tnext:" + (null == next ? null : (next.val + "->" + (null == next.next ? null : next.next.val))));
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 
// 👍 766 👎 0


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
	public ListNode swapPairs(ListNode head) {
		if (null == head || null == head.next) {
			return head;
		}
		ListNode res = head.next;
		ListNode p0 = null, p1 = head, p2 = head.next, p3 = p2.next;
		while (null != p1 && null != p2) {
//			System.out.println("begin\tp0:" + (null == p0 ? null : (p0.val + "->" + (null == p0.next ? null : p0.next.val)))
//					+ "\tp1:" + (null == p1 ? null : (p1.val + "->" + (null == p1.next ? null : p1.next.val)))
//					+ "\tp2:" + (null == p2 ? null : (p2.val + "->" + (null == p2.next ? null : p2.next.val)))
//					+ "\tp3:" + (null == p3 ? null : (p3.val + "->" + (null == p3.next ? null : p3.next.val))));
			if (null != p0) {
				p0.next = p2;
			}
			p1.next = p2.next;
			p2.next = p1;
//			System.out.println("middle\tp0:" + (null == p0 ? null : (p0.val + "->" + (null == p0.next ? null : p0.next.val)))
//					+ "\tp1:" + (null == p1 ? null : (p1.val + "->" + (null == p1.next ? null : p1.next.val)))
//					+ "\tp2:" + (null == p2 ? null : (p2.val + "->" + (null == p2.next ? null : p2.next.val)))
//					+ "\tp3:" + (null == p3 ? null : (p3.val + "->" + (null == p3.next ? null : p3.next.val))));
			p0 = p1;
			p1 = p3;
			if (null != p3) {
				p2 = p3.next;
				p3 = (null != p3.next && null != p3.next.next) ? p3.next.next : null;
			}
//			System.out.println("end\t\tp0:" + (null == p0 ? null : (p0.val + "->" + (null == p0.next ? null : p0.next.val)))
//					+ "\tp1:" + (null == p1 ? null : (p1.val + "->" + (null == p1.next ? null : p1.next.val)))
//					+ "\tp2:" + (null == p2 ? null : (p2.val + "->" + (null == p2.next ? null : p2.next.val)))
//					+ "\tp3:" + (null == p3 ? null : (p3.val + "->" + (null == p3.next ? null : p3.next.val))));
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

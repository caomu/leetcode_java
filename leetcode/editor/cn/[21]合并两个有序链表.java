//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1456 👎 0


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
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (null == l1 && null == l2) {
			return null;
		}
		ListNode m;
		ListNode p1 = l1, p2 = l2;
		if (null == l2 || (l1 != null && (l1.val < l2.val))) {
			m = l1;
			p1 = p1.next;
		} else {
			m = l2;
			p2 = p2.next;
		}
		ListNode res = m;
//		System.out.println("res:" + res.val + "\tp1:" + p1.val + "\tp2:" + p2.val);
		while (null != p1 || null != p2) {
			if (p2 == null || (p1 != null && (p1.val < p2.val))) {
				m.next = p1;
				p1 = p1.next;
			} else {
				m.next = p2;
				p2 = p2.next;
			}
			m = m.next;
//			System.out.println("res:" + res.val + "\tp1:" + p1 == null ? null : p1.val + "\tp2:" + p2 == null ? null : p2.val);
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

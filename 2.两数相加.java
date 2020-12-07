/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = null;
		boolean flag = false;
		ListNode cur = res;
		while (l1 != null || l2 != null || flag) {
			// System.out.println(l1.val);
			// System.out.println(l1.next);
			// System.out.println(l2.val);
			// System.out.println(l2.next);

			int val1 = 0;
			int val2 = 0;

			if (l1 != null) {
				val1 = l1.val;
			}
			if (l2 != null) {
				val2 = l2.val;
			}
			int val = val1 + val2;
			if (flag) {
				val += 1;
				flag = false;
			}
			if (val >= 10) {
				flag = true;
				val %= 10;
			}
			ListNode l3 = new ListNode(val);
			if (cur == null) {
				res = l3;
			} else {
				cur.next = l3;
			}
			cur = l3;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		return res;
	}
}
// @lc code=end

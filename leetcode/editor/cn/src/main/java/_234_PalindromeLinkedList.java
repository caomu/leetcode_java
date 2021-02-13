//请判断一个链表是否为回文链表。
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 850 👎 0

import com.caomu.util.ListNode;

public class _234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new _234_PalindromeLinkedList().new Solution();
        System.out.println(solution);
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
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            int cnt = 1;
            ListNode t = head;
            while (t.next != null) {
                t = t.next;
                cnt++;
            }
            int p = cnt >> 1;

            t = head;
            int idx = 1;
            ListNode next = t.next;
            t.next = null;
            while (idx < p) {
//                System.out.println("t:" + t.val + ",next:" + next.val + ",head" + head.val);
                ListNode tmp = next.next;
                next.next = t;
                t = next;
                next = tmp;
                idx++;
            }
            if ((cnt & 1) != 0) {
                next = next.next;
            }
//            System.out.print("next:");
//            while (next != null) {
//                System.out.print(next.val + "->");
//                next = next.next;
//            }
//            System.out.println();
//            System.out.print("t:");
//            while (t != null) {
//                System.out.print(t.val + "->");
//                t = t.next;
//            }
//            System.out.println();
//            System.out.println("t:" + t.val + ",next:" + next.val + ",head" + head.val);

            while (t != null) {
                if (next.val != t.val) {
                    return false;
                }
                t = t.next;
                next = next.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
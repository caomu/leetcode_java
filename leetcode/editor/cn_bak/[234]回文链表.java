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
// 👍 821 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
//public class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
//        ListNode temp = head;
//        do {
//            System.out.print(temp.val + "->");
//            temp = temp.next;
//        } while (temp != null);
//        System.out.println();
        ListNode slow = head;
        ListNode fast = head;
        ListNode midL;
        ListNode midR;
        ListNode mid;
        ListNode curr = head;
        ListNode prev = null;
        while (true) {
            System.out.println("slow:" + slow.val);
            curr = slow;
            slow = slow.next;
            System.out.println("curr:" + curr.val);
            System.out.println("fast:" + fast.val);
//            System.out.println("fast.next:" + fast.next.val);
//            System.out.println("fast.next.next:" + fast.next.next.val);
            if (fast.next == null || fast.next.next == null) {
                midL = fast.next == null ? curr.next : curr;
                mid = fast.next == null ? curr: slow;
                midR = fast.next == null ? mid : slow;
                System.out.println("midL:" + midL.val);
                System.out.println("mid:" + mid.val);
                System.out.println("midR:" + midR.val);
                break;
            }
            fast = fast.next.next;
            System.out.println("fast.next.next:" + fast.val);
//            System.out.println("curr:" + curr.val);
            curr.next = prev;
            prev = curr;
        }
        ListNode tmpMidL = midL;
        do {
            System.out.print(tmpMidL.val + "->");
            tmpMidL = tmpMidL.next;
        } while (tmpMidL != null);
        System.out.println();
        ListNode tmpMidR = midR;
        do {
            System.out.print(tmpMidR.val + "->");
            tmpMidR = tmpMidR.next;
        } while (tmpMidR != null);
        System.out.println();
        boolean res = true;
        prev = mid;
        do {
            if (midL != midR && res) {
                res = false;
            }
            System.out.println("prev:" + prev.val);
            curr = midL;
            curr.next = prev;
            System.out.println("curr.next:" + curr.next.val);
            prev = curr;
            midL = midL.next;
            midR = midR.next;
        } while (midL.next != null);

        do {
            System.out.print(curr.val + "->");
            curr = curr.next;
        } while (curr != null);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

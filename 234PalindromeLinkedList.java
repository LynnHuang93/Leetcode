/*
234. Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode rev = reverse(head);
        ListNode p1 = head, p2 = rev;
        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode dummyHead = new ListNode(0);
        ListNode p = head;
        while(p != null) {
        	// Use new ListNode so the original list is not destroyed
            ListNode tmp = new ListNode(p.val);
            p = p.next;
            tmp.next = dummyHead.next;
            dummyHead.next = tmp;
        }
        return dummyHead.next;
    }
}

/* Test case
[1,1,2,1]
*/
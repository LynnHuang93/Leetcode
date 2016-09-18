/*
61. Rotate List
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// For big k will TLE.
public ListNode rotateRight(ListNode head, int k) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode fast = dummyHead;
    ListNode slow = dummyHead;
    if (k == 0 || head == null) {
        return head;
    }
    for (int i = 0; i < k; i++) {
        if (fast.next != null) {
            fast = fast.next;
        }
        else {
            fast = head;
        }
    }
    while(fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    if (slow == dummyHead) {
        return head;
    }
    dummyHead.next = slow.next;
    fast.next = head;
    slow.next = null;
    return dummyHead.next;
}

// Obviously for big k, most time is used in moving fast. Then we record the list length.
// Calculate actual k, then reset the problem ad k < list length.

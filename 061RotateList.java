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
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        if (k == 0 || head == null) {
            return head;
        }
        // Record the list length if k > list length
        int length = 0;
        for (int i = 0; i < k; i++) {
            if (fast.next != null) {
                fast = fast.next;
                length++;
            }
            else {
                // If reaches end, calculate actual k < list length and reset question
                fast = dummyHead;
                // Here we want to restart from i = 0 but at the end of this loop i will ++
                i = -1;
                k = k % length;
                // If k is times of length, this means the head is the first element.
                if (k == 0) {
                    return dummyHead.next;
                }
            }
        }
        // Make fast at last node and slow.next is new head.
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // If slow did not move, the later part will return []
        if (slow == dummyHead) {
            return dummyHead.next;
        }
        dummyHead.next = slow.next;
        fast.next = head;
        slow.next = null;
        return dummyHead.next;
    }
}

/* Test cases
[]
4
[1]
99
[1,2,3,4]
2000000
*/
/*
82. Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

// Hard part is remove duplicat numbers. This requires more pointer
// Also need to take care if the beginning or ending part is duplicate number
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public ListNode deleteDuplicates(ListNode head) {
	// Use dummyHead to take care of duplicate at the beginning
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    if (head == null || head.next == null) {
        return head;
    }
    boolean repeat = false;
    ListNode tail = dummyHead;
    ListNode slow = head;
    ListNode fast = slow.next;
    while (slow != null && fast != null) {
        if (slow.val != fast.val) {
            if (repeat) {
                tail.next = fast;
            }
            else {
                tail = slow;
            }
            repeat = false;
            slow = fast;
            fast = slow.next;
        }
        else {
            repeat = true;
            fast = fast.next;
        }
    }
    // Take care of duplicate number at the end
    if (repeat) {
        tail.next = null;
    }
    return dummyHead.next;
}

/* Test case
[1,1,1,2,2,3,4,4,4]
*/
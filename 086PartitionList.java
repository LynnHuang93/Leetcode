/*
86. Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public ListNode partition(ListNode head, int x) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode tailOfP1 = dummyHead;
    ListNode headOfP2 = dummyHead;
    ListNode ptr = head;
    // Find head of P2;
    while (ptr != null && ptr.val < x) {
        tailOfP1 = ptr;
        ptr = ptr.next;
    }
    // If all < x
    if (ptr == null) {
        return dummyHead.next;
    }
    headOfP2 = ptr;
    ListNode tailOfP2 = ptr;
    ptr = ptr.next;
    while (ptr != null) {
        if (ptr.val < x) {
        	// tailOfP1 headOfP2...tailOfP2 ptr newptr ->
        	// tailOfP1(ptr) headOfP2 ... tailOfP2 newptr
            tailOfP2.next = ptr.next;
            tailOfP1.next = ptr;
            tailOfP1 = tailOfP1.next;
            ptr.next = headOfP2;
            ptr = tailOfP2.next;
        }
        else{
            ptr = ptr.next;
            tailOfP2 = tailOfP2.next;
        }
    }
    return dummyHead.next;
}
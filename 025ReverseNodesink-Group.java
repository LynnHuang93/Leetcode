/*
25. Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/

// Use two pointers to difine each k-element group and move the first to tail.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;
    for (int i = 0; i < k; i++){
        if (fast.next == null) {
            return dummy.next;
        }
        else{
            fast = fast.next;
        }
    }
    while (fast!= null) {
        // Reverse k Nodes only need to move k-1 nodes
        for (int i = 0; i < k-1; i++){
            ListNode tail = fast.next;
            ListNode moving = slow.next;
            slow.next = moving.next;
            moving.next = tail;
            fast.next = moving;
            System.out.print(fast.val);
            System.out.print(slow.val);
        }
        // Now fast is 1 step ahead. Move to k step ahead
        for (int i = 0; i < k-1 ; i++){
            if (fast.next == null) {
                return dummy.next;
            }
            else{
                fast = fast.next;
            }
        }
        // Both slow and fast move k
        for (int i = 0; i < k; i++) {
            if (fast.next == null) {
                return dummy.next;
            }
            else{
                fast = fast.next;
                slow = slow.next;
            }
        }
    }
    return dummy.next;
}

/* Test case
[3,4,5,6,7,8,9,10]
3
*/
/*
92. Reverse Linked List II

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    if (m == n) {
        return head;
    }
    // startTail head ... tail endHead
    ListNode startTail = dummyHead, partHead, tail, endHead, ptr;
    for (int i = 1; i < m; i++) {
        startTail = startTail.next;
    }
    partHead = startTail.next;
    tail = partHead;
    for (int i = m; i < n; i++){
        tail = tail.next;
    }
    endHead = tail.next;
    while (startTail.next != tail) {
        startTail.next = partHead.next;
        partHead.next = endHead;
        tail.next = partHead;
        endHead = partHead;
        partHead = startTail.next;
    }
    return dummyHead.next;
}

/* Test case
[1,2,3,4,5]
2
5
*/
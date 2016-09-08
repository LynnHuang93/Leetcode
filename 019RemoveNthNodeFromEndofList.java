/*
19. Remove Nth Node From End of List 

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

//
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i<n; i++){
            length++;
            cur = cur.next;
            if (cur==null) return dummyHead.next;
        }
        while(cur.next!=null){
            cur = cur.next;
            slow = slow.next;
        }
        if (n==1) slow.next = null;
        else slow.next = slow.next.next;
        return dummyHead.next;
    }
}

/* Test cases
[1,2]
3
[1]
1
*/
/*
24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null) {
        if (cur.next.next == null){
            break;
        }
        else {
            ListNode first = cur.next;
            cur.next = first.next;
            cur = cur.next;
            first.next = cur.next;
            cur.next = first;
            cur = first;
        }
    }
    return dummy.next;
}

/*
[3,4,5]
[3,4,5,6]
*/
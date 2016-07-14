/*
2. Add Two Numbers

You are given two linked lists representing two non-negative numbers. The digits are stored
 in reverse order and each of their nodes contain a single digit. Add the two numbers and
 return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Company Tags: Amazon Microsoft Bloomberg Airbnb Adobe
*/

// Note: adding length carry. l1 and l2 has different length.
// Careful: move next with null.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;
        int val = 0;
        while (carry > 0 || l1 != null || l2 != null) {
        	val = carry + (l1==null? 0:l1.val)+ (l2==null? 0:l2.val);
        	if (val > 9) {
        		val = val - 10;
        		carry = 1;
        	} else {
        		carry = 0;
        	}
        	head.next = new ListNode(val);
        	head = head.next;
        	l1 = l1==null? null:l1.next;
        	l2 = l2==null? null:l2.next;
        }
        return result.next;
    }
}
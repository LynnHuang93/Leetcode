/*
382. Linked List Random Node

Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
*/

// Probabilities of choosing value at each index for different Ns:
// N = 1: [1/1]
// N = 2: [1/2 * {1/1}, 1/2] = [1/2, 1/2]
// N = 3: [2/3 * {1/2, 1/2}, 1/3] = [2/6, 2/6, 1/3] = [1/3, 1/3, 1/3]
// N = 4: [3/4 * {1/3, 1/3, 1,3}, 1/4] = [3/12, 3/12, 3/12, 1/4] = [1/4, 1/4, 1/4, 1/4]
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int count = 2;
        ListNode p = head;
        int result = p.val;
        while(p.next != null) {
            p = p.next;
            if (rand.nextInt(count) == 0) {
                result = p.val;
            }
            count++;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

 /* Test case
 ["Solution","getRandom"]
[[[1,2,3]],[]]
*/
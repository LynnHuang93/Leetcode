/*
23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

// Merge sort O(nlogk) (if n is the total length of all lists)
public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    int i = 0;
    int j = lists.length - 1;
    while (j > 0) {
        while (i < j) {
            lists[i] = mergeTwoLists(lists[i], lists[j]);
            i++;
            j--;
        }
        i = 0;
    }
    return lists[0];
}

public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;
    while (node1 != null && node2 != null) {
        if (node1.val < node2.val) {
            cur.next = new ListNode(node1.val);
            cur = cur.next;
            node1 = node1.next;
        }
        else {
            cur.next = new ListNode(node2.val);
            cur = cur.next;
            node2 = node2.next;
        }
    }
    if (node1 != null) {
        cur.next = node1;
    }
    if (node2 != null) {
        cur.next = node2;
    }
    return dummyHead.next;
}

/* Test case
[[1],[2],[3],[]]
*/
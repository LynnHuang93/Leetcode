/*
252. Meeting Rooms

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
determine if a person could attend all meetings.

For example, Given [[0, 30],[5, 10],[15, 20]], return false.
*/

// Sort by [0], record the end, judge with next start, update end
public class Solution{
	public boolean meetingRooms(List<List<Integer>> l) {
        if (l.size() == 0) {
            return true;
        }
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((p1, p2)->p1.get(0)-p2.get(0));
        for (int i = 0; i < l.size(); i++) {
            queue.add(l.get(i));
        }
        int end = queue.poll().get(1);
        int len = queue.size();
        for (int i = 1; i < len; i++) {
            List<Integer> nextlist = queue.poll();
            if (nextlist.get(0)<end) {
                return false;
            } else {
                end = Math.max(nextlist.get(1), end);
            }
        }
        return true;
    }
}

/* Test case
[[0, 30],[5, 10],[15, 20]]
List<Integer> l1 = new ArrayList<>();
l1.add(0);
l1.add(30);
List<Integer> l2 = new ArrayList<>();
l2.add(5);
l2.add(10);
List<Integer> l3 = new ArrayList<>();
l3.add(15);
l3.add(20);
List<List<Integer>> l4 = new ArrayList<>();
l4.add(l1);
l4.add(l2);
l4.add(l3);
System.out.println(a.meetingRoomsII(l4));
*/
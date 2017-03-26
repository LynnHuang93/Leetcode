/*
253. Meeting Rooms 

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
*/

// Sort by [0], record the end, judge with next start, update end
public class Solution{
	public int meetingRoomsII(List<List<Integer>> l) {
        if (l.size() == 0) {
            return 0;
        }
        PriorityQueue<Integer> result = new PriorityQueue<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((p1, p2)->p1.get(0)-p2.get(0)==0? p1.get(1)-p2.get(1):p1.get(0)-p2.get(0));
        for (int i = 0; i < l.size(); i++) {
            queue.add(l.get(i));
        }
        while (queue.size()>0) {
            List<Integer> currentList = queue.poll();
            if (result.size() == 0) {
                result.add(currentList.get(1));
            } else {
                int start = currentList.get(0);
                int end = currentList.get(1);
                Iterator<Integer> itr = result.iterator();
                boolean update = false;
                while (itr.hasNext()) {
                    int next = itr.next();
                    if (next <= start) {
                        result.remove(next);
                        result.add(end);
                        update = true;
                        break;
                    }
                }
                if (!update) {
                    result.add(end);
                }
            }
        }
        return result.size();
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
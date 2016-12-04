/*
436. Find Right Interval

Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        HashMap<Interval, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i],i);
        }
        Arrays.sort(intervals, (i1,i2)->i1.start-i2.start);
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length ; i++) {
            int idx = rightInterval(intervals, i);
            res[map.get(intervals[i])] = idx == -1? -1 : map.get(intervals[idx]);
        }
        res[map.get(intervals[intervals.length - 1])] = -1;
        return res;
    }
    public int rightInterval(Interval[] intervals, int index) {
        int start = index + 1;
        int end = intervals.length - 1;
        int target = intervals[index].end;
        if (index == end || intervals[end].start < target) {
            return -1;
        }
        if (intervals[index + 1].start >= target) {
            return index + 1;
        }
        while (start <= end) {
            int mid = (start+end)/2;
            if (target == intervals[mid].start) {
                return mid;
            }
            if (target > intervals[mid].start) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return end;
    }
}

/* Test case
[ [1,4], [2,3], [3,4] ]
*/
/*
325. Maximum Size Subarray Sum Equals K

Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
*/

// Keep a map to record the index:sum pair
public class Solution {
    public int maxSubArrayLen(int[] l, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        for (int i = 0; i < l.length;i++) {
            sum += l[i];
            if (sum == target) {
                result = i+1;
            }
            else {
                if (map.containsKey(sum - target)) {
                    result = Math.max(result, i - map.get(sum-target));
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
        }
        return result;
    }
}

/* Test case
[1, -1, 5, -2, 3] 3
*/
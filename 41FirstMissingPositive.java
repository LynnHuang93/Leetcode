/*
41. First Missing Positive

Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

// Cannot deal with duplicate
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i:nums) {
            if (i >= 0) {
                sum ^= i;
                max = Math.max(max, i);
            }
        }
        if (max <= 0) {
            return 1;
        }
        int sumPlusRs = 0;
        for (int i = 0; i <= max; i++) {
            sumPlusRs ^= i;
        }
        // [1]
        if (sum == sumPlusRs) {
            return max+1;
        }
        else {
            return sum ^ sumPlusRs;
        }
    }
}
/*
213. House Robber II

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

// DP considering including start or not
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] record = new int[2];
        // Include first house
        record[0] = nums[0];
        record[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int tmp = record[1];
            record[1] = Math.max(record[0] + nums[i], record[1]);
            record[0] = tmp;
        }
        int result1 = Math.max(record[0], record[1]);
        // Exclude first house
        record[0] = 0;
        record[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int tmp = record[1];
            record[1] = Math.max(record[0] + nums[i], record[1]);
            record[0] = tmp;
        }
        int result2 = record[1];
        return Math.max(result1, result2);
    }
}

/* Test case
[1,2,3,4,5,4,3,2,1]
*/

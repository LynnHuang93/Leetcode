/*
268. Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/

// Bit operation: XOR
public class Solution {
    public int missingNumber(int[] nums) {
        int should = 0;
        for (int i = 1; i <= nums.length; i++) {
            should ^= i;
        }
        int actual = 0;
        for (int i = 0; i < nums.length; i++) {
            actual ^= nums[i];
        }
        // should   0   0   1   1
        // actual   0   1   0   1
        // miss     0   1   1   0
        return should ^ actual;
    }
}

/* Test case
[0]
*/
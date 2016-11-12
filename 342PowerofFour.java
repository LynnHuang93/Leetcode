/*
342. Power of Four

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
*/

public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num < 0) {
            return false;
        }
        int countOne = 0;
        int idx = -1;
        for (int i = 0; i < 32; i++){
            if ((num & 1) == 1) {
                if (countOne >= 1) {
                    return false;
                }
                countOne++;
                idx = i;
            }
            num = num >> 1;
        }
        if (countOne == 1 && idx % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}

/* Test case
8
*/
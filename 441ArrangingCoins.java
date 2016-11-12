/*
441. Arranging Coins

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
*/

public class Solution {
    public int arrangeCoins(int n) {
        int rs = 0;
        // Include n = 0 to take care of all rows complete condition
        while (n >= 0) {
            rs++;
            n = n - rs;
        }
        return rs - 1;
    }
}

/* Test case
3
*/
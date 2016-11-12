/*
400. Nth Digit

Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
*/

public class Solution {
	// Take care of overflow
    public int findNthDigit(int n) {
        int[] digit = {0,9,90,900,9000,90000,900000,9000000,90000000};
        // 2 ^ 31 = 2147483648
        // 1~9, 10~99, 100~999, 1000~9999,..., 1000000000~2147483648
        // 1,   2,     3,       4,         ... 10
        // 10-1,100-10,1000-100,10000-1000,...,10000000000-10000000000
        int pow = 1;
        for (int i = 1; i < 9; i++, pow = i) {
            int count = i * digit[i];
            if (n > count) {
                n -= count;
            }
            else {
                break;
            }
        }
        // Find how many digits left, say pow = 5, rest = 3
        int rest = n % pow;
        // Find the actual number, the numst number starting at 10^(pow-1)
        int num = n / pow + (int)Math.pow(10, pow - 1) - 1;
        if (rest == 0) {
            // Last digit
            return num % 10;
        }
        else {
            return Integer.parseInt(String.valueOf(num + 1).substring(rest-1,rest));
        }
    }
}

/* Test case
1000000000
*/
/*
343. Integer Break

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

Hint:

There is a simple O(n) solution to this problem.
You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
*/

public class Solution {
    public int integerBreak(int n) {
        // c = a + b, to make a*b larger, a-b must be min
        // eg. 4*4 > 3*5 > 2*6> 1*7
        // 3 > 1*2, 4 = 2*2, 5 < 2*3, 6 < 3*3
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 0;
        for (int i = 2; i <= n / 2; i++) {
            int p = n/i;
            if (n % i == 0) {
                result = Math.max(result, (int)Math.pow(i, p));
            }
            else {
                if (i == 2) {
                    result = Math.max(result, ((int)Math.pow(i, p-1))*3);
                }
                if (i == 3) {
                    if (n%i == 1) {
                        result = Math.max(result, ((int)Math.pow(i, p-1))*4);
                    }
                    else {
                        result = Math.max(result, ((int)Math.pow(i, p))*2);
                    }
                }
                else {
                    int res = n%i + i;
                    int a = res/2;
                    int b = res - a;
                    result = Math.max(result, ((int)Math.pow(i, p-1))*a*b);
                }
            }
        }
        return result;
    }
}

/*
54
49
*/
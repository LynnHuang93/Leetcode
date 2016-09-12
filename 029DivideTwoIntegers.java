/*
29. Divide Two Integers

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

// Originally could minus to dividend < divisor. O(n). But could double the num to minus to make it O(logn).
// 16 = 12 + 3 + 1 = 3 * (4 * 1 + 2 * 0 + 1 * 1) + 1. Find the biggest number to minus.
// result = 4 + 0 + 1
public int divide(int dividend, int divisor) {
    if (divisor == 0) {
        return Integer.MAX_VALUE;
    }
    if (dividend == 0) {
        return 0;
    }
    int isPos = 1;
    if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0){
        isPos = -1;
    }
    long res = 0;
    long lend = Math.abs((long)dividend);
    long lsor = Math.abs((long)divisor);
    while (lend >= lsor) {
        long sum = lsor;
        long time = 1;
        while (lend - sum > sum) {
            sum += sum;
            time += time;
        }
        lend -= sum;
        res += time;
    }
    // Take care of overflow
    if (res*isPos > Integer.MAX_VALUE){
        return Integer.MAX_VALUE;
    }
    if (res*isPos < Integer.MIN_VALUE){
        return Integer.MIN_VALUE;
    }
    return (int)res*isPos;
}

/* Test case
-2147483648
-1
*/
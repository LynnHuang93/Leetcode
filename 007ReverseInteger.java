/*
7. Reverse Integer

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Here are some good questions to ask before coding. Bonus points for you if you have 
already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit 
integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed 
integer overflows.
*/

//
public static int reverse(int x) {
	// Since we use /x, we need to make sure x != 0;
    if (x == 0) { return x;}
    int flag = Math.abs(x) / x;
    int y = Math.abs(x);
    long result = 0;
    while (y % 10 > 0 || y / 10 > 0) {
      	result = result * 10 + y % 10;
      	y = y / 10;
    }
    // Deal with overflow. Use long to record to result and compare with max/min int.
    if (result > Integer.MAX_VALUE || result * flag < Integer.MIN_VALUE) return 0;
    return (int)result * flag;
}

// Test method
public static void main(String[] args) {
    int test = -123;
    System.out.println(reverse(test));
    int test1 = 1534236469;
    System.out.println(Math.abs(test1));
}
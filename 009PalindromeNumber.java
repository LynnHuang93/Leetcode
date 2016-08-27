/*
9. Palindrome Number  

Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

// Use reverse integer and compare if equal.
public boolean isPalindrome(int x) {
    if (x < 0) { return false;}
	int y = x;
  	int result = 0;
  	while (y % 10 > 0 || y / 10 > 0) {
      	result = result * 10 + y % 10;
      	y = y / 10;
  	}
  	return result==x;
}

// Test method
public static void main(String[] args){
	int test1 = -123;
	System.out.println(isPalindrome(test1));
	int test2 = 1534236469;
	System.out.println(isPalindrome(test2));
	int test3 = 15351;
	System.out.println(isPalindrome(test3));
}
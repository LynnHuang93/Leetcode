/*
8. String to Integer (atoi)

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please 
do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input 
specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function 
signature accepts a const char * argument, please click the reload button  to reset 
your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the 
first non-whitespace character is found. Then, starting from this character, takes 
an optional initial plus or minus sign followed by as many numerical digits as 
possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral 
number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral 
number, or if no such sequence exists because either str is empty or it contains 
only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct 
value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN 
(-2147483648) is returned.
*/

// 
public static int myAtoi(String str) {
  	long result = 0;
  	// "" -> 0
  	if (str.length() == 0) {
  	    return 0;
  	}
  	// Ignore space in the beginning
  	int startIndex = 0;
  	for (int i = 0; i < str.length(); i++) {
  	    if (str.charAt(i) != ' ') {
  	        startIndex = i;
          	break;
  	    }
  	}
  	// Deal with the + - sign
    char c = str.charAt(startIndex);
  	int isPos = 1;
  	if (c - '0' >= 0 && c - '0' <= 9){
      	result = c - '0';
  	}
  	else {
      	if (c == '-') {
      		isPos = -1;
  		}
      	else {
        	if (c != '+') {
          		return 0;
            }
        }
  	}
  	for (int i = startIndex+1; i < str.length(); i++) {
      	c = str.charAt(i);
      	if (c - '0' >= 0 && c - '0' <= 9) {
          	result = result * 10 + c - '0';
        }
      	else {
          	break;
        }
        // Deal with overflow
        if (result * isPos > Integer.MAX_VALUE) {
      	return Integer.MAX_VALUE;
  	    }
  	    if (result * isPos < Integer.MIN_VALUE) {
      	return Integer.MIN_VALUE;
  	    }
  	}
  	result = result * isPos;
  	return (int)result;
}

// Test method
public static void main(String[] args) {
	String test1 = "  -248";
	System.out.println(myAtoi(test1));
	String test2 = " - 2 4+8";
	System.out.println(myAtoi(test2));
	String test3 = " -9223372036854775809";
	System.out.println(myAtoi(test3));
}
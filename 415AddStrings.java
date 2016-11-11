/*
415. Add Strings

Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

public String addStrings(String num1, String num2) {
    int carry = 0;
    // Make num1 shorter
    if (num2.length() < num1.length()) {
        String tmp = num2;
        num2 = num1;
        num1 = tmp;
    }
    String rs = "";
    int j = num2.length() - 1;
    for (int i = num1.length() - 1; i >= 0; i--, j-- ) {
        int sum = carry + num1.charAt(i) - '0' + num2.charAt(j) - '0';
        carry = sum >= 10 ? 1:0;
        rs = String.valueOf(sum%10) + rs;
    }
    for (;j >=0 ; j--) {
        if (carry == 0) {
            rs = num2.substring(0, j+1) + rs;
            break;
        }
        int sum = carry + num2.charAt(j) - '0';
        carry = sum >= 10 ? 1:0;
        rs = String.valueOf(sum%10) + rs;
    }
    return carry == 0 ? rs: "1"+rs;
}

/* Test case
"1309472"
"298357"
*/
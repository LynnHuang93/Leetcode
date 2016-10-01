/*
91. Decode Ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

// DP
public int numDecodings(String s) {
    int length = s.length();
    int[] dp = new int[length + 1];
    // Take care about the initialize
    dp[0] = 1;
    if (length == 0) {
        return 0;
    }
    dp[1] = (s.charAt(0) - '0' >= 1 && s.charAt(0) - '0' <= 9) ? 1:0;
    if (length > 1) {
        for (int index = 1; index < length; index++) {
            int num1 = s.charAt(index) - '0';
            int num1Valid = 1;
            if (num1 < 1 || num1 > 9) {
                num1Valid = 0;
            }
            int num2 = Integer.parseInt(s.substring(index - 1, index + 1));
            int num2Valid = 1;
            // 01 is not valid
            if (num2 < 10 || num2 > 26) {
                num2Valid = 0;
            }
            dp[index + 1] = dp[index] * num1Valid + dp[index - 1] * num2Valid;
        }
    }
    return dp[length];
}

/* Test case
"01"
"1206"
*/
/*
409. Longest Palindrome

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

public int longestPalindrome(String s) {
    int[] alphabet = new int[52];
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c - 'a' >= 0 && c - 'z' <= 0) {
            alphabet[c - 'a'] += 1;
        }
        if (c - 'A' >= 0 && c - 'Z' <= 0) {
            alphabet[c - 'A' + 26] += 1;
        }
    }
    int result = 0;
    int single = 0;
    for (int i = 0; i < 52; i++) {
        int count = alphabet[i];
        if (count % 2 == 0){
            result += count;
        }
        else {
            result += count - 1;
            single = 1;
        }
    }
    return single + result;
}

/*
"abccccdd"
*/
/*
125. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        int slen = s.length();
        int start = 0;
        int end = slen - 1;
        while (start < end){
            char st = s.charAt(start), en = s.charAt(end);
            if (!((st - 'a' >= 0 && st - 'z' <= 0) || (st - 'A' >= 0 && st - 'Z' <= 0) || (st - '0' >= 0 && st - '9' <= 0))) {
                start++;
                continue;
            }
            if (!((en - 'a' >= 0 && en - 'z' <= 0) || (en - 'A' >= 0 && en - 'Z' <= 0) || (en - '0' >= 0 && en - '9' <= 0))) {
                end--;
                continue;
            }
            if (s.charAt(start) - s.charAt(end) == 0 || st - en == 'A' - 'a' && st - 'A' >= 0 && st - 'Z' <= 0 || st - en == 'a' - 'A' && st - 'a' >= 0 && st - 'z' <= 0) {
                start++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}

/* Test case
"0P"		// '0' - 'P' = 'a' - 'A'
*/
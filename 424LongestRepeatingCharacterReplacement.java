/*
424. Longest Repeating Character Replacement

Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*/

public class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        // record how many occurance of each letter
        HashMap<Character, Integer> alphabet = new HashMap<>();
        int len = s.length();
        // start = end|... includes no letter
        int start = 0, end = 0;
        int res = 0;
        while (end <= len) {
            if (start == end || end - start - k <= Collections.max(alphabet.values())) {
                res = Math.max(res, end - start);
                if (end == len) {
                    break;
                }
                else {
                    // expand
                    char cur = s.charAt(end);
                    end++;
                    if (alphabet.containsKey(cur)) {
                        alphabet.put(cur, alphabet.get(cur)+1);
                    }
                    else {
                        alphabet.put(cur, 1);
                    }
                }
            }
            else{
                // shrink
                char cur = s.charAt(start);
                start++;
                if (alphabet.get(cur) == 1) {
                    alphabet.remove(cur);
                }
                else {
                    alphabet.put(cur, alphabet.get(cur)-1);
                }
            }
        }
        return res;
    }
}

/* Test case
"AABABBA"
1
*/
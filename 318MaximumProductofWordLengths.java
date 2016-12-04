/*
318. Maximum Product of Word Lengths

Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/

public class Solution {
    public int maxProduct(String[] words) {
        int[] intOfAlphabet = new int[words.length];
        for (int k = 0; k < words.length; k++) {
            int[] alphabet = new int[26];
            String s = words[k];
            for (int i = 0; i < s.length(); i++) {
                alphabet[s.charAt(i)-'a'] += 1;
            }
            intOfAlphabet[k] = alphabetListToInt(alphabet);
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((intOfAlphabet[i]&intOfAlphabet[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
    
    // [2,4,3,0,...] -> 1110...
    public int alphabetListToInt(int[] alphabet) {
        int result = 0;
        for (int a:alphabet) {
            if (a > 0) {
                result++;
            }
            result = result << 1;
        }
        return result;
    }
    
    // Not needed here but used for calculate product of different letters
    // 9 -> 1001 -> 2
    public int countNoneZero(int i) {
        int count = 0;
        while (i != 0) {
            int n = i&1;
            count += n;
            i = i >> 1;
        }
        return count;
    }
}

/* Test case
["eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"]
*/
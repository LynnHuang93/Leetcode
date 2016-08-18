/*
3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkikeikaw", the answer is "wke", with the length of 3. Note that the answer must be a
 substring, "pwke" is a subsequence and not a substring.

Company Tags: Amazon Adobe Bloomberg Yelp
*/

// Use hashmap. Store the character and index pair. Use two pointer for head and tail. Use tail to
// do the traverse. Use head to mark the last occured number. 
// Basic idea is to have characters occur once. Second time occur reset head. Cost O(n).
public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	if (s.length()<=1){
    		return s.length();
    	}
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
        	if (map.containsKey(s.charAt(i))) {
        		// Take care not to count the old character: +1
        		j = Math.max(j, map.get(s.charAt(i)) + 1);
        	}
        	map.put(s.charAt(i), i);
        	max = Math.max(max, i - j + 1);
        }
        return max;
    }
}

//Test method
/*
public static void main(String[] args) {
    String str = "pwwkew";
    System.out.print(lengthOfLongestSubstring(str));
}
*/
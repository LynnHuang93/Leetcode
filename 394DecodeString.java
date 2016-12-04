/*
394. Decode String

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

public class Solution {
    public String decodeString(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();
        str.push("");
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            // take care of "13"
            int n = 0;
            while (cur - '0' >= 0 && cur - '9' <= 0) {
                n = n*10 + cur - '0';
                i++;
                cur = s.charAt(i);
            }
            if (n != 0) {
                num.push(n);
            }
            if (cur == '[') {
                str.push("");
                continue;
            }
            if (cur == ']') {
                String subres = decodeStringHelper(num.pop(), str.pop());
                str.push(str.pop() + subres);
            }
            else {
                str.push(str.pop() + Character.toString(cur));
            }
        }
        String res = "";
        while(!str.isEmpty()) {
            res = str.pop() + res;
        }
        return res;
    }
    
    private String decodeStringHelper(int repeat, String subString) {
        String res = "";
        for (int i = 0; i < repeat; i++) {
            res += subString;
        }
        return res;
    }
}

/* Test case
"10[a]2[bc3[c]]ef"
*/
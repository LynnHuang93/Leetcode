/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
*/

//
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
        return "";
    }
    String str1 = strs[0];
    int index = str1.length();
    String prefix = str1;
    for (int i = 1; i < strs.length; i++){
        if (strs[i].length() < index || !strs[i].substring(0, index).equals(prefix)){
            int length = Math.min(strs[i].length(), prefix.length());
            index = 0;
            if (length == 0 || strs[i].charAt(0)!=prefix.charAt(0)) {return "";}
            while (index < length && strs[i].charAt(index)==prefix.charAt(index)) {
                index++;
            }
            // substring does not contain last index char.
            prefix = str1.substring(0, index);
        }
    }
    return prefix;
}

/* Test case
"ab","aa",""
*/
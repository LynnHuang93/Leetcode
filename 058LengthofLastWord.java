/*
58. Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

// Count from the end.
public int lengthOfLastWord(String s) {
    int count = 0;
    int index = s.length() - 1;
    // Eliminate non-sence ending space. Check index in case OOB
    while (index >= 0 && s.charAt(index) == ' ') {
        index--;
    }
    // Count last word chars
    while (index >= 0 && s.charAt(index) !=' ') {
        index--;
        count++;
    }
    return count;
}

/* Test case
""
*/

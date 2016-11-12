/*
165. Compare Version Numbers

Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Nums = version1.split("\\.");
        String[] version2Nums = version2.split("\\.");
        int len1 = version1Nums.length, len2 = version2Nums.length;
        // 1 = 1.0 < 1.1
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int v1 = i < len1 ? Integer.parseInt(version1Nums[i]) : 0;
            int v2 = i < len2 ? Integer.parseInt(version2Nums[i]) : 0;
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
}

/* Test case
"1"
"1.1"
"1"
"1.0"
*/
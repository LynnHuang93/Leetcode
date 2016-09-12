/*
28. Implement strStr()

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

//
public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null) {
        return -1;
    }
    int flag = 0;
    int l1 = haystack.length();
    int l2 = needle.length();
    if (l2 == 0) {
        return 0;
    }
    if (l1 == 0 || l1 < l2) {
        return -1;
    }
    for (int i = 0; i <= l1 - l2; i++){
        flag = 0;
        for (int j = 0; j < l2; j++) {
            if (haystack.charAt(i+j)!=needle.charAt(j)){
                break;
            }
            else {
                flag++;
            }
        }
        if (flag == l2) {
            return i;
        }
    }
    return -1;
}

/* Test case
""
""
"a"
"a"
*/
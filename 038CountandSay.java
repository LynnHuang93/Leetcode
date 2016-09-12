/*
38. Count and Say

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

//
public String countAndSay(int n) {
    String res = "";
    if (n <= 0) {
        return res;
    }
    res += "1";
    int say = 1;
    while (say < n) {
        String subres = "";
        for (int i = 0; i < res.length(); i++) {
            int count = 1;
            while (i < res.length() - 1 && res.charAt(i) == res.charAt(i+1)) {
                i++;
                count++;
            }
            subres += Integer.toString(count) + Character.toString(res.charAt(i));
        }
        res = subres;
        say++;
    }
    return res;
}

/* Test case
5
*/
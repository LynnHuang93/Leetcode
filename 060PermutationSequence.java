/*
60. Permutation Sequence

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

// Basic idea is to calulate right part is the Kth smallest and do recursivelypublic class Solution {
public String getPermutation(int n, int k) {
    String result = "";
    int[] set = new int[n];
    for (int i = 1; i <= n; i++) {
        set[i-1] = i;
    }
    for (int i = n; i > 0; i--) {
        int rightNum = 1;
        int cur = 1;
        while (cur < i) {
            rightNum *= cur++;
        }
        // Here is a tricky part related to the ranking and grouping
        // Group 1:123, 132 -> 1/2 = 0, 2/2 = 0 but we want both output to be 1
        int LthSmallest = (k - 1) / rightNum + 1;
        k = (k - 1) % rightNum + 1;
        result += findkthInRest(set, n, LthSmallest);
    }
    return result;
}
private String findkthInRest(int[] set, int n, int k) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
        if (set[i-1]!=0) {
            count++;
            if (count == k) {
                set[i-1] = 0;
                return Integer.toString(i);
            }
        }
    }
    return "error";
}

/* Test case
3
4
*/
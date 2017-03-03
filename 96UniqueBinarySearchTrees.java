/*
96. Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class Solution {
    public int numTrees(int n) {
        if (n == 1) {
            return n;
        }
        List<Integer> l = new ArrayList<>();
        // n[i] represent trees has i layer of right most child;
        l.add(1);
        for (int i = 1; i <= n; i++) {
            List<Integer> newl = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int sum = 0;
                for (int k = j == 0? j:j-1; k < l.size(); k++) {
                    sum += l.get(k);
                }
                newl.add(sum);
            }
            l = newl;
        }
        int sum = 0;
        for (int i:l) {
            sum += i;
        }
        return sum;
    }
}

/* Test case
4
*/
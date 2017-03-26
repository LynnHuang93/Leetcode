/*
277. Find the Celebrity

Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
*/

// traverse once to get the most possible
public class Solution{
    public int findCelebrity(int[] l){
        if (l.length<=1) {
            return -1;
        }
        int result = 0;
        for (int i = 0; i < l.length; i++) {
            if (result != i && knows(l[result],l[i])) {
                result = i;
            }
        }
        for (int i = 0; i < l.length; i++) {
            if (result != i) {
                if (!knows(l[i], l[result]) || knows(l[result],l[i])){
                    return -1;
                }
            }
        }
        return result;
    }
}

/* Test case
[1,1,1,0,1,1]
    public boolean knows(int a, int b) {
        // 0 is celebrity
        if (a == 0 && b == 1) {
            return false;
        }
        if (b == 0 && a == 1) {
            return true;
        }
        return false;
    }
*/
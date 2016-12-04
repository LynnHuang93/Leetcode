/*
319. Bulb Switcher

There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.
*/

// For big integers like 10000000, TLE
public class Solution {
    public int bulbSwitch(int n) {
        boolean[] bulb = new boolean[n];
        for (int i = 1; i <= n; i++) {
            int idx = -1;
            while (idx+i < n) {
                idx += i;
                bulb[idx] = !bulb[idx];
            }
        }
        int result = 0;
        for (boolean b:bulb) {
            if (b) {
                result++;
            }
        }
        return result;
    }

    // Find how many perfect square numbers no more than n
    // 1: 1 on
    // 2: 1 2 on off
    // 3: 1 3 on off off
    // 4: 1 2 4 on off off on
    // 5: 1 5 on off off on off
    // bulb of k: [bulb of k-1], factor number even? on : off
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
}

/* Test case
10000000
*/
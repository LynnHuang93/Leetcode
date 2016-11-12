/*
414. Third Maximum Number

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

public class Solution {
    public int thirdMax(int[] nums) {
        int[] max = new int[3];
        // deal with less than 3 due to replica
        boolean[] flag = new boolean[3];
        max[0] = nums[0];
        flag[0] = true;
        if (nums.length == 1) {
            return max[1];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == max[0] || flag[1] && nums[i] == max[1] || flag[2] && nums[i] == max[2]) {
                continue;
            }
            if (!flag[1]) {
                flag[1] = true;
                max[1] = Math.min(max[0], nums[i]);
                max[0] = Math.max(max[0], nums[i]);
                continue;
            }
            if (!flag[2]) {
                flag[2] = true;
                if (nums[i] > max[0]) {
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = nums[i];
                    continue;
                }
                if (nums[i] > max[1]) {
                    max[2] = max[1];
                    max[1] = nums[i];
                    continue;
                }
                else{
                    max[2] = nums[i];
                    continue;
                }
            }
            if (nums[i] >= max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = nums[i];
                continue;
            }
            if (nums[i] >= max[1]) {
                max[2] = max[1];
                max[1] = nums[i];
                continue;
            }
            if (nums[i] >= max[2]) {
                max[2] = nums[i];
                continue;
            }
        }
        if (!flag[2]) {
            return max[0];
        }
        else {
            return max[2];
        }
    }
}

/* Test case
[2,2,3,1]
*/
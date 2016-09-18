/*
53. Maximum Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

public int maxSubArray(int[] nums) {
    int max = nums[0];
    int sum = nums[0] > 0 ? nums[0] : 0;
    for (int i = 1; i < nums.length; i++) {
        // If past subarray <= 0, start new one.
        if (sum <= 0) {
            sum = nums[i];
        }
        else {
            sum += nums[i];
        }
        max = Math.max(sum, max);
    }
    return max;
}

/* Test case
[-2,1,-3,4,-1,2,1,-5,4]
*/
/*
16. 3Sum Closest
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

//

public static int threeSumClosest(int[] nums, int target) {
    int length = nums.length;
    if (length < 3) {return -1;}
    if (length == 3) {return nums[0]+nums[1]+nums[2];}
    Arrays.sort(nums);
    if (nums[length-3]+nums[length-2]+nums[length-1]<=target) {
        return nums[length-3]+nums[length-2]+nums[length-1];//short  cut
    }
    if (nums[0] + nums[1] + nums[2]>=target) {
        return nums[0] + nums[1] + nums[2];//short cut
    }
    int result = nums[0]+nums[1]+nums[2];
    int dif = Math.abs(result - target);
    for (int i = 0; i < length - 2; i++) {
        if (i != 0 && nums[i] == nums[i-1]) {
            continue;
        }
        for (int j = i + 1, k = length - 1; j < k;) {
            int sum = nums[i] + nums[j] + nums[k];
            if (Math.abs(sum - target) < dif) {
                result = sum;
                dif = Math.abs(sum - target);
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    k--;
                }
                if (sum < target) {
                    j++;
                }
                while (j < k && j > i+1 && nums[j] == nums[j-1]) {
                    j++;
                }
                while (j < k && k < length - 1 && nums[k] == nums[k+1]) {
                    k--;
                }
            }
            else {
                if (sum > target) {
                    k--;
                }
                if (sum < target) {
                    j++;
                }
            }
        }
    }
    return result;
}

/* Test case
{1,1,1,1} 1
*/
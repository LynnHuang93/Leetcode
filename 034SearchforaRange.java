/*
34. Search for a Range

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

//

public int[] searchRange(int[] nums, int target) {
    int[] res = {-1, -1};
    int length = nums.length;
    // Target not in range
    if (nums[0] > target || nums[length-1] < target) {
        return res;
    }
    int start = 0;
    int end = length;
    int medium = (start + end)/2;
    // Find a medium that equals target
    while (start <= end){
        if (nums[medium] == target) {
            break;
        }
        if (nums[medium] > target) {
            end = medium - 1;
        }
        else{
            start = medium + 1;
        }
        medium = (start + end)/2;
    }
    // Target not exist
    if (nums[medium] != target) {
        return res;
    }
    else {
    	// Use the previous interval directly
        int res1 = medium;
        int res2 = medium;
        int leftMedium = (start + medium)/2;
        int leftStart = start;
        int leftEnd = medium;
        int rightMedium = (medium + end)/2;
        int rightStart = medium;
        int rightEnd = end;
        // Find the first target
        while (res1 > 0 && leftStart <= leftEnd) {
            if (nums[leftMedium] == target) {
                res1 = leftMedium;
                leftEnd = leftMedium - 1;
                leftMedium = (leftStart + leftEnd)/2;
                continue;
            }
            else{
                leftStart = leftMedium + 1;
            }
            leftMedium = (leftStart + leftEnd)/2;
        }
        // Find the last target
        while (res2 < length -1 && rightStart <= rightEnd) {
            if (nums[rightMedium] == target) {
                res2 = rightMedium;
                rightStart = rightMedium + 1;
                rightMedium = (rightStart + rightEnd)/2;
                continue;
            }
            else{
                rightEnd = rightMedium - 1;
            }
            rightMedium = (rightStart + rightEnd)/2;
        }
        res[0] = res1;
        res[1] = res2;
    }
    return res;
}

/* Test case
[5, 7, 7, 8, 8, 10]
8
*/
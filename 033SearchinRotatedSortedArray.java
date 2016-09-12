/*
33. Search in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

//
public int search(int[] nums, int target) {
    int length = nums.length;
    if (length == 0) {
        return -1;
    }
    int start = 0;
    int end = length - 1;
    int medium = 0;
    while (start <= end) {
        // Not rotated.
        if (nums[start] < nums[end]) {
            if (target < nums[start] || target > nums[end]) {
                return -1;
            }
            else {
                medium = (start + end) / 2;
                if (nums[medium] == target) {
                    return medium;
                }
                if (nums[medium] < target) {
                    start = medium + 1;
                }
                else {
                    end = medium - 1;
                }
                continue;
            }
        }
        // Rotated
        else {
            if (target < nums[start] && target > nums[end]) {
                return -1;
            }
            else {
                medium = (start + end) / 2;
                if (nums[medium] == target) {
                    return medium;
                }
                // [3,4,5,6,7,1,2]
                if (nums[medium] > nums[start]) {
                    if (nums[start] == target) {
                        return start;
                    }
                    if (nums[medium] > target && nums[start] < target) {
                        end = medium - 1;
                    }
                    else {
                        start = medium + 1;
                    }
                    continue;
                }
                // [6,7,1,2,3,4,5]
                else {
                	// Consider 2 elements like [7,0], need to judge if end is target.
                    if (nums[end] == target) {
                        return end;
                    }
                    if (nums[medium] < target && nums[end] > target) {
                        start = medium + 1;
                    }
                    else {
                        end = medium - 1;
                    }
                    continue;
                }
            }
        }
    }
    return -1;
}

/* Test case
[3,1]
1
[4,5,6,7,0,1,2,3]
1
*/
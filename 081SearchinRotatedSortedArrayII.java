/*
81. Search in Rotated Sorted Array II

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

// If 3, 4, 5, 1, 2, 3 then cannot tell if it is rotated or not from start and end
// So only judge it is in range or not, then judge if it is target when only 2 nums
public boolean search(int[] nums, int target) {
    if (nums.length == 0) {
        return false;
    }
    int start = 0;
    int end = nums.length - 1;
    return searchHelper(nums, target, start, end);
}
    
public boolean searchHelper(int[] nums, int target,int start, int end) {
    if (start < end - 1) {
        int medium = (start + end) / 2;
        // Not rotated
        if (nums[start] < nums[end]) {
            // Out of range
            if (nums[start] > target || nums[end] < target) {
                return false;
            }
            if (nums[medium] == target) {
                return true;
            }
            if (nums[medium] > target) {
                return searchHelper(nums, target, start, medium - 1);
            }
            else {
                return searchHelper(nums, target, medium + 1, end);
            }
        }
        // Rotated or flat
        else {
            // Out of range
            if (nums[start] > target && nums[end] < target) {
                return false;
            }
            if (nums[medium] == target) {
                return true;
            }
            if (target > nums[start] && target < nums[medium]) {
                return searchHelper(nums, target, start, medium - 1);
            }
            else {
                if (target > nums[medium] && target < nums[end]) {
                    return searchHelper(nums, target, medium + 1, end);
                }
                else {
                    return searchHelper(nums, target, medium + 1, end) || searchHelper(nums, target, start, medium - 1);
                }
            }
        }
    }
    return target == nums[start] || target == nums[end];
}

/* Test case
[3,4,5,1,2,3]
1
*/
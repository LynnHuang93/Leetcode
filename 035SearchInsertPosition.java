/*
35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

//
public int searchInsert(int[] nums, int target) {
    int length = nums.length;
    // Deal with one element array ([1],1) also
    if (nums[0] >= target) {
        return 0;
    }
    if (nums[length - 1] < target) {
        return length;
    }
    int start = 0;
    int end = length - 1;
    int medium = (start + end) / 2;
    // Loop until [a,b] is left
    while (end - start > 1) {
        if (nums[medium] == target) {
            return medium;
        }
        if (nums[medium] > target) {
            end = medium;
        }
        else {
            start = medium;
        }
        medium = (start + end) / 2;
    }
    if (nums[start] == target){
        return nums[start];
    }
    else {
        return end;
    }
}

/* Test case
[1,3]
1
[1]
1
*/
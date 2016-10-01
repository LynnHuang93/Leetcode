/*
80. Remove Duplicates from Sorted Array II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums
being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
        return nums.length;
    }
    int count = 1;
    int length = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == nums[i-1]) {
            if (count == 1) {
                count++;
                nums[length] = nums[i];
                length++;
            }
        }
        else {
            count = 1;
            nums[length] = nums[i];
            length++;
        }
    }
    return length;
}

/* Test case
[1,1,1,2,2,3]
*/
/*
75. Sort Colors

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

// Basic idea is to have 2 indices to record the end of 0 and start of 2
// If we meet 0 or 2 between indices, exchange and index get closer 
public void sortColors(int[] nums) {
    int length = nums.length;
    if (length == 0) {
        return;
    }
    // End of 0
    int start = -1;
    // Start of 2
    int end = length;
    int index = start;
    int loop = start + 1;
    while (loop < end) {
        if (nums[loop] == 0) {
            nums[loop] = nums[start + 1];
            nums[start + 1 ] = 0;
            start++;
            // After exchange, nums[loop] has been judged
            loop++;
            continue;
        }
        if (nums[loop] == 2) {
            nums[loop] = nums[end - 1];
            nums[end - 1] = 2;
            end--;
            // After exchange, nums[loop] have not been judged
            continue;
        }
        loop++;
    }
}

/*
[2,0,0]
*/
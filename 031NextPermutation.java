/*
31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

// Basic idea is to find the smallest right part in desc order. Change the digit before with the smallest one bigger
// than it. After the change, the right part is still in desc order. Reverse it.
public void nextPermutation(int[] nums) {
    int length = nums.length;
    int index = -1;
    // 716543 Find leftward the first pair which nums[i] < num[i+1]
    for (int i = length - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
            index = i;
            break;
        }
    }
    if (index == -1) {
        Arrays.sort(nums);
    }
    else {
        // Find the leftmost num that > nums[i], swap index-th and index2-th 
        int index2 = -1;
        for (int i = length -1; i > index; i--) {
            if (nums[i] > nums[index]) {
                index2 = i;
                int tmp = nums[index];
                nums[index] = nums[index2];
                nums[index2] = tmp;
                break;
            }
        }
        // Reverse the part after index
        for (int i = 1; index + i < length - i; i++) {
            int tmp = nums[length - i];
            nums[length - i] = nums[index + i];
            nums[index + i] = tmp;
        }
    }
}

/* Test case
[2,1,5,9,7,2]
*/
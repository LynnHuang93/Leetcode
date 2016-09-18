/*
55. Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

// Recursive. Can do but will cause stack overflow.
public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) {
        return false;
    }
    for (int start = 0; start < nums.length; start++) {
        if (canJumpHelper(nums, start)) {
            return true;
        }
    }
    return false;
}

public boolean canJumpHelper(int[] nums, int index) {
    if (index + nums[index] >= nums.length-1) {
        return true;
    }
    else {
        Boolean flag = false;
        for (int i = 1; i <= nums[index]; i++) {
            flag = flag || canJumpHelper(nums, i);
        }
        return flag;
    }
}

// Use stack. TLE
public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) {
        return false;
    }
    if (nums.length == 1 && nums[0] == 0) {
        return true;
    }
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(0);
    while (!stack.isEmpty()) {
        int index = stack.pop();
        int step = nums[index];
        if (step == 0) {
            continue;
        }
        if (index + step >= nums.length - 1) {
            return true;
        }
        for (int i = 1; i <= step; i++) {
            stack.push(index + i);
        }
    }
    return false;
}

// The nature of this question is that for an index to be reachable, each of the previous indices 
// have to be reachable. So just keep record of the furthest.
public boolean canJump(int[] nums) {
    int furthest = 0;
    for (int i = 0; i < nums.length; i++) {
        if (furthest >= nums.length - 1) {
            return true;
        }
        if (i > furthest) {
            return false;
        }
        else {
            furthest = Math.max(furthest, i + nums[i]);
        }
    }
    return true;
}

/* Test case
[0]
[2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,
5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,
7,5,1,7,9,6]
*/
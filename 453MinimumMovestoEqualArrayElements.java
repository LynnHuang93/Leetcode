/*
453. Minimum Moves to Equal Array Elements

Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
*/

// TLE
public int minMoves(int[] nums) {
    if (nums.length == 1){
        return 0;
    }
    Arrays.sort(nums);
    if (nums.length == 2) {
        return nums[1] - nums[0];
    }
    if (nums[0] == nums[nums.length - 2]) {
        return nums[nums.length - 1] - nums[0];
    }
    int move = nums[nums.length - 1] - nums[0];
    nums[nums.length - 1] = nums[0];
    return minMoves(nums) + move;
}

public int minMoves(int[] nums) {
    if (nums.length <= 1) {
        return 0;
    }
    int min = nums[0];
    for (int i : nums) {
        min = Math.min(i, min);
    }
    int sum = 0;
    for (int i : nums) {
        sum += i - min;
    }
    return sum;
}

/* Test case
[537,410,756,667,312,62,136,229,846,902,956,752,853,999,547,245,905,807,594,387,91,165,492,53,268,417]
*/
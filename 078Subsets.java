/*
78. Subsets

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

// Use bit operation
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int num = 1 << nums.length;
    // Num from 0~2^n-1 e.g. n = 3 : 000 - 111
    for (int i = 0; i < num; i++) {
        // Note not use i directly. Otherwise will cause dead loop
        int subnum = i;
        List<Integer> subset = new ArrayList<>();
        for (int digit = 0; digit < nums.length; digit++) {
            if ((subnum & 1) == 1) {
                subset.add(nums[digit]);
            }
            subnum = subnum >> 1;
        }
        result.add(subset);
    }
    return result;
}

/* Test case
[1,2,3]
*/
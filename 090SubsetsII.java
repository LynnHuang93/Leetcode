/*
90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

// DFS & backtracking
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Arrays.sort(nums);
    subsetsWithDupHelper(nums, result, path, 0);
    return result;
}
public void subsetsWithDupHelper(int[] nums, List<List<Integer>> result, List<Integer> path, int index) {
    result.add(new ArrayList<>(path));
    for (int i = index; i < nums.length; i++) {
        if (i == index) {
            path.add(nums[i]);
            subsetsWithDupHelper(nums, result, path, i + 1);
            path.remove(path.size() - 1);
        }
        else {
            if (nums[i] != nums[i - 1]) {
                path.add(nums[i]);
                subsetsWithDupHelper(nums, result, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}

/* Test case
[1,2,2]
*/
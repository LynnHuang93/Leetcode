/*
46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

// Typical DFS
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length== 0) {
        return result;
    }
    HashSet<Integer> set = new HashSet<Integer>();
    List<Integer> path = new ArrayList<Integer>();
    DFS(result, set, path, nums);
    return result;
}
private void DFS(List<List<Integer>> result, HashSet<Integer> set, List<Integer> path, int[] nums) {
    if (set.size() == nums.length) {
        result.add(new ArrayList<Integer>(path));
    }
    else {
        for (int i : nums) {
            if (set.add(i)) {
                path.add(i);
                DFS(result, set, path, nums);
                set.remove(i);
                path.remove(path.size() - 1);
            }
        }
    }
}

/* Test case
[1,2,3]
*/
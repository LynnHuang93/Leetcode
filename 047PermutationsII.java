/*
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

// Use a HashMap to count the occurance of numbers
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length == 0) {
        return result;
    }
    Arrays.sort(nums);
    HashMap<Integer, Integer> cur = new HashMap<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
        if (map.containsKey(i)) {
            map.put(i, map.get(i)+1);
        }
        else {
            map.put(i, 1);
            cur.put(i, 0);
        }
    }
    List<Integer> path = new ArrayList<Integer>();
    DFS(result, path, nums, map, cur);
    return result;
}

private void DFS(List<List<Integer>> result, List<Integer> path, int[] nums, HashMap<Integer, Integer> map, HashMap<Integer, Integer> cur) {
    if (path.size() == nums.length) {
        result.add(new ArrayList<Integer>(path));
    }
    else {
        int prev = -1;
        for (int i = 0 ; i < nums.length; i++) {
            if ( (prev == -1 || nums[i] != nums[prev]) && cur.get(nums[i]) < map.get(nums[i])) {
                cur.put(nums[i], cur.get(nums[i])+1);
                path.add(nums[i]);
                prev = i;
                DFS(result, path, nums, map, cur);
                cur.put(nums[i], cur.get(nums[i])-1);
                path.remove(path.size()-1);
            }
        }
    }
}

/* Test case
[1,2,1]
*/
/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 
1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

// DFS & backtrack
public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if (k > n) {
        return result;
    }
    List<Integer> path = new ArrayList<>();
    combineHelper(result, path, n, k);
    return result;
}

public void combineHelper(List<List<Integer>> result, List<Integer> path, int n, int k) {
    if (k == 0) {
        result.add(new ArrayList<Integer>(path));
    }
    else {
        if (path.size() == 0) {
            for (int i = 1; i <= n; i++) {
                path.add(i);
                combineHelper(result, path, n, k-1);
                path.remove(path.size() - 1);
            }
        }
        else {
            int prev = path.get(path.size()-1);
            for (int i = prev + 1; i <= n; i++) {
                path.add(i);
                combineHelper(result, path, n, k-1);
                path.remove(path.size() - 1);
            }
        }
    }
}

/* Test case
4
2
*/
/*
40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    int listLen = candidates.length;
    if (listLen < 1) {
        return result;
    }
    Arrays.sort(candidates);
    List<Integer> solution = new ArrayList<Integer>();
    help(result, solution, candidates, target, listLen - 1);
    return result;
}

public void help(List<List<Integer>> result, List<Integer> solution, int[] candidates, int target, int index) {
    if (target == 0) {
        List<Integer> newSolution = new ArrayList<>();
        newSolution.addAll(solution);
        result.add(newSolution);
    }
    if (target < 0) {
        return;
    }
    int prev = -1;
    for (int i = index; i >= 0; i--) {
        if (candidates[i] != prev) {
            solution.add(candidates[i]);
            prev = candidates[i];
            help(result, solution, candidates, target - candidates[i], i - 1);
            solution.remove(solution.size()-1);
        }
    }
}

/* Test case
[10, 1, 2, 7, 6, 1, 5]
8
*/
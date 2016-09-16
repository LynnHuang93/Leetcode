/*
39. Combination Sum

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

// Basic idea is to minus from the largest number.
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (candidates.length == 0) {
        return result;
    }
    Arrays.sort(candidates);
    HashSet<Integer> set = new HashSet<>();
    for (int i : candidates) {
        set.add(i);
    }
    List<Integer> solution = new ArrayList<>();
    help(result, solution, candidates, target, candidates.length - 1);
    return result;
}

public void help(List<List<Integer>> result, List<Integer> solution, int[] candidates, int target, int index) {
    for (int i = index; i >= 0; i--) {
        int rest = target - candidates[i];
        if (rest < 0) {
            // If current digit is too big, go to smaller one.
            continue;
        }
        // Find a solution, add to result.
        if (rest == 0) {
            List<Integer> newSolution = new ArrayList<>();
            newSolution.addAll(solution);
            newSolution.add(candidates[i]);
            result.add(newSolution);
        }
        // Find a possible candidate, add to solution list and find subsolutions.
        if (rest > 0) {
            solution.add(candidates[i]);
            help(result, solution, candidates, rest, i);
        }
    }
    // With given solution set, all possible subsolution has been covered above.
    // Delete the last element to find another solution set until empty.
    if (solution.size() > 0) {
       solution.remove(solution.size() - 1);
    }
}

/* Test case
[1,2]
1
*/
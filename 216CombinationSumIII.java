/*
216. Combination Sum III

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

// Backtracking
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        combinationSum3Helper(result, solution, 0, n, 1, k);
        return result;
    }
    
    public void combinationSum3Helper(List<List<Integer>> result, List<Integer> solution, int sum, int n, int start, int k) {
        if (sum > n || solution.size() > k) {
            return;
        }
        if (sum == n && solution.size() == k) {
            result.add(new ArrayList<Integer>(solution));
        }
        for (int i = start; i < 10; i++) {
            solution.add(i);
            combinationSum3Helper(result, solution, sum+i, n, i+1, k);
            solution.remove(solution.size()-1);
        }
    }
}

/* Test case
3
7
*/
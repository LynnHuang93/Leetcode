/*
15. 3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

// Add loop over 2 sum. O(n^2)
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    if (nums == null || nums.length < 3) {
        return result;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length-2; i++) {
    	// Skip duplicate numbers. Take care about index oob when 0.
        if ( i != 0 && nums[i] == nums[i-1] ){
            continue;
        }
        for (int j = i+1, k = nums.length-1; j<k;) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                List<Integer> solution = new LinkedList<>();
                solution.add(nums[i]);
                solution.add(nums[j]);
                solution.add(nums[k]);
                result.add(solution);
                j++;
                k--;
                // Skip duplicate numbers.
                while (j < k && nums[j] == nums[j-1]){
                    j++;
                }
                while (j < k && nums[k] == nums[k+1]){
                    k--;
                }
            }
            else {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
            }
        }
    }
    return result;
}
//


/* Test case
[-1, -4, 1, 2, -1]
*/
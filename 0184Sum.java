/*
18. 4Sum

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/


public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    int sum = 0;
    if (nums.length < 4) {
        return result;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; i++) {
        if (i != 0 && nums[i] == nums[i-1]) {
            continue;
        }
        for (int j = i + 1; j < nums.length - 2; j++){
            if (j != i+1 && nums[j] == nums[j-1]){
                continue;
            }
            for (int k = j+1, l = nums.length - 1; k<l;){
                if (k != j+1 && nums[k] == nums[k-1]) {
                    k++;
                    continue;
                }
                if (l != nums.length - 1 && nums[l] == nums[l+1]) {
                    l--;
                    continue;
                }
                sum = nums[i] + nums[j] + nums[k] + nums[l];
                if (sum < target) {
                    k++;
                }
                else {
                    if (sum > target) {
                        l--;
                    }
                    else{
                        List<Integer> solution = new ArrayList<Integer>();
                        solution.add(nums[i]);
                        solution.add(nums[j]);
                        solution.add(nums[k]);
                        solution.add(nums[l]);
                        result.add(solution);
                        k++;
                        l--;
                    }
                }
            }
        }
    }
    return result;
}

/* Test case
[1,0,-1,0,-2,2]
*/

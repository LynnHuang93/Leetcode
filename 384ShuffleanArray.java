/*
384. Shuffle an Array

Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

public class Solution {
    
	// Pass 9/10 test cases. Not random enough.
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        int[] res = new int[nums.length];
        List<Integer> idx = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            idx.add(i);
        }
        while(idx.size() != 0) {
            int index = rand.nextInt(idx.size());
            res[idx.get(index)] = nums[idx.size()-1];
            idx.remove(idx.get(index));
        }
        return res;
    }

    // shuffle based on result rather than original nums[] random better
    int[] nums;
    int[] out;

    public Solution(int[] nums) {
        this.nums = nums;
        this.out = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.out[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        int[] res = new int[out.length];
        List<Integer> idx = new ArrayList<Integer>();
        for (int i = 0; i < out.length; i++) {
            idx.add(i);
        }
        while(idx.size() != 0) {
            int index = rand.nextInt(idx.size());
            res[idx.get(index)] = out[idx.size()-1];
            idx.remove(idx.get(index));
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
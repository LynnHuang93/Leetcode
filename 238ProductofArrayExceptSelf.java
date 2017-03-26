/*
238. Product of Array Except Self

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result1 = new int[nums.length];
		int acc1 = 1;
		result1[nums.length-1] = acc1;
		// multiply from last. eg. a5*a4 for a3
		for (int i = nums.length-2; i >= 0;i--){
			acc1 *= nums[i+1];
			result1[i]=acc1;
		}
		int acc2 = 1;
		int[] result2 = new int[nums.length];
		result2[0]=1;
		// multiply from the beginning. eg. a1*a2 for a3
		for (int i = 1; i < nums.length; i++){
			acc2 *= nums[i-1];
			result2[i]=acc2;
		}
		// multiply the product of a1,a2 and a4,a5 for a3
		for (int i = 0; i < nums.length; i++){
			result2[i]*=result1[i];
		}
		return result2;
    }
}
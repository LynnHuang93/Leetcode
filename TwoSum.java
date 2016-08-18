/*
1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Company Tags: LinkedIn Uber Airbnb Facebook Amazon Microsoft Apple Yahoo Dropbox Bloomberg Yelp Adobe
*/

// The original thought is to do loop to each element. O(n^2) Skip here.

// We can order the list in O(nlogn), make a list for the new indices mapping the orinigal 
// indices then take two pointer from the beginning and the end until they meets in O(n).
// This solution cannot deal with nums list with duplicate numbers. O(nlogn)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
        	map.put(nums[i],i);
        }
        int index1 = 0, index2 = nums.length - 1;
        int[] result = new int[2];
		nums = Array.sortArray(nums);
        while (index1<=index2){
        	if (nums[index1] + nums[index2] == target){
        		result[0] = map.get(nums[index1]);
        		result[1] = map.get(nums[index2]);
        		return result;
        	}
        	if (nums[index1] + nums[index2] < target){
        		index1++;
        	}
        	if (nums[index1] + nums[index2] > target){
        		index2--;
        	}
        }
        return result;
    }
}

// If the nums list have duplicate numbers, do the sort by hand. Also make a list to record
// the index mapping. Here I choose merge sort because it is stable and quick. Also O(nlogn)
public class Solution {
	public int[] twoSum(int[] nums, int target) {
		// Sort nums with index. Same traverse above. 
	}
	public void merge(int arr[], int temp_arr[], int start_index, int mid_index, int end_index) {
      int i = start_index, j = mid_index + 1;
      int k = 0;
      while (i < mid_index + 1 && j < end_index + 1)
      {
          if (arr[i] > arr[j])
              temp_arr[k++] = arr[j++];
          else
              temp_arr[k++] = arr[i++];
      }
      while (i < mid_index + 1)
      {
          temp_arr[k++] = arr[i++];
      }
      while (j < end_index + 1)
          temp_arr[k++] = arr[j++];

      for (i = 0, j = start_index; j < end_index + 1; i ++, j ++)
          arr[j] = temp_arr[i];
  }

	public void merge_sort(int arr[], int temp_arr[], int start_index, int end_index){
      if (start_index < end_index)
      {
          int mid_index = (start_index + end_index) / 2;
          merge_sort(arr, temp_arr, start_index, mid_index);
          merge_sort(arr, temp_arr, mid_index + 1, end_index);
          merge(arr, temp_arr, start_index, mid_index, end_index);
      }
  }
}

// Best Solution: since only one answer could be found, so we can do it in O(n). Take the number,
// put it's adder needed for the target as key in a HashMap with it's index. If traverse to the
// adder, return it's index and the value with adder key.
public class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++){
			if (map.containsKey(nums[i])){
				result[0] = map.get(nums[i]);
				result[1] = i;
				return result;
			}
			else{
				map.put(target - nums[i], i);
			}
		}
		return result;
	}
}

// Test method
/*
public static void main(String[] args){
  int[] nums = {2,7,11,15};
  int target = 9;
  int[] result = twoSum(nums, target);
  System.out.print(result[0]);
  System.out.print(result[1]);
}
*/
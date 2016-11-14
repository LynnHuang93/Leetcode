/*
167. Two Sum II - Input array is sorted

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        int sum = 0;
        while (start<end) {
            sum = numbers[start] + numbers[end];
            if (sum == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
            if (sum > target) {
                end = nextEnd(numbers, start+1, end, target - numbers[start]);
                continue;
            }
            if (sum < target) {
                start = nextStart(numbers, start, end-1, target - numbers[end]);
                continue;
            }
        }
        return result;
    }
    // largest smaller
    public int nextEnd(int[] num, int start, int end, int target) {
        int left = start, right = end;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == target) {
                return mid;
            }
            if (num[mid] > target) {
                right = mid - 1;
            }
            else {
                if (mid == right || num[mid + 1] > target) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return right;
    }
    // smallest larger
    public int nextStart(int[] num, int start, int end, int target) {
        int left = start, right = end;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            if (num[mid]==target) {
                return mid;
            }
            if (num[mid] < target) {
                left = mid + 1;
            }
            else {
                if (mid == left || num[mid-1] < target) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return left;
    }
}

/* Test case
[0,0,3,4]
0
*/
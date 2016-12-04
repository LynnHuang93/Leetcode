/*
108. Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBSTHelper(0, nums.length-1, nums);
    }
    
    public TreeNode arrayToBSTHelper(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBSTHelper(start, mid-1, nums);
        root.right = arrayToBSTHelper(mid+1, end, nums);
        return root;
    }
}

/* Test case
[1,2,3,4,6,7]
*/
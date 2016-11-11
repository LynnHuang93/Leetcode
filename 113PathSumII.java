/*
113. Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
 // Simple DFS
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> path = new ArrayList<>();
        path.add(root);
        pathSumHelper(result, path, sum);
        return result;
    }
    public void pathSumHelper(List<List<Integer>> result, List<TreeNode> path, int target) {
        TreeNode last = path.get(path.size()-1);
        if (last.left == null && last.right == null) {
            int sum = 0;
            List<Integer> solution = new ArrayList<>();
            for (TreeNode n : path) {
                sum += n.val;
                solution.add(n.val);
            }
            if (sum == target) {
                result.add(solution);
            }
        }
        else {
            if (last.left != null) {
                path.add(last.left);
                pathSumHelper(result, path, target);
                path.remove(path.size() - 1);
            }
            if (last.right != null) {
                path.add(last.right);
                pathSumHelper(result, path, target);
                path.remove(path.size() - 1);
            }
        }
    }
}

/* Test case
[5,4,8,11,null,13,4,7,2,null,null,5,1]
22
*/
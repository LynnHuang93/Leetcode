/*
144. Binary Tree Preorder Traversal 

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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
	// Iteratively traverse tree: stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // List used as a stack here
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.get(0);
            q.remove(0);
            res.add(cur.val);
            // Add right first so left will be pop first
            if (cur.right != null) {
                q.add(0, cur.right);
            }
            if (cur.left != null) {
                q.add(0, cur.left);
            }
        }
        return res;
    }
}

/* Test case
[1,4,3,2,5,6,7]
*/
/*
404. Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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

public int sumOfLeftLeaves(TreeNode root) {
    int result = 0;
    if (root == null) {
        result = 0;
    }
    else {
        if (root.left != null && isLeaf(root.left)) {
            result = root.left.val + sumOfLeftLeaves(root.right);
        }
        else {
            result = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
    return result;
}

private boolean isLeaf(TreeNode root) {
    return root.left == null && root.right == null;
}

/* Test case
[3,9,20,null,null,15,7]
*/
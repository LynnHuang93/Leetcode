/*
98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
*/

// DFS
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stk = new Stack<>();
    // Take care of [] input
    if (root == null) {
        return true;
    }
    stk.push(root);
    while (!stk.isEmpty()) {
        TreeNode cur = stk.pop();
        if (cur.left != null) {
            if (cur.left.val >= cur.val) {
                return false;
            }
            stk.push(cur.left);
            // Biggest(right most) element in left tree is smaller than root
            TreeNode rightMost = cur.left.right;
            while(rightMost != null) {
                if (rightMost.val >= cur.val) {
                    return false;
                }
                rightMost = rightMost.right;
            }
        }
        if (cur.right != null) {
            if (cur.right.val <= cur.val) {
                return false;
            }
            stk.push(cur.right);
            TreeNode leftMost = cur.right.left;
            while(leftMost != null) {
                if (leftMost.val <= cur.val) {
                    return false;
                }
                leftMost = leftMost.left;
            }
        }
    }
    return true;
}

/* Test case
[10,5,15,null,null,6,20]
*/
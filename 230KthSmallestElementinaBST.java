/*
230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
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

// Use size of subtree
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftSize = size(root.left);
        if (k <= leftSize) {
            return kthSmallest(root.left, k);
        }
        if (k == leftSize + 1) {
            return root.val;
        }
        else {
            return kthSmallest(root.right, k - leftSize - 1);
        }
    }
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        else {
            if (root.left == null ) {
                return 1+size(root.right);
            }
            if (root.right == null) {
                return 1+size(root.left);
            }
            else {
                return 1+size(root.left) + size(root.right);
            }
        }
    }
}

// inorder recursive
public class Solution {
	int count = 0;
	int result = Integer.MIN_VALUE;

	public int kthSmallest(TreeNode root, int k) {
	    traverse(root, k);
	    return result;
	}

	public void traverse(TreeNode root, int k) {
	    if(root == null) return;
	    traverse(root.left, k);
	    count ++;
	    if(count == k) result = root.val;
	    traverse(root.right, k);       
	}
}

// inorder iterative
public class Solution {
	private Stack<TreeNode> s;
	public int kthSmallest(TreeNode root, int k) {
	    s=new Stack<TreeNode>();
	    if(root==null)  return 0;
	    
	    pushLeft(root);
	    while(!s.empty()){
	       
	        TreeNode tn=s.pop();
	        if(--k==0)
	            return tn.val;
	        if(tn.right!=null)  
	            pushLeft(tn.right);
	    }
	    return 0;
	}
	private void pushLeft(TreeNode root){
	    
	    s.push(root);
	    TreeNode p=root.left;
	    while(p!=null){
	        s.push(p);
	        p=p.left;
	        
	    }
	}
}

/* Test case
[5,3,6,1,4,null,7,null,2]
3
*/
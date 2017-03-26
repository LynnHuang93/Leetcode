/*
173. Binary Search Tree Iterator

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/

// Typical iterative inorder traverse. binary tree inorder iterator. 
// Use a stack to store the path to the most left leaf node.
// During the traverse (next()), if current node has a right child, move to right and keep pushing left util leaf node

public class BSTIterator {  
    Stack<TreeNode> stack;  
  
    public BSTIterator(TreeNode root) {  
        stack = new Stack<TreeNode>();  
        while (root != null) {  
            stack.push(root);  
            root = root.left;  
        }  
    }  
  
    /** @return whether we have a next smallest number */  
    public boolean hasNext() {  
        return !stack.isEmpty();  
    }  
  
    /** @return the next smallest number */  
    public int next() {  
        TreeNode node = stack.pop();  
        int ret = node.val;  
        if (node.right != null) {  
            node = node.right;  
            while (node != null) {  
                stack.push(node);  
                node = node.left;  
            }  
        }  
        return ret;  
    }  
} 
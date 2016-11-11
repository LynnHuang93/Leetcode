/*
257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/

// Simple dfs
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> path = new ArrayList<>();
        path.add(root);
        binaryTreePathsHelper(path, root, result);
        return result;
    }
    
    public void binaryTreePathsHelper(List<TreeNode> path, TreeNode cur, List<String> result) {
        if (cur.left == null && cur.right == null) {
            String paths = String.valueOf(path.get(0).val);
            for (int i = 1; i < path.size(); i++) {
                paths += "->" + String.valueOf(path.get(i).val);
            }
            result.add(paths);
        }
        else {
            if (cur.left != null) {
                path.add(cur.left);
                binaryTreePathsHelper(path, cur.left, result);
                path.remove(path.size() - 1);
            }
            if (cur.right != null) {
                path.add(cur.right);
                binaryTreePathsHelper(path, cur.right, result);
                path.remove(path.size() - 1);
            }
        }
    }
}

/* Test case
[1,2,3,null,5]
*/
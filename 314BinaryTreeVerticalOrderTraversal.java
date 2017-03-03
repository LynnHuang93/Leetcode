/*
314. Binary Tree Vertical Order Traversal
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,20,4,5,2,7],
    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]
*/

// calculate the column for each node recursively and keep in map
public class Solution{
    public List<List<Integer>> binaryTreeVerticalOrderTraversal(TreeNode root) {
        Map<Integer, List> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList();
        binaryTreeVerticalOrderTraversalHelper(map, root, 0);
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (Integer i:map.keySet()) {
            p.add(i);
        }
        while(!p.isEmpty()) {
            result.add(map.get(p.poll()));
        }
        return result;
    }

    public void binaryTreeVerticalOrderTraversalHelper(Map<Integer, List> map, TreeNode root, int column) {
        if (root!= null) {
            if (map.containsKey(column)) {
                map.get(column).add(root.val);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(root.val);
                map.put(column, l);
            }
            binaryTreeVerticalOrderTraversalHelper(map, root.left, column - 1);
            binaryTreeVerticalOrderTraversalHelper(map, root.right, column + 1);
        }
    }
}

/* Test case
[3,9,20,null,null,15,7]
*/
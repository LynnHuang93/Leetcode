/*
378. Kth Smallest Element in a Sorted Matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

// Build heap on first elements then replace smallest
public class Solution {
    public class Cell{
        int rowN, columnN, val;
        
        Cell(int r, int c, int v) {
            this.rowN = r;
            this.columnN = c;
            this.val = v;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cell> q = new PriorityQueue<>((p1,p2)->p1.val - p2.val);
        for (int i = 0; i < matrix.length; i++) {
            Cell c = new Cell(i,0,matrix[i][0]);
            q.add(c);
        }
        Cell c = null;
        for (int i = 0; i < k; i++) {
            c = q.poll();
            if (c.columnN+1 < matrix[c.rowN].length) {
                Cell n = new Cell(c.rowN, c.columnN+1,matrix[c.rowN][c.columnN+1]);
                q.add(n);
            }
        }
        return c.val;
    }
}

/* Test case
[[1,5,9],[10,11,13],[12,13,15]]
8
*/
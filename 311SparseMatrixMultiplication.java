/*
311. Sparse Matrix Multiplication

Problem Description:

Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/

// check each element in m1 for non-zero and then m2, add to result
public class Solution{
    public int[][] sparseMatrixMultiplication(int[][] m1, int[][] m2) {
        int k = m1[0].length;
        int l = m2[0].length;
        int[][] result = new int[m1.length][l];
        for (int m1i = 0; m1i < m1.length; m1i++) {
            for (int m1j = 0; m1j < k; m1j++) {
                if (m1[m1i][m1j] != 0) {
                    for (int x = 0; x < l; x++) {
                        if (m2[m1j][x] != 0) {
                            result[m1i][x] += m1[m1i][m1j]*m2[m1j][x];
                        }
                    }
                }
            }
        }
        return result;
    }
}

/* Test cases
int[][] m1 = new int[2][3];
m1[0] = new int[]{1,0,0};
m1[1] = new int[]{-1,0,3};
int[][] m2 = new int[3][3];
m2[0] = new int[]{7,0,0};
m2[2] = new int[]{0,0,1};
int[][] result = solution.sparseMatrixMultiplication(m1, m2);
*/
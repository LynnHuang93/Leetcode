/*
62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/

// Recursive. TLE for big column/rows
public int uniquePaths(int m, int n) {
    return uniquePathsHelper(1, 1, m, n);
}
public int uniquePathsHelper(int curM, int curN, int targetM, int targetN) {
    if (curM > targetM || curN > targetN) {
        return 0;
    }
    if (curM == targetM && curN == targetN) {
        return 1;
    }
    else {
        return uniquePathsHelper(curM + 1, curN, targetM, targetN) + uniquePathsHelper(curM, curN + 1, targetM, targetN);
    }
}

// Simple DP
public int uniquePaths(int m, int n) {
    if (m <= 0 || n <= 0) {
        return 0;
    }
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++){
            if (i == 0) {
                result[i][j] = 1;
            }
            else {
                if (j == 0) {
                    result[i][j] = 1;
                }
                else {
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }
    }
    return result[m-1][n-1];
}

/* Test case
1
3
*/
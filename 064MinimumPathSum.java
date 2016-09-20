/*
64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public int minPathSum(int[][] grid) {
    int rowNum = grid.length;
    if (rowNum == 0) {
        return 0;
    }
    int columnNum = grid[0].length;
    if (columnNum == 0) {
        return 0;
    }
    int[][] record = new int[rowNum][columnNum];
    for (int i = 0; i < rowNum; i++) {
        for (int j = 0; j < columnNum; j++) {
            if (i == 0 && j == 0) {
                record[i][j] = grid[i][j];
                continue;
            }
            if (i == 0) {
                record[i][j] = grid[i][j] + record[i][j - 1];
                continue;
            }
            if (j == 0) {
                record[i][j] = grid[i][j] + record[i - 1][j];
                continue;
            }
            record[i][j] = Math.min(record[i - 1][j], record[i][j - 1]) + grid[i][j];
        }
    }
    return record[rowNum - 1][columnNum - 1];
}

/* Test case
[[0,2,3,4],[2,5,3,7],[8,5,2,0]]
*/
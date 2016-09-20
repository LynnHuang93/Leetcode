/*
63. Unique Paths II

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

// Simple DP
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int rowNum = obstacleGrid.length;
    if (rowNum == 0) {
        return 0;
    }
    int columnNum = obstacleGrid[0].length;
    if (columnNum == 0) {
        return 0;
    }
    int[][] result = new int[rowNum][columnNum];
    for (int i = 0; i < rowNum; i++) {
        for (int j = 0; j < columnNum; j++) {
            if (obstacleGrid[i][j] == 1) {
                result[i][j] = 0;
                continue;
            }
            // No obstacle at [i][j]
            if (i == 0 && j == 0) {
                result[i][j] = 1;
            }
            else {
                if (i == 0) {
                    result[i][j] = result[i][j - 1];
                }
                else {
                    if (j == 0) {
                        result[i][j] = result[i - 1][j];
                    }
                    else {
                        result[i][j] = result[i - 1][j] + result[i][j - 1];
                    }
                }
            }
        }
    }
    return result[rowNum - 1][columnNum - 1];
}

/* Test case
[[0, 0, 0],[1, 1, 0], [0, 0, 0]]
*/
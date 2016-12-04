/*
200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int columns = grid[0].length;
        if (columns == 0) {
            return 0;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    checkCell(grid, i, j);
                }
            }
        }
        return result;
    }
    
    public void checkCell(char[][] grid, int i, int j){
        if ( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            checkCell(grid, i-1, j);
            checkCell(grid, i+1, j);
            checkCell(grid, i, j-1);
            checkCell(grid, i, j+1);
        }
    }
}

/* Test case
["11000","11000","00100","00011"]
*/
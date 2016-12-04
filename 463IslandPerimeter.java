/*
463. Island Perimeter

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
*/

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    // upper line
                    if (i == 0 || grid[i-1][j] == 0) {
                        result++;
                    }
                    // bottom line
                    if (i == rows-1 || grid[i+1][j] == 0) {
                        result++;
                    }
                    // left line
                    if (j == 0 || grid[i][j-1] == 0) {
                        result++;
                    }
                    // right line
                    if (j == columns-1 || grid[i][j+1] == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}

/* Test case
[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
*/
/*
74. Search a 2D Matrix 

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

// Binary search in 2 dimension
public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    if (rows == 0) {
        return false;
    }
    int columns = matrix[0].length;
    if (columns == 0) {
        return false;
    }
    // See if target in the matrix
    if (target < matrix[0][0] || target > matrix[rows - 1][columns - 1]) {
        return false;
    }
    // Binary search find the row
    int rowStart = 0;
    int rowEnd = rows - 1;
    while (rowEnd > rowStart) {
        int medium = (rowEnd + rowStart) / 2;
        if (matrix[medium][columns - 1] >= target && matrix[medium][0] <= target) {
            rowEnd = medium;
            rowStart = medium;
            break;
        }
        if (matrix[medium][columns - 1] < target) {
            rowStart = medium + 1;
            continue;
        }
        if (matrix[medium][0] > target) {
            rowEnd = medium - 1;
            continue;
        }
    }
    int row = rowStart;
    int columnStart = 0;
    int columnEnd = columns - 1;
    while (columnEnd > columnStart) {
        if (matrix[row][columnStart] > target || matrix[row][columnEnd] < target) {
            return false;
        }
        if (matrix[row][columnStart] == target || matrix[row][columnEnd] == target) {
            return true;
        }
        int medium = (columnStart + columnEnd) / 2;
        if (matrix[row][medium] == target) {
            return true;
        }
        if (matrix[row][medium] > target) {
            columnEnd = medium - 1;
        }
        else {
            columnStart = medium + 1;
        }
    }
    // Possible that did not jump into column loop and did not judge equal [[1]] 1
    if (matrix[row][columnStart] == target) {
        return true;
    }
    return false;
}

/* Test case
[[1]]
1
*/
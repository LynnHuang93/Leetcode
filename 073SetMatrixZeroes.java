/*
73. Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do 
it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

// This is a recursive wrong answer. Basic ideas is to divide matrix into smaller
// ones. This discard some 0s when we get 0 in the same line.
// eg:[[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
public void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    if (rows == 0) {
        return;
    }
    int columns = matrix[0].length;
    setZeroesHelper(0, rows-1, 0, columns-1, matrix);
}
public void setZeroesHelper(int rowStart, int rowEnd, int columnStart, int columnEnd, int[][] matrix) {
    if (rowStart == rowEnd) {
        for (int i = columnStart; i <= columnEnd; i++) {
            if (matrix[rowStart][i] == 0) {
                for (int j = columnStart; j <= columnEnd; j++) {
                    matrix[rowStart][j] = 0;
                }
                return;
            }
        }
    }
    if (columnStart == columnEnd) {
        for (int i = rowStart; i <= rowEnd; i++) {
            if (matrix[i][columnStart] == 0) {
                for (int j = rowStart; j <= rowEnd; j++) {
                    matrix[j][columnStart] = 0;
                }
                return;
            }
        }
    }
    for (int i = rowStart; i <= rowEnd; i++) {
        for (int j = columnStart; j <= columnEnd; j++) {
            if (matrix[i][j] == 0) {
                // set 0s
                for (int x = rowStart; x <= rowEnd; x++) {
                    matrix[x][j] = 0;
                }
                for (int x = columnStart; x <= columnEnd; x++) {
                    matrix[i][x] = 0;
                }
                // deal with rest parts
                if (i == rowStart) {
                    if (j == columnStart) {
                        setZeroesHelper(rowStart+1, rowEnd, columnStart+1, columnEnd, matrix);
                    }
                    else {
                        if (j == columnEnd) {
                            setZeroesHelper(rowStart+1, rowEnd, columnStart, columnEnd-1, matrix);
                        }
                        else {
                            setZeroesHelper(rowStart+1, rowEnd, columnStart, j-1, matrix);
                            setZeroesHelper(rowStart+1, rowEnd, j+1, columnEnd, matrix);
                        }
                    }
                }
                else {
                    if (i == rowEnd) {
                        if (j == columnStart) {
                            setZeroesHelper(rowStart, rowEnd-1, columnStart+1, columnEnd, matrix);
                        }
                        else {
                            if (j == columnEnd) {
                                setZeroesHelper(rowStart, rowEnd-1, columnStart, columnEnd-1, matrix);
                            }
                            else {
                                setZeroesHelper(rowStart, rowEnd-1, columnStart, j-1, matrix);
                                setZeroesHelper(rowStart, rowEnd-1, j+1, columnEnd, matrix);
                            }
                        }
                    }
                    else {
                        if (j == columnStart) {
                            setZeroesHelper(rowStart, i-1, columnStart+1, columnEnd, matrix);
                            setZeroesHelper(i+1, rowEnd, columnStart+1, columnEnd, matrix);
                        }
                        else {
                            if (j == columnEnd) {
                                setZeroesHelper(rowStart, i-1, columnStart, columnEnd-1, matrix);
                                setZeroesHelper(i+1, rowEnd, columnStart, columnEnd-1, matrix);
                            }
                            else {
                                setZeroesHelper(rowStart, i-1, columnStart, j-1, matrix);
                                setZeroesHelper(rowStart, i-1, j+1, columnEnd, matrix);
                                setZeroesHelper(i+1, rowEnd, columnStart, j-1, matrix);
                                setZeroesHelper(i+1, rowEnd, j+1, columnEnd, matrix);
                            }
                        }
                    }
                }
                return;
            } 
        }
    }
}

// This is the right answer with O(1) space and O(mn) time
// Use matrix[0][j] represent if a column should be set 0
// Use matrix[i][0] represent if a row should be set 0
// matrix[0][0] represent if column 0 should be set 0
// Use a integer to represent if row 0 should be set 0
public void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    if (rows == 0) {
        return;
    }
    int columns = matrix[0].length;
    if (columns == 0) {
        return;
    }
    int storeFirstColumn = 1;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            if (matrix[i][j] == 0) {
                if (j == 0) {
                    storeFirstColumn = 0;
                }
                else {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
    }
    // Go through columns apart from first column
    for (int j = 1; j < columns; j++) {
        if (matrix[0][j] == 0) {
            for (int i = 1; i < rows; i++) {
                matrix[i][j] = 0;
            }
        }
    }
    // Go through rows
    for (int i = 0; i < rows; i++) {
        if (matrix[i][0] == 0) {
            for (int j = 1; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    // Deal with first column
    if (storeFirstColumn == 0) {
        for (int i = 0; i < rows; i++) {
            matrix[i][0] = 0;
        }
    }
}

/* Test case
[[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
*/
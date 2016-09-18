/*
54. Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

// Basic idea is to find when it stops
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<Integer>();
    int rowNum = matrix.length;
    // Deal with []
    if (rowNum == 0) {
        return result;
    }
    int columnNum = matrix[0].length;
    // Deal with [[]]
    if (columnNum == 0) {
        return result;
    }
    int row = 0;
    int column = 0;
    while (row <= (rowNum - 1) / 2 && column <= (columnNum -1) / 2) {
        for (int i = column; i < columnNum - 1 - column; i++) {
            result.add(matrix[row][i]);
        }
        // Stop at ->
        if (row * 2 + 1 == rowNum) {
            result.add(matrix[row][columnNum - 1 - column]);
            return result;
        }
        for (int i = row; i < rowNum - 1 - row; i++) {
            result.add(matrix[i][columnNum - 1 - column]);
        }
        // Stop at v
        if (column * 2 + 1 == columnNum) {
            result.add(matrix[rowNum - 1 - row][columnNum - 1 - column]);
            return result;
        }
        for (int i = columnNum - 1 - column; i > column; i--) {
            result.add(matrix[rowNum - 1 - row][i]);
        }
        // Stop at <-
        if (row * 2 + 2 == rowNum) {
            result.add(matrix[rowNum - 1 - row][column]);
            return result;
        }
        for (int i = rowNum - 1 - row; i > row; i--) {
            result.add(matrix[i][column]);
        }
        // Stop at ^
        if (column * 2 + 2 == columnNum) {
            return result;
        }
        row++;
        column++;
    }
    return result;
}

/* Test case
[]
[[3],[2],[1]]
*/
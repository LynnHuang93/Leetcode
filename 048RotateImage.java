/*
48. Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

// Basic idea is to exchange between \ and then between |
public void rotate(int[][] matrix) {
    int size = matrix.length;
    if (size == 0) {
        return;
    }
    // [00,01,02]    [00,10,20]    [20,10,00]
    // [10,11,12] -> [01,11,21] -> [21,11,01]
    // [20,21,22]    [02,12,22]    [22,12,02]
    // \ matrix[i][j] <-> matrix[j][i]
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < i; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = tm;
        }
    }
    // | matrix[i][j] <-> matrix[n-1-i][j]
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size/2; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[i][size - 1 - j];
            matrix[i][size - 1 - j] = tmp;
        }
    }
}

/* Test case
[[1,2,3],[1,2,3],[1,2,3]]
*/
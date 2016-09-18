/*
59. Spiral Matrix II

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

// --|  This way will leave one element a problem.
// |--  When n odd, i = n - 1 - i. Need to deal with that.
public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    int num = 1;
    int index = 0;
    while (index <= (n - 1) / 2) {
        for (int i = index; i < n - 1 - index; i++) {
            result[index][i] = num++;
        }
        // v
        for (int i = index; i < n - 1 - index; i++) {
            result[i][n - 1 - index] = num++;
        }
        // <-
        for (int i = n - 1 - index; i > index; i--) {
            result[n - 1 - index][i] = num++;
        }
        // ^
        for (int i = n - 1 - index; i > index; i--) {
            result[i][index] = num++;
        }
        index++;
    }
    // When n odd, take care of last element like 9.
    if (num == n * n) {
        result[n/2][n/2] = n * n;
    }
    return result;
}

/* Test case
3
*/
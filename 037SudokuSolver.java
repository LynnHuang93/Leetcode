/*
37. Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.

5 3 . . 7 . . . .
6 . . 1 9 5 . . .
. 9 8 . . . . 6 .
8 . . . 6 . . . 3
4 . . 8 . 3 . . 1
7 . . . 2 . . . 6
. 6 . . . . 2 8 .
. . . 4 1 9 . . 5
. . . . 8 . . 7 9

A sudoku puzzle...


...and its solution numbers marked in red.
*/

// BFS
public void solveSudoku(char[][] board) {
    solver(board);
}

public boolean solver(char[][] board) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.'){
                continue;
            }
            for (int k = 1; k <= 9; k++) {
                char c = (char) (k + '0');
                board[i][j] = c;
                if (validSodoku(board, i, j) && solver(board)) {
                    return true;
                }
                board[i][j] = '.';
            }
            return false;
        }
    }
    return true;
}

public boolean validSodoku(char[][] board, int i, int j) {
    return validColumn(board,i,j) && validRow(board,i,j) && validBox(board,i,j);
}

public boolean validColumn(char[][] board, int i, int j) {
    HashSet<Character> set = new HashSet<Character>();
    for (int k = 0; k < 9; k++){
        if (board[k][j] != '.') {
            if (set.contains(board[k][j])) {
                return false;
            }
            else {
                set.add(board[k][j]);
            }
        }
    }
    return true;
}
public boolean validRow(char[][] board, int i, int j) {
    HashSet<Character> set = new HashSet<Character>();
    for (int k = 0; k < 9; k++){
        if (board[i][k] != '.') {
            if (set.contains(board[i][k])) {
                return false;
            }
            else {
                set.add(board[i][k]);
            }
        }
    }
    return true;
}
public boolean validBox(char[][] board, int i, int j) {
    int centeri, centerj;
    if (i <=2 ) { centeri = 1;}
    else { 
        if (i <= 5) {centeri = 4;}
        else {centeri = 7;}
    }
    if (j <=2) { centerj = 1;}
    else { 
        if (j <= 5) {centerj = 4;}
        else {centerj = 7;}
    }
    HashSet<Character> set = new HashSet<Character>();
    for (int x = centeri - 1; x <= centeri + 1; x++) {
        for (int y = centerj - 1; y <= centerj + 1; y++){
            if (board[x][y] != '.') {
                if (set.contains(board[x][y])) {
                    return false;
                }
                else {
                    set.add(board[x][y]);
                }
            }
        }
    }
    return true;
}
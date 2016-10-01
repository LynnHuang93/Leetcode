/*
79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where
"adjacent" cells are those horizontally or vertically neighboring. The same letter
cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

// This only works if could use cell repeatedly.
public boolean exist(char[][] board, String word) {
    int wordLen = word.length();
    if (wordLen == 0) {
        return false;
    }
    int boardRow = board.length;
    if (boardRow == 0) {
        return false;
    }
    int boardColumn = board[0].length;
    if (boardColumn == 0) {
        return false;
    }
    // Find the first char
    int starti = -1, startj = -1;
    for (int i = 0; i < boardRow; i++) {
        for (int j = 0; j < boardColumn; j++) {
            if (word.charAt(0) == board[i][j]) {
                starti = i;
                startj = j;
                boolean result = existHelper(board, word, 1, starti + 1, startj) || 
                existHelper(board, word, 1, starti - 1, startj) || existHelper(board, 
                    word, 1, starti, startj + 1) || existHelper(board, word, 1, 
                    starti, startj - 1);
                if (result) {
                    return true;
                }
            }
        }
    }
    return false;
}

public boolean existHelper(char[][] board, String word, int index, int i, int j) {
    if (index == word.length()) {
        return true;
    }
    else {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(index)) {
            return existHelper(board, word, index + 1, i + 1, j) || existHelper(board, 
                word, index + 1, i - 1, j) || existHelper(board, word, index + 1, i, 
                j + 1) || existHelper(board, word, index + 1, i, j - 1);
        }
        else {
            return false;
        }
    }
}

// Use HashMap<Integer, HashSet<Integer>> to record the path.
// Take care not use same map for different path
// Also if just copy map, the HashSet inside will point to the same set
// This one not AC because of TLE QAQ
public boolean exist(char[][] board, String word) {
    int wordLen = word.length();
    if (wordLen == 0) {
        return false;
    }
    int boardRow = board.length;
    if (boardRow == 0) {
        return false;
    }
    int boardColumn = board[0].length;
    if (boardColumn == 0) {
        return false;
    }
    // Find the first char
    int starti = -1, startj = -1;
    for (int i = 0; i < boardRow; i++) {
        for (int j = 0; j < boardColumn; j++) {
            if (word.charAt(0) == board[i][j]) {
                starti = i;
                startj = j;
                Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
                map.put(starti, new HashSet<Integer>());
                map.get(starti).add(startj);
                boolean result = existHelper(map, board, word, 1, starti + 1, startj) 
                || existHelper(map, board, word, 1, starti - 1, startj) || 
                existHelper(map, board, word, 1, starti, startj + 1) || 
                existHelper(map, board, word, 1, starti, startj - 1);
                if (result) {
                    return true;
                }
            }
        }
    }
    return false;
}

public boolean existHelper(Map<Integer, Set<Integer>> map, char[][] board, 
    String word, int index, int i, int j) {
    if (index == word.length()) {
        return true;
    }
    else {
        // OOB
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        // Repeat cell
        if (map.containsKey(i) && map.get(i).contains(j)) {
            return false;
        }
        if (board[i][j] == word.charAt(index)) {
            Map<Integer, Set<Integer>> newmap = new HashMap<>();
            for (int column = 0; column < board.length; column++) {
                if (map.containsKey(column)) {
                    newmap.put(column, new HashSet<Integer>(map.get(column)));
                }
            }
            if (!newmap.containsKey(i)) {
                newmap.put(i, new HashSet<Integer>());
            }
            newmap.get(i).add(j);
            return existHelper(newmap, board, word, index + 1, i + 1, j) || 
            existHelper(newmap, board, word, index + 1, i - 1, j) || 
            existHelper(newmap, board, word, index + 1, i, j + 1) || 
            existHelper(newmap, board, word, index + 1, i, j - 1);
        }
        else {
            return false;
        }
    }
}

// Think backward and use backtracking.
// Still use first version but mark the matched char as '.' then recover.
public boolean exist(char[][] board, String word) {
    int wordLen = word.length();
    if (wordLen == 0) {
        return false;
    }
    int boardRow = board.length;
    if (boardRow == 0) {
        return false;
    }
    int boardColumn = board[0].length;
    if (boardColumn == 0) {
        return false;
    }
    // Find the first char
    int starti = -1, startj = -1;
    for (int i = 0; i < boardRow; i++) {
        for (int j = 0; j < boardColumn; j++) {
            if (board[i][j] == word.charAt(0)) {
                starti = i;
                startj = j;
                board[i][j] = '.';
                boolean result = existHelper(board, word, 1, starti + 1, startj) 
                || existHelper(board, word, 1, starti - 1, startj) || 
                existHelper(board, word, 1, starti, startj + 1) || 
                existHelper(board, word, 1, starti, startj - 1);
                board[i][j] = word.charAt(0);
                if (result) {
                    return true;
                }
            }
        }
    }
    return false;
}

public boolean existHelper(char[][] board, String word, int index, int i, int j) {
    if (index == word.length()) {
        return true;
    }
    else {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(index)) {
            board[i][j] = '.';
            boolean result = existHelper(board, word, index + 1, i + 1, j) || 
            existHelper(board, word, index + 1, i - 1, j) || 
            existHelper(board, word, index + 1, i, j + 1) || 
            existHelper(board, word, index + 1, i, j - 1);
            board[i][j] = word.charAt(index);
            if (result) {
                return true;
            }
        }
        else {
            return false;
        }
    }
    return false;
}

/* Test case
["aa"]
"aaa"
["ABCE","SFES","ADEE"]
"ABCESEEEFS"
*/
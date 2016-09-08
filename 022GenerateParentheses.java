/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed 
parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

// DFS
public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    help(result, "", 0, 0, n);
    return result;
}

public void help(List<String> list, String str, int open, int close, int n) {
    if (str.length() == 2 * n) {
        list.add(str);
        return;
    }
    if (open < n) {
        help(list, str+"(", open+1, close, n);
    }
    if (close < open) {
        help(list, str+")", open, close+1, n);
    }
}

// Could also use dp. But dp need to delete the duplicate string. Simply use set() in python.

/* Test case
3
*/
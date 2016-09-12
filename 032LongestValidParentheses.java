/*
32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

// Loop once and push index into stack.
public int longestValidParentheses(String s) {
    Stack<Integer> stk = new Stack<>();
    int max = 0;
    int start = -1;
    for (int i = 0; i < s.length(); i++) {
        // If '(', push into stack.
        if (s.charAt(i) == '(') {
            stk.push(i);
        }
        // If ')', look at stack
        else {
            // No '(' to match, invalid. New start.
            if (stk.empty()) {
                start = i;
            }
            // If stack has '(', match(pop) first
            else {
                stk.pop();
                // If there is no more '(' to match, calculate to the right of start
                if (stk.empty()) {
                    max = Math.max(max, i - start);
                }
                // TRICKY: use this part will exceed time limit
                // If there is more '(' to match, calculate to the right of '('
                //else {
                //    max = Math.max(max, i - stk.peek());
                //}
            }
        }
        // This part do the same thing as commented part above in only one time
        if (!stk.empty()) {
            max = Math.max(max, i - stk.peek());
        }
    }
    return max;
}

// DP:
// If s[i] is '(', set longest[i] to 0,because any string end with '(' cannot be a valid one.
// Else if s[i] is ')'
//     If s[i-1] is '(', longest[i] = longest[i-2] + 2
//     Else if s[i-1] is ')' and s[i-longest[i-1]-1] == '(', longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]
public int longestValidParentheses(String s) {
    // Record the length of longest substring end at result[i]
    int max = 0;
    if (s.length() <= 1) return 0;
    int[] result = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i)==')') {
            // Previous char is '('
            if (s.charAt(i - 1) == '(') {
                result[i] = i == 1 ? 2 : result[i - 2] + 2;
            }
            // Previous char is not '(', end shoud be (...)
            else {
                if (i - result[i - 1] - 1 >= 0 && s.charAt(i - result[i - 1] - 1) == '(') {
                    // If ...(...)
                    result[i] = i - result[i - 1] - 2 >= 0 ? result[i - 1] + 2 + result[i - 2 - result[i - 1]] : result[i - 1] + 2;
                }
            }
        }
    }
    for (int i:result) {
        max = Math.max(max, i);
    }
    return max;
}

/* Test case
"(()()(()"
"((()())))"
*/
/*
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

//
public boolean isValid(String s) {
    Stack<Character> stk = new Stack<Character>();
    for(int i = 0; i < s.length(); i++){
        if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
            stk.push(s.charAt(i));
        }
        else{
            if (s.charAt(i)==')'){
                if (stk.isEmpty()) return false;
                if (stk.peek()=='(') stk.pop();
                else return false;
            }
            if (s.charAt(i)==']'){
                if (stk.isEmpty()) return false;
                if (stk.peek()=='[') stk.pop();
                else {return false;}
            }
            if (s.charAt(i)=='}'){
                if (stk.isEmpty()) return false;
                if (stk.peek()=='{') stk.pop();
                else {return false;}
            }
        }
    }
    if (!stk.isEmpty()) return false;
    return true;
}

/* Test case
"["
*/
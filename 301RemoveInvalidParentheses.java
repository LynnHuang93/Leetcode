/*
301. Remove Invalid Parentheses

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
*/

// Add string to a queue. For invalid string in queue, eliminate one character and put into queue
// Hash existing string in queue to cut branch
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        List<String> l = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        l.add(s);
        set.add(s);
        while(!l.isEmpty()) {
            String current = l.remove(0);
            if (!result.isEmpty() && current.length() < result.get(0).length()) {
                return result;
            }
            checkCurrent(current, l, set, result);
        }
        return result;
    }
    
    public void checkCurrent(String current, List<String> l, Set<String> set, List<String> result) {
        if (validParentheses(current)) {
            result.add(current);
        }else {
            for (int i = 0; i < current.length(); i++) {
                if (isParentheses(current.charAt(i))) {
                    String subString = current.substring(0, i) + current.substring(i + 1);
                    add(subString, set, l);
                }
            }
        }
    }
    
    public boolean isParentheses(char c) {
        return c == '(' || c == ')';
    }
    
    public void add(String string, Set<String> set, List<String> l) {
        if (set.add(string)) {
            l.add(string);
        }
    }
    
    public boolean validParentheses(String s) {
        if (s.length() == 0) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }else {
                if (c == ')') {
                    count--;
                    if (count < 0) {
                        return false;
                    }
                }
            }
        }
        return count == 0;
    }
}
public class Solution {
	public List<String> removeInvalidParentheses(String s) {
	    List<String> result = new ArrayList<>();
	    LinkedList<String> q = new LinkedList<>();
	    HashSet<String> set = new HashSet<>();
	    q.offer(s);
	    while (!q.isEmpty()) {
	        String current = q.poll();
	        if (!result.isEmpty() && current.length() < result.get(0).length()) {
	            return result;
	        }
	        if (validParantheses(current)) {
	            result.add(current);
	        } else {
	            String newStr;
	            if (current.charAt(0)=='(' || current.charAt(0) == ')') {
	                newStr = current.substring(1);
	                if (set.add(newStr)) {
	                    q.add(newStr);
	                }
	            }
	            for (int i = 1; i < current.length()-1; i++) {
	                if (current.charAt(i)=='(' || current.charAt(i) == ')') {
	                    newStr = current.substring(0, i) + current.substring(i + 1);
	                    if (set.add(newStr)) {
	                        q.offer(newStr);
	                    }
	                }
	            }
	            if (current.charAt(current.length()-1)=='(' || current.charAt(current.length()-1) == ')') {
	                newStr = current.substring(0, current.length() - 1);
	                if (set.add(newStr)) {
	                    q.add(newStr);
	                }
	            }
	        }
	    }
	    return result;
	}

	public boolean validParantheses(String s) {
	    int count = 0;
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c == '(') {
	            count++;
	        }
	        if (c == ')'){
	            if (count == 0) {
	                return false;
	            } else {
	                count--;
	            }
	        }
	    }
	    return count == 0;
	}
}

/* Test cases
"(()"
"x("
*/
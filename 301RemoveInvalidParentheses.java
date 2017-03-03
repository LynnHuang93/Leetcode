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
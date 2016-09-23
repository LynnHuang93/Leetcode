/*
71. Simplify Path

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] folder = path.split("/");
    for (String str : folder) {
        // "/foo//bar/"
        if (str.equals("") || str.equals(".")) {
            continue;
        }
        if (str.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        else {
            stack.push(str);
        }
    }
    String result = "";
    // "/../"
    if (stack.isEmpty()) {
        return "/";
    }
    while (!stack.isEmpty()) {
        result = "/" + stack.pop() + result;
    }
    return result;
}

/* Test case
"/a/./b/../../c/"
*/
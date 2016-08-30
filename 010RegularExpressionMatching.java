/*
10. Regular Expression Matching

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

// dp[i][j]
public static boolean isMatch(String s, String p) {
    if (s == null || p == null) {return false;}
    if (s.length() == 0) {
        // "","" -> true
        if (p.length() == 0) {return true;}
        // "","a" -> false
        if (p.length() %2 != 0) {
            return false;
        }
        else {
            // "","a*b*" -> true
            return p.charAt(1) == '*' ? isMatch(s, p.substring(2)):false;
        }
    }
    if (p.length() == 0) {
        return false;
    }
    char s1 = s.charAt(0);
    char p1 = p.charAt(0), p2 = '0';
    if (p.length() > 1) {
        p2 = p.charAt(1);
    }
    if (p2 == '*') {
        if (compare(s1, p1)) {
            // "a","a*"; "aa","a*a"; "ab","a*b"
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
        }
        else {
            // "b","a*b"
            return isMatch(s, p.substring(2));
        }
    }
    else {
        // "abc","abc"
        if (compare(s1, p1)){
            return isMatch(s.substring(1),p.substring(1));
        }
        // "bbc","abc"
        else {
            return false;
        }
    }
}
public static boolean compare(char s, char p){
    if (p == '.'){
        return true;
    }
    return s == p;
}

// Test method
public static void main(String[] args) {
	String test1 = "aa";
	String test2 = "abbc";
	String test3 = "ab.c";
  	String test4 = "a*";
  	System.out.println(isMatch(test1, test4));
  	System.out.println(isMatch(test2, test4));
  	System.out.println(isMatch(test1, test3));
  }	
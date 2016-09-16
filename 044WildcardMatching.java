/*
44. Wildcard Matching 

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

// The basic idea is dp:
// dp[i][j] represent if s[0~i] matches p[0~j]
// transform:
// if p[j] == '?' || p[j] == s[i] : dp[i][j] = dp[i-1][j-1]
// elif 
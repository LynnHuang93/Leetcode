/*
139. Word Break
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

// Simple backtracking. DFS TLE
public boolean wordBreak(String s, Set<String> wordDict) {
    if (s.length() == 0) {
        return false;
    }
    List<String> path = new ArrayList<>();
    int curindex = 0;
    for (String word : wordDict) {
        if (word.length() <= s.length() && s.substring(0, word.length()).equals(word)) {
            path.add(word);
            if (wordBreakHelper(s.substring(word.length(), s.length()), wordDict, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }
    }
    return false;
}

public boolean wordBreakHelper(String s, Set<String> wordDict, List<String> path) {
    if (s.length() == 0) {
        return true;
    }
    else {
        for (String word : wordDict) {
            if (word.length() <= s.length() && s.substring(0, word.length()).equals(word)) {
                path.add(word);
                if (wordBreakHelper(s.substring(word.length(), s.length()), wordDict, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}
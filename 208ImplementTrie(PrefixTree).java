/*
208. Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

class TrieNode {
    // Initialize your data structure here.
    TrieNode[] list;
    char val;
    boolean isEnd;
    
    public TrieNode() {
        this.list = new TrieNode[26];
        this.isEnd = false;
    }
    
    public TrieNode(char val) {
        this.list = new TrieNode[26];
        this.val = val;
        this.isEnd = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode pos = this.root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (pos.list[c-'a'] == null) {
                pos.list[c-'a'] = new TrieNode(c);
            }
            if (i == len-1) {
                pos.list[c-'a'].isEnd = true;
            }
            pos = pos.list[c-'a'];
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode pos = this.root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (pos.list[c-'a'] == null) {
                return false;
            }
            pos = pos.list[c-'a'];
        }
        return pos.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode pos = this.root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            if (pos.list[c-'a'] == null) {
                return false;
            }
            pos = pos.list[c-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

/* Test case
Trie trie = new Trie();
trie.insert("abc");
trie.search("abc");	// true
trie.search("ab");	// false
trie.insert("ab");
trie.search("ab");	// true
*/
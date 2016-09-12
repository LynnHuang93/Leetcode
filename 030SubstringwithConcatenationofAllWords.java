/*
30. Substring with Concatenation of All Words

You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of 
substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

// Originally I want to match the words first and record the index in a list. Then process the list to find sequences
// with all the index of words list and add the start point to result. This part is longest substring without repeat.
// This works for words list without repeat but if words repeat this does not work.
public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    int wordsNum = words.length;
    int strLen = s.length();
    int wordLen = words[0].length();
    if (s == null || strLen == 0 || words == null || wordsNum == 0 || wordLen > strLen) {
        return result;
    }
    // Init a list for word index
    int[] wordIndex = new int[strLen - wordLen + 1];
    for (int i = 0; i < wordIndex.length; i++) {
        wordIndex[i] = -1;
    }
    // Match all the words to fill the index list
    for (int i = 0; i <= strLen - wordLen; i++) {
        for (int j = 0; j < wordsNum; j++) {
            if (s.substring(i, i + wordLen).equals(words[j])) {
                wordIndex[i] = j;
                break;
            }
        }
    }
    // Find the sequence
    int start = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    // [1,-1,-1,2,1,-1] find 1,?,?,2 for wordLen = 3
    for (int j = 0; j < wordLen; j++) {
        for (int i = j; i < wordIndex.length ; i = i + wordLen) {
            if (wordIndex[i]!=-1) {
                if (map.size()==0) {
                    start = i;
                }
                if (map.containsKey(wordIndex[i])) {
                    start = Math.max(start, map.get(wordIndex[i])+wordLen);
                }
                map.put(wordIndex[i], i);
                if (map.size() == wordsNum) {
                    Boolean flag = true;
                    for (Integer index : map.values()) {
                        if (index < start) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        result.add(start);
                    }
                }
            }
            else {
                map.clear();
            }
        }
        map.clear();
    }
    return result;
}

// If repeat words exist. Exceed time limit.
public static List<Integer> findSubstring(String s, String[] words) {
	HashMap<String, Integer> word = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    if (s == null || words == null || words.length == 0) {
        return result;
    }
    int wordLen = words[0].length();
    int strLen = s.length();
    int wordsNum = words.length;
    if (s.length() < wordLen) {
        return result;
    }
    // Loop the words and record word and time pair
    for (int i = 0; i < words.length; i++) {
        if (word.containsKey(words[i])) {
            word.put(words[i], word.get(words[i])+1);
        }
        else {
            word.put(words[i], 1);
        }
    }
    // Loop s from left
    for (int i = 0; i < wordLen; i++) {
	    int count = 0;
    	int startIndex = i;
        HashMap<String, Integer> map = new HashMap<>();
        for (int j = i; j <= strLen - wordLen; j = j + wordLen) {
            Boolean flag = false;
            for (String w : words) {
                // Find a word
                if (s.substring(j, j + wordLen).equals(w)) {
                	flag = true;
                    // Find an existing word
                    if (map.containsKey(w) && map.get(w) > 0) {
                        // Not enough, add count and time
                        if (map.get(w) < word.get(w)) {
                            count++;
                            map.put(w, map.get(w)+1);
                            // If enough, add result
                            if (count == wordsNum) {
                                result.add(startIndex);
                                map.put(s.substring(startIndex, startIndex+wordLen), map.get(s.substring(startIndex, startIndex+wordLen))-1);
                                startIndex += wordLen;
                                count--;
                            }
                        }
                        // If already enough same word, find the first same word from startIndex
                        // Eliminate other found words
                        else {
                            for (int k = startIndex; k < j; k = k + wordLen){
                                Boolean found = false;
                                for (String wrd : words) {
                                    if (s.substring(k, k + wordLen).equals(wrd)) {
                                        if (wrd == w) {
                                            found = true;
                                            startIndex = k + wordLen;
                                        }
                                        else {
                                            map.put(wrd, map.get(wrd)-1);
                                            count--;
                                        }
                                        break;
                                    }
                                }
                                if (found) {
                                    break;
                                }
                            }
                        }
                    }
                    // Find a new word
                    else {
                        map.put(w, 1);
                        count++;
                        // If enough, add result
                        if (count == wordsNum) {
                            result.add(startIndex);
                            map.put(s.substring(startIndex, startIndex+wordLen), map.get(s.substring(startIndex, startIndex+wordLen))-1);
                            startIndex += wordLen;
                            count--;
                        }
                    }
                    // Find one word, do not match rest words
                    break;
                }
                // Not a word, clear all vars, reset startIndex
            }
            if (!flag) {
            	map.clear();
                count = 0;
                startIndex = j + wordLen;
            }
        }
    }
    return result;
}

// Accepted. Same method using HashMap instead of loop to match words.
public List<Integer> findSubstring(String S, String[] L) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (S == null || S.length() == 0 || L == null || L.length == 0)
        return result;
    int strLen = S.length();
    int wordLen = L[0].length();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < L.length; i++) {
        if (map.containsKey(L[i])) {
            map.put(L[i], map.get(L[i]) + 1);
        } else {
            map.put(L[i], 1);
        }
    }
    for (int i = 0; i < wordLen; i++) {
        HashMap<String, Integer> curMap = new HashMap<String, Integer>();
        int count = 0, left = i;
        for (int j = i; j <= strLen - wordLen; j += wordLen) {
            String curStr = S.substring(j, j + wordLen);
            if (map.containsKey(curStr)) {
                if (curMap.containsKey(curStr)) {
                    curMap.put(curStr, curMap.get(curStr) + 1);
                } else {
                    curMap.put(curStr, 1);
                }
                if (curMap.get(curStr) <= map.get(curStr)) {
                    count++;
                } else {
                    while (true) {
                        String tmp = S.substring(left, left + wordLen);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        left += wordLen;
                        if (curStr.equals(tmp)) {
                            break;
                        } else {
                            count--;
                        }
                    }
                }
                if (count == L.length) {
                    result.add(left);
                    String tmp = S.substring(left, left + wordLen);
                    curMap.put(tmp, curMap.get(tmp) - 1);
                    left += wordLen;
                    count--;
                }
            } else {
                curMap.clear();
                count = 0;
                left = j + wordLen;
            }
        }
    }
    return result;
}

/* Test case
"aaaaaa"
["aaa","aaa"]
"barfoofoobarthefoobarman"
["foo","bar","the"]
*/
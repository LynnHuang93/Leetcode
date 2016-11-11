/*
387. First Unique Character in a String 

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

public int firstUniqChar(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    HashMap<Character, Integer> posMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        }else {
            map.put(c, 1);
            posMap.put(c, i);
        }
    }
    int result = -1;
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1){
            result = result == -1 ? posMap.get(entry.getKey()) : Math.min(result, posMap.get(entry.getKey()));
        }
    }
    return result;
}

/* Test case
"leetcode"
*/
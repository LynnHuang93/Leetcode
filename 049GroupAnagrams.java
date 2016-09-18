/*
49. Group Anagrams

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

// Key is to create a signal/hash for anagrams.
// Here use the prime number for all the characters.
// So that the production of each string is depend on the chars.
import java.math.BigInteger;

public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    if (strs.length == 0) {
        return result;
    }
    int[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
    HashMap<BigInteger, List<String>> map = new HashMap<>();
    for (String str:strs) {
        BigInteger hash = BigInteger.ONE;
        for (int i = 0; i < str.length(); i++) {
            hash = hash.multiply(BigInteger.valueOf(prime[ str.charAt(i) - 'a']));
        }
        if (!map.containsKey(hash)){
            List<String> list = new ArrayList<>();
            list.add(str);
            map.put(hash, list);
        }
        else {
            map.get(hash).add(str);
        }
    }
    for (List<String> list:map.values()) {
        result.add(list);
    }
    return result;
}

/* Test case
["aaaaaaa","aaaaaaaaaaaaaaa"]
*/
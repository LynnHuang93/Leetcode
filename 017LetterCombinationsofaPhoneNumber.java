/*
17. Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

// FIFO
public List<String> letterCombinations(String digits) {
    List<String> result = new LinkedList<>();
    String[] str = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    int validCharNum = 0;
    for (int i = 0; i < digits.length(); i++) {
        int num = digits.charAt(i)-'0';
        if (num >=2 && num <= 9) {
        	// While loop need elements in the result list. Add first.
            if (result.size()==0) {
                for (int j = 0; j < str[num - 2].length(); j++){
                    result.add(str[num-2].substring(j,j+1));
                }
                validCharNum += 1;
            }
            else {
                while (result.get(0).length()==validCharNum) {
                    String prefix = result.remove(0);
                    for (int j = 0; j < str[num - 2].length(); j++) {
                        String c = str[num - 2].substring(j, j+1);
                        result.add(prefix+c);
                    }
                }
                validCharNum += 1;
            }
        }
    }
    return result;
}

// Check empty string at the beginning
// Deal with start using ""
public List<String> letterCombinationsOfaPhoneNumber(String s) {
    String[] stringList = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new ArrayList<>();
    if (s.length() == 0) {
        return result;
    }
    result.add("");
    for (int i = 0; i < s.length(); i++) {
        int c = s.charAt(i) - '2';
        if (i >= 0 && i <= 7) {
            int resultlen = result.size();
            String newLetter = stringList[c];
            List<String> newResult = new ArrayList<>();
            for (int j = 0; j < newLetter.length(); j++) {
                for (int k = 0; k < resultlen; k++) {
                    newResult.add(result.get(k) + Character.toString(newLetter.charAt(j)));
                }
            }
            result = newResult;
        }
    }
    return result;
}

/* Test case
"22"
*/
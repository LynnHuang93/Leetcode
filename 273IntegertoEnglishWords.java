/*
273. Integer to English Words
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/

public class Solution {
    public String numberToWords(int i) {
        if (i == 0) {
            return "Zero";
        }
        Map<Integer, String> mapSpecial = new HashMap<>();
        mapSpecial.put(0,"");
        mapSpecial.put(1, "One");
        mapSpecial.put(2, "Two");
        mapSpecial.put(3, "Three");
        mapSpecial.put(4, "Four");
        mapSpecial.put(5, "Five");
        mapSpecial.put(6, "Six");
        mapSpecial.put(7, "Seven");
        mapSpecial.put(8, "Eight");
        mapSpecial.put(9, "Nine");
        mapSpecial.put(10, "Ten");
        mapSpecial.put(11, "Eleven");
        mapSpecial.put(12, "Twelve");
        mapSpecial.put(13, "Thirteen");
        mapSpecial.put(14, "Fourteen");
        mapSpecial.put(15, "Fifteen");
        mapSpecial.put(16, "Sixteen");
        mapSpecial.put(17, "Seventeen");
        mapSpecial.put(18, "Eighteen");
        mapSpecial.put(19, "Nineteen");
        mapSpecial.put(20, "Twenty");
        mapSpecial.put(30, "Thirty");
        mapSpecial.put(40, "Forty");
        mapSpecial.put(50, "Fifty");
        mapSpecial.put(60, "Sixty");
        mapSpecial.put(70, "Seventy");
        mapSpecial.put(80, "Eighty");
        mapSpecial.put(90, "Ninety");
        String[] unit = {"Thousand","Million", "Billion"};
        String result = "";
        for (int j = -1; j < 3; j++) {
            // if still something
            if (i > 0) {
                int current = i % 1000;
                // Deal with something like 5000
                if (current == 0) {
                    i = i/1000;
                    continue;
                }
                String subresult = "";
                int digit2 = current % 100;
                if (mapSpecial.containsKey(digit2)) {
                    subresult = addToResult(subresult, mapSpecial.get(digit2));
                } else {
                    subresult = addToResult(subresult, mapSpecial.get(digit2/10*10) + " " + mapSpecial.get(digit2%10));
                }
                int digit3 = current/100;
                if (digit3 != 0) {
                    subresult = addToResult(subresult, mapSpecial.get(digit3) + " Hundred");
                }
                if (j >= 0){
                    result = addToResult(result, subresult + " " + unit[j]);
                }else {
                    result = addToResult(result, subresult);
                }
                //finally
                i = i/1000;
            } else {
                return result;
            }
        }
        return result;
    }

    public String addToResult(String result, String newResult) {
        if (result.length() == 0) {
            return newResult;
        } else {
            return newResult + " " + result;
        }
    }
}
/* Test cases
2147483647 (2^31-1)
2147483646
*/
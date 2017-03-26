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

public class Solution {
    public String numberToWords(int num) {
        Map<Integer, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        if (num == 0) {
            return "Zero";
        }
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        String[] unit = new String[]{"Thousand", "Million", "Billion"};
        for (int i = 0; i < 4; i++) {
            if (num == 0) {
                break;
            }else{
                int current = num % 1000;
                num = num / 1000;
                if (current == 0) {
                    continue;
                }
                if (i > 0) {
                    result.add(unit[i-1]);
                }
                int digit2 = current % 100;
                if (digit2 != 0){
                    if (map.containsKey(digit2)) {
                        result.add(map.get(digit2));
                    }else {
                        result.add(map.get(digit2 % 10));
                        result.add(map.get(digit2 / 10 * 10));
                    }
                }
                if (current / 100 > 0) {
                    result.add("Hundred");
                    result.add(map.get(current / 100));
                }
            }
        }
        Collections.reverse(result);
        return String.join(" ", result);
    }
}
/* Test cases
2147483647 (2^31-1)
2147483646
*/
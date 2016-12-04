/*
423. Reconstruct Original Digits from English

Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"
*/

// Wrong answer using prime product. Not correct here because "seven" and "four" contains "one"
import java.math.BigInteger;
public class Solution {
    public String originalDigits(String s) {
        String[] list = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
        BigInteger[] listProduct = new BigInteger[10];
        for (int i = 0; i < 10; i++) {
            BigInteger p = BigInteger.ONE;
            String num = list[i];
            for (int j = 0; j < num.length(); j++) {
                p = p.multiply(BigInteger.valueOf(prime[list[i].charAt(j) - 'a']));
            }
            listProduct[i] = p;
        }
        BigInteger p = BigInteger.ONE;
        for (int j = 0; j < s.length(); j++) {
            p = p.multiply(BigInteger.valueOf(prime[s.charAt(j) - 'a']));
        } 
        String result = "";
        for (int i = 0; i < list.length; i++) {
            while (!p.equals(BigInteger.ONE)&&p.mod(listProduct[i]).equals(BigInteger.ZERO)) {
                p = p.divide(listProduct[i]);
                result += String.valueOf(i);
            }
        }
        return result;
    }
}

// use unique letters to identify number
public class Solution {
    public String originalDigits(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)-'a')) {
                map.put(s.charAt(i)-'a', map.get(s.charAt(i)-'a')+1);
            }
            else {
                map.put(s.charAt(i)-'a', 1);
            }
        }
        int[] count = new int[10];
        String result = "";
        // unique letter 'z','w','x'，'g'
        checkNum('z'-'a', map, count, 0, "zero");
        checkNum('w'-'a', map, count, 2, "two");
        checkNum('x'-'a', map, count, 6, "six");
        checkNum('g'-'a', map, count, 8, "eight");
        checkNum('s'-'a', map, count, 7, "seven");
        checkNum('v'-'a', map, count, 5, "five");
        checkNum('f'-'a', map, count, 4, "four");
        checkNum('o'-'a', map, count, 1, "one");
        checkNum('t'-'a', map, count, 3, "three");
        checkNum('i'-'a', map, count, 9, "nine");
        for (int i = 0; i < 10; i++) {
            int c = count[i];
            while (c>0) {
                result += String.valueOf(i);
                c--;
            }
        }
        return result;
    }
    public void checkNum(int charIndex, Map<Integer,Integer> map, int[] count, int n, String s) {
        if (map.containsKey(charIndex) && map.get(charIndex)>0) {
            int num = map.get(charIndex);
            count[n] = num;
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i)-'a',map.get(s.charAt(i)-'a')-num);
            }
        }
    }
}
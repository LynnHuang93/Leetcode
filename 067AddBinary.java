/*
67. Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int indexa = a.length()-1;
        int indexb = b.length()-1;
        String result = "";
        while (indexa >= 0 || indexb >= 0 || carry != 0) {
            int digita = indexa >= 0 ? a.charAt(indexa) - '0': 0;
            indexa--;
            int digitb = indexb >= 0 ? b.charAt(indexb) - '0': 0;
            indexb--;
            carry = digita + digitb + carry;
            int newDigit = carry % 2;
            carry = carry/2;
            result = newDigit == 0 ? "0" + result : "1" + result;
        }
        return result;
    }
}

/* Test case
"1001"
"101"
*/
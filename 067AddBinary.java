/*
67. Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public String addBinary(String a, String b) {
    int carry = 0;
    if (a.length() == 0) {
        return b;
    } 
    if (b.length() == 0) {
        return a;
    }
    int indexa = a.length() - 1;
    int indexb = b.length() - 1;
    String result = "";
    while (indexa >=0 || indexb >=0 || carry != 0) {
        int digita = indexa >= 0 ? a.charAt(indexa) - '0' : 0;
        int digitb = indexb >= 0 ? b.charAt(indexb) - '0' : 0;
        int sum = digita + digitb + carry;
        carry = sum / 2;
        result = String.valueOf(sum % 2) + result;
    }
    return result;
}

/* Test case
"1001"
"101"
*/
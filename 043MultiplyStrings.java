/*
43. Multiply Strings

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
*/

// Implement as who we do in real world
public String multiply(String num1, String num2) {
    String res = "";
    if (num1 == null || num1.length() == 0) {
        return res;
    }
    if (num2 == null || num2.length() == 0) {
        return res;
    }
    if (num1.equals("0") || num2.equals("0")) {
        return "0";
    }
    for(int index1 = num1.length() - 1; index1 >= 0; index1--) {
        int digit1 = num1.charAt(index1) - '0';
        for (int index2 = num2.length() - 1; index2 >= 0; index2--) {
            int digit2 = num2.charAt(index2) - '0';
            String product = String.valueOf(digit1 * digit2);
            int zeros = (num1.length() - 1 - index1) + (num2.length() - 1 - index2);
            res = add(res, product, zeros);
        }
    }
    return res;
}
private String add(String res, String product, int zeros) {
    if (res.length() == 0){
        return product;
    }
    int carry = 0;
    String sum = "";
    int indexFromRight = 0;
    while (indexFromRight < zeros) {
        if (res.length() > 0) {
            sum = res.substring(res.length() - 1, res.length()) + sum;
            res = res.substring(0, res.length() - 1);
        }
        else {
            sum = "0" + sum;
        }
        indexFromRight++;
    }
    while (carry != 0 || product.length() > 0) {
        int productDigit = 0;
        if (product.length() > 0) {
            productDigit = product.charAt(product.length() - 1) - '0';
            if (product.length() > 1) {
                product = product.substring(0, product.length() - 1);
            }
            else {
                product = "";
            }
        }
        int resDigit = 0;
        if (res.length() > 0) {
            resDigit = res.charAt(res.length() - 1) - '0';
            if (res.length() > 1) {
                res = res.substring(0, res.length() - 1);
            }
            else {
                res = "";
            }
        }
        int digitSum = carry + productDigit + resDigit;
        sum = Integer.toString(digitSum % 10) + sum;
        carry = digitSum / 10;
    }
    if (res.length() > 0) {
        sum = res + sum;
    }
    return sum;
}

//        234
//         56
//      -----
//         24
//        18
//       12      product of 2 digit is at most 2 digits (0~81)
//        20     index1 = 2, index2 = 0, p1 = 2+0, p2 = p1+1
//       15
//      10
//     ------
//      13104    length will not exceed m+n
// index01234
public String multiply(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    if (len1 == 0 || len2 == 0) {
        return "";
    }
    int[] res = new int[len1 + len2];
    for (int index1 = len1 - 1; index1 >= 0; index1--) {
        int digit1 = num1.charAt(index1) - '0';
        for (int index2 = len2 - 1; index2 >= 0; index2--) {
            int digit2 = num2.charAt(index2) - '0';
            int p1 = index1 + index2, p2 = p1 + 1;
            // Here is the most important optimization
            // Only add p2, use p1 for the carry
            int sum = digit1 * digit2 + res[p2];
            res[p1] += sum / 10;
            res[p2] = sum % 10;
        }
    }
    String result = "";
    int index = 0;
    while (index < res.length && res[index] == 0) {
        index++;
    }
    if (index == res.length) {
        return "0";
    }
    while (index < res.length) {
        result += Integer.toString(res[index]);
        index++;
    }
    return result;
}

/* Test case
"1234"
"0"
*/
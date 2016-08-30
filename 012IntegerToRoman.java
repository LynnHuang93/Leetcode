/*
12. Integer to Roman

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

//
public static String intToRoman(int num) {
    String[] digit0 = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    String[] digit1 = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    String[] digit2 = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    String[] digit3 = {"","M","MM","MMM"};
    return digit3[num/1000] + digit2[num%1000/100] + digit1[num%100/10] + digit0[num%10];
}

// Test method
public static void main(String[] args) {
    int test = 1234;
    System.out.print(intToRoman(test));
}
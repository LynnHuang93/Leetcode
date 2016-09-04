/*
13. Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

// TODO: write a help function to reduce duplicate code.
public int romanToInt(String s) {
    String[] digit0 = {"I","II","III","IV","V","VI","VII","VIII","IX"};
    String[] digit1 = {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    String[] digit2 = {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    String[] digit3 = {"M","MM","MMM"};
    int result = 0;
    int index = 0;
    for (int i = 2; i >= 0; i--) {
        if (s.length() >= index + digit3[i].length() && s.substring(index, index+digit3[i].length()).equals(digit3[i])) {
            result += (i+1)*1000;
            index += digit3[i].length();
            break;
        }
    }
    for (int i = 8; i >= 0; i--) {
        if (s.length() >= index + digit2[i].length() && s.substring(index, index+digit2[i].length()).equals(digit2[i])) {
            result += (i+1)*100;
            index += digit2[i].length();
            break;
        }
    }
    for (int i = 8; i >= 0; i--) {
        if (s.length() >= index + digit1[i].length() && s.substring(index, index+digit1[i].length()).equals(digit1[i])) {
            result += (i+1)*10;
            index += digit1[i].length();
            break;
        }
    }
    for (int i = 8; i >= 0; i--) {
        if (s.length() >= index + digit0[i].length() && s.substring(index, index+digit0[i].length()).equals(digit0[i])) {
            result += (i+1)*1;
            index += digit0[i].length();
            break;
        }
    }
    return result;
}

/* Test cases
"DCXXI"
*/

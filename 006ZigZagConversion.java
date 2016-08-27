/*
6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public static String convert(String s, int numRows) {
  	if (numRows == 1) {return s;}
    int groupCharNum = numRows * 2 - 2;
    int groupNum = 0;
    if (s.length() % groupCharNum == 0) {
        groupNum = s.length() / groupCharNum;
    }
    else {
        groupNum = s.length() / groupCharNum + 1;
    }
    String result = "";
    for (int i = 1; i <= numRows; i++){
        if (i == 1 || i == numRows) {
            for (int g = 0; g < groupNum; g++){
                if (g * groupCharNum + i - 1 < s.length()) {
                  	result += s.charAt(g * groupCharNum + i - 1);}
            }
        }
        else {
            for (int g = 0; g < groupNum; g++){
              	if (g * groupCharNum + i - 1 < s.length()) {
                	result += s.charAt(g * groupCharNum + i - 1);}
              	if (g * groupCharNum + 2 * numRows - i - 1 < s.length()) {
                	result += s.charAt(g * groupCharNum + 2 * numRows - i - 1);}
            }
        }
    }
    return result;
}

// Test method
public static void main(String[] args) {
	String givenString = "PAYPALISHIRING";
	String result = convert(givenString, 3);
    System.out.print(result.equals("PAHNAPLSIIGYIR"));
	System.out.print(result);
  
	String str = "ABCD";
	String res = convert(str, 2);
    System.out.print(res.equals("ACBD"));
}
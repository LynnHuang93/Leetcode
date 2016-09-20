/*
66. Plus One

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public int[] plusOne(int[] digits) {
    int length = digits.length;
    for (int i = length - 1; i >= 0; i--) {
        int sum = 1 + digits[i];
        if (sum < 10) {
            digits[i] = sum;
            return digits;
        }
        else {
            digits[i] = 0;
        }
    }
    int[] newResult = new int[length + 1];
    newResult[0] = 1;
    return newResult;
}

/* Test case
[]
*/
/*
371. Sum of Two Integers

Calculate the sum of two integers a and b, but you are not
allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/

// Good for positive integer, cannot deal with negative
public int getSum(int a, int b) {
    int pos = 1;
    int sum = 0;
    int carry = 0;
    for (int i = 1; i < Integer.SIZE; i++){
        int pa = a & pos;
        int pb = b & pos;
        sum = sum | (pa ^ pb ^ carry);
        carry = ((pa & pb) | ((pa ^ pb) & carry)) << 1;
        pos = pos << 1;
    }
    return sum;
}


public int getSum(int a, int b) {
    return (a&b) == 0 ? a^b : getSum(a^b, ((a&b)<<1));
}

/*
Test case
20
30
-30
-20
*/

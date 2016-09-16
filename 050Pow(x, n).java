/*
50. Pow(x, n)

Implement pow(x, n).
*/

// Original idea is to increase in power. But this still get tle.
public double myPow(double x, int n) {
    int isPos = 1;
    if (x < 0 && n % 2 == 1) {
        isPos = -1;
    }
    if (x == 0) {
        return 0;
    }
    x = Math.abs(x);
    if (n < 0) {
        return isPos * myPowHelper(1/x, -n);
    }
    else {
        return isPos * myPowHelper(x, n);
    }
}

private double myPowHelper(double x, int n){
    // Find the biggest 2^k smaller than n
    if (n == 0) {
        return 1;
    }
    if (n == 1) {
        return x;
    }
    int pow2 = 2;
    double res = x * x;
    while (pow2 * pow2 < n) {
        pow2 = pow2 * 2;
        res = res * res;
    }
    return res * myPowHelper(x, n - pow2);
}

// Divide by 2 and deal with min
public double myPow(double x, int n) {
    if (x == 0) {
        return 0;
    }
    if (n == 0) {
        return 1;
    }
    if (n == 1) {
        return x;
    }
    if (n < 0) {
        // Deal with n = Integer.MIN_VALUE
        return 1/x * myPow(1/x, -(n+1));
    }
    double res = myPow(x, n/2);
    return n % 2 == 0 ? res * res : res * res * x;
}

/* Test case
10
-2147483648
10
2147483647
*/
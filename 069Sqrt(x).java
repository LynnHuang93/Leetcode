/*
69. Sqrt(x)

Implement int sqrt(int x).

Compute and return the square root of x.
*/


public int mySqrt(int x) {
    if (x <= 1) {
        return x;
    }
    int start = 1;
    int end = x ;
    int medium = start + (end - start) / 2;
    while (start <= end) {
        if (medium <= x / medium) {
            if (medium + 1 > x / (medium + 1)) {
                return medium;
            }
            start = medium + 1;
        }
        else {
            end = medium - 1;
        }
        medium = start + (end - start) / 2;
    }
    return 0;
}

/* Test case
2
4
*/
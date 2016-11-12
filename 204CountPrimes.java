/*
204. Count Primes
Description:

Count the number of prime numbers less than a non-negative number, n.
*/

public class Solution {
	// check each prime to see if it is a prime number
	// TLE: 499979
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        List<Integer> prime = new ArrayList<>();
        prime.add(2);
        for (int i = 3; i < n; i=i+2 ) {
            boolean isPrime = true;
            for (int j : prime) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                prime.add(i);
            }
        }
        return prime.size();
    }

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (notPrime[i]) {
                continue;
            }
            count++;
            // Ever find a prime, set all it times as true
            for (int j = i; j < n; j += i) {
                notPrime[j] = true;
            }
        }
        return count;
    }
}

/* Test case
499979
*/
/*
278. First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/

// Simple binary search & overflow
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        long start = 1;
        long end = n;
        long mid = (start + end) / 2;
        while (start <= end) {
            mid = (start + end) / 2;
            if (isBadVersion(Math.toIntExact(mid)) && ! isBadVersion(Math.toIntExact(mid) - 1)) {
                return Math.toIntExact(mid);
            }
            if (isBadVersion(Math.toIntExact(mid))) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return Math.toIntExact(start);
    }
}
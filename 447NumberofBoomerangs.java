/*
447. Number of Boomerangs

Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/

public int numberOfBoomerangs(int[][] points) {
    int pointNum = points.length;
    int result = 0;
    for (int i = 0; i < pointNum; i++) {
        Map<Integer, Integer> dis = new HashMap<>();
        for (int j = 0; j < pointNum; j++) {
            int sq = (points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
            if (dis.containsKey(sq)) {
                dis.put(sq, dis.get(sq)+1);
            }
            else {
                dis.put(sq, 1);
            }
        }
        for (Integer n : dis.values()) {
            result += (n-1)*n;
        }
    }
    return result;
}

/* Test case
[[0,0],[1,0],[2,0],[3,0],[-1,0],[0,1],[1,1]]
*/
/*
406. Queue Reconstruction by Height 

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort by h acs, k decs
        // Lower h have higher priority because higher h do not care about them
        // and could be placed anywhere left.
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0]? p2[1] - p1[1] : p1[0] - p2[0]);
        int[] placeHolder = new int[people.length];
        int[][] result = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            int idxOfRest = people[i][1];
            for (int j = 0; j < people.length; j++) {
                if (placeHolder[j] == 1) {
                    continue;
                }
                else {
                    if (idxOfRest == 0) {
                        placeHolder[j] = 1;
                        result[j][0] = people[i][0];
                        result[j][1] = people[i][1];
                        break;
                    }
                    else {
                        idxOfRest--;
                    }
                }
            }
        }
        return result;
    }
}

/* Test case
[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
*/
/*
347. Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequency = new HashMap<>();
        for (int num : nums){
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            }
            else {
                frequency.put(num, 1);
            }
        }
        int[][] res = new int[frequency.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry:frequency.entrySet()) {
            res[idx][0] = entry.getKey();
            res[idx][1] = entry.getValue();
            idx++;
        }
        Arrays.sort(res, (p1,p2) -> p2[1] - p1[1]);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(res[i][0]);
        }
        return result;
    }
}

/* Test case
[1,1,1,2,2,3,3]
2
*/
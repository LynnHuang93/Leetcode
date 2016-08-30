/*
11. Container With Most Water
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

// Do loop. O(n^2)
public static int maxArea(int[] height) {
    int length = height.length;
    if (length < 2) {
        return 0;
    }
    int maxVolume = calculateArea(height, 0, length-1);
    for (int i = 0; i < length - 1; i++) {
        for (int j = i + 1; j < length; j++) {
            maxVolume = Math.max(maxVolume, calculateArea(height, i, j));
        }
    }
    return maxVolume;
}
public static int calculateArea(int[] height, int index1, int index2) {
    return (index2 - index1) * Math.min(height[index1], height[index2]);
}

// Since only the shorter bar and the distance counts, only move the shorter bar.
public static int maxArea(int[] height) {
    int maxA = 0;
    for (int i = 0, j = height.length - 1; i < j;) {
        maxA = Math.max(maxA, Math.min(height[i], height[j]) * (j - i));
        if (height[i] < height[j]) {
            i++;
        }
        else{
            j--;
        }
    }
    return maxA;
}

// Test method
public static void main(String[] args) {
	int[] height = {2,2,1};
	System.out.println(maxArea(height));
}	
/*
4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
Company Tags: Google Zenefits Microsoft Apple Yahoo Dropbox Adobe
*/

// Since the time complexity is O(log(m+n)), think about binary search.
// Use find Kth element in 2 lists
// Basic idea is to eliminate the part bigger than bigger medium, or smaller than smaller medium.
// Be careful about the corner case: divide and conquer requires mid to change every time to avoid endless loop
// Here use a trickey solution to eliminate mid.
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null|| nums2 == null) {
            return 0;
        }
        int m = nums1.length, n = nums2.length;
        int length = (nums1.length + nums2.length);
        if (length % 2 ==0) {
        	// Even: find index = length/2-1 and index = length/2. eg. [0,1,2,3] find index = 4/2-1=1 and index = 4/2=2
            return (findKthElement(nums1, 0, m-1, nums2, 0, n-1,length/2-1) + findKthElement(nums1,0,m-1, nums2, 0, n-1,length/2))/2.0;
        }
        else {
            return findKthElement(nums1, 0, m-1, nums2, 0, n-1, length/2);
        }
    }
  
    public int findKthElement(int[] l1,int start1, int end1, int[] l2, int start2, int end2, int k) {
        if (end1-start1+1 == 0) {
        	// k is index so add directly
            return l2[start2+k];
        }
        if (end2-start2+1 == 0) {
            return l1[start1+k];
        }
        if (k == 0) {
            return Math.min(l1[start1], l2[start2]);
        }
        int mid1 = start1+(end1-start1)/2;
        int mid2 = start2+(end2-start2)/2;
        if (l1[mid1] >= l2[mid2]) {
        	// .........,Amid1-1,] Amid1, Amid1+1
        	// ...Bmid2-1, Bmid2,] Bmid2+1
        	// Left part total:            kth and smaller:
            if (mid1-start1+mid2-start2+1 >= k+1) {
            	// Drop Amid1 and bigger
                end1 = mid1-1;
            }
            else {
            	// Drop Bmid2 and smaller(smaller than kth) and decrease k
                k = k - (mid2-start2+1);
                start2 = mid2+1;
            }
        }
        else {
        	// ...,Amid1-1, Amid1,] Amid1+1
        	// ..........,Bmid2-1,] Bmid2, Bmid2+1
       		// Left part total:            kth and smaller:
            if (mid1-start1+mid2-start2+1 >= k+1) {
            	// Drop Bmid2 and bigger
                end2 = mid2-1;
            }
            else {
            	// Drop Amid1 and smaller(smaller than kth) and decrease k
                k = k - (mid1-start1+1);
                start1 = mid1+1;
            }
        }
        return (findKthElement(l1, start1, end1, l2, start2, end2, k));
    }

    //Test method
    /*
    public static void main(String[] args) {
    	int[] list1 = {1, 2, 3};
    	int[] list2 = {5, 6, 7, 8, 9};
    	double result = findMedianSortedArrays(list1, list2);
    	System.out.print(result);
    }
  }*/
}
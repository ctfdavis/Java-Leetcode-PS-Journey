/*
Coded by DCUFO
Leetcode problem
4. Median of Two Sorted Arrays
Hard
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
*/
class Solution {
    public static int[] putInSortedOrder(int[] base, int[] addon) {
        List<Integer> baselist = Arrays.stream(base).boxed().collect(Collectors.toList());
        int counter = 0;
        process:
        for (int i = 0; i < addon.length; i++) {
            for (int j = counter; j < baselist.size(); j++) {
                counter++;
                if (addon[i] <= baselist.get(j)) {
                    baselist.add(j, addon[i]);
                    continue process;
                }
            }
            baselist.add(addon[i]);
        }
        return baselist.stream().mapToInt(i -> i).toArray();
    }
    
    public static double findMedian(int[] sorted) {
        int size = sorted.length;
        if (size % 2 == 0) {
            return (sorted[size/2] + sorted[size/2 - 1]) / 2.0;
        } else {
            return (sorted[size/2]);
        }
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] newNums;
        if (m == 0) return findMedian(nums2);
        if (n == 0) return findMedian(nums1);
        
        if (m >= n) {
            newNums = putInSortedOrder(nums1, nums2);
        } else {
            newNums = putInSortedOrder(nums2, nums1);
        }
        
        return findMedian(newNums);
    }
}
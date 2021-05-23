/*
Coded by DCUFO
Leetcode problem
27. Remove Element
Easy
Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        int excluded = 0;
        for (int i = 0; i < nums.length - excluded; i++) {
            if (nums[i] != val) length++;
            else {
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j+1];
                }
                i--;
                excluded++;
            }
        }
        return length;
    }
}
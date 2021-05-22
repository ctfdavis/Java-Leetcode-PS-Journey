/*
Coded by DCUFO
Leetcode problem
26. Remove Duplicates from Sorted Array
Easy
Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
Constraints:
0 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in ascending order.
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int toReturn = 1;
        int repeated = 0;
        for (int i = 0; i < nums.length -1; i++) {
            try {
                if (nums[i+repeated] != nums[i+repeated+1]) {
                    nums[i+1] = nums[i+repeated+1];
                    toReturn++;
                }
                else {
                    try {
                        for (int j = i+repeated+1; j < nums.length - 1; j++) {
                            if(nums[i+repeated] != nums[j+1]) {
                                nums[i+1] = nums[j+1];
                                repeated += (j-i-repeated);
                                toReturn++;
                                break;
                            }
                        }
                    } catch (Exception f) {
                        break;
                    }
                }
            } catch (Exception e) {
                break;
            }
            
        }
        return toReturn;
    }
}
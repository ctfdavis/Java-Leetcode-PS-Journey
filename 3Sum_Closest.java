/*
Coded by DCUFO
Leetcode problem
16. 3Sum Closest
Medium
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
Constraints:
3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2]; 
        Arrays.sort(nums);        
        for (int i = 0; i < nums.length - 2; i++) {
            int currCore = nums[i] - target;
            int x = i+1;
            int y = nums.length-1;
	//using two-pointer technique~
            while (x!=y) {
                if (Math.abs(nums[i] + nums[x] + nums[y] - target) < Math.abs(result - target)) {
                    result = nums[i] + nums[x] + nums[y];
                }
                if (currCore + nums[x] + nums[y] == 0) {
                    return target;
                }
                else if (currCore + nums[x] + nums[y] < 0) {
                    x++;
                } 
                else {
                    y--;
                }

            }
        }
        return result;
    }
}
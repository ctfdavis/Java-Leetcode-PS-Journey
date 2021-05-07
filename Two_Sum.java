/*
Coded by DCUFO
Leetcode problem
1. Two Sum
Easy
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        var solution = new int[2];
        for (var i = 0; i < nums.length -1; i++) {
            for (var j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j])
                    solution = new int[]{i, j};
            }
        }
        return solution;
    }
}
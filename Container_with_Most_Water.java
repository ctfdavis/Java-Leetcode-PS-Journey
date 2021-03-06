/**
Coded by DCUFO
Leetcode problem
11. Container With Most Water
Medium
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.
 */
class Solution {
    public int maxArea(int[] height) {
        int currMaxH = 0;
        int currMaxA = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > currMaxH) {
                currMaxH = height[i];
                for (int j = i+1 ; j < height.length; j++) {
                    currMaxA = Math.max(currMaxA, Math.min(currMaxH, height[j]) * (j-i));
                }
            } else {
                continue;
            }
        }
        return currMaxA;
    }
}
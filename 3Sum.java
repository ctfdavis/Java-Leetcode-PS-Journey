/*
Coded by DCUFO
Leetcode problem
15. 3Sum
Medium
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
Constraints:
0 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        int numZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0) negative.add(nums[i]);
            else if (nums[i]>0) positive.add(nums[i]);
            else if (nums[i]==0 && numZero <3) numZero++;
        }
        Collections.sort(negative);
        Collections.sort(positive);
        HashSet<List<Integer>> used = new HashSet<>();
        Set<Integer> positiveSet = new HashSet<>(positive);
        for (int i = 0; i < negative.size(); i++) {
            for (int j = i+1; j < negative.size(); j++) {
                if (!used.add(Arrays.asList(negative.get(i),negative.get(j))))
                    continue;
                if (positiveSet.contains(Math.abs(negative.get(i)+negative.get(j))))
                    result.add(Arrays.asList(negative.get(i), negative.get(j), Math.abs(negative.get(i)+negative.get(j))));
            }
        }
        used = new HashSet<>();
        Set<Integer> negativeSet = new HashSet<>(negative);
        for (int i = 0; i < positive.size(); i++) {
            for (int j = i+1; j < positive.size(); j++) {
                if (!used.add(Arrays.asList(positive.get(i),positive.get(j))))
                    continue;
                if (negativeSet.contains(-(positive.get(i)+positive.get(j))))
                    result.add(Arrays.asList(-(positive.get(i)+positive.get(j)),positive.get(i),positive.get(j)));
            }
        }
        if (numZero > 0) {
            for (Integer i : positiveSet) {
                if (negativeSet.contains(-i))
                    result.add(Arrays.asList(-i,0,i));
            }
            if (numZero == 3) {
                result.add(Arrays.asList(0,0,0));
            }
        }
        return result;
    }
}
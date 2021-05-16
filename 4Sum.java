/*
Coded by DCUFO
Leetcode problem
18. Letter Combinations of a Phone Number
Medium
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Constraints:
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        HashSet<List<Integer>> hset = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        
        boolean prev = false;
        boolean isSmaller = false;
        boolean isBigger = false;
        
        Arrays.sort(nums);
        if (nums.length >=4) {
            while (nums.length >= 4) {
                /* left-to-right loop */
                for (int i = 0; i < nums.length-3; i++) {
                    int j = i+1;
                    int k = nums.length-2;
                    int l = nums.length-1;
                    while(j<k) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] < target)
                            j++;
                        else if (nums[i] + nums[j] + nums[k] + nums[l] > target)
                            k--;
                        else {
                            hset.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            j++;
                            k--;
                        }
                    }
                }

                /* right-to-left loop */
                for (int l = nums.length-1; l > 2; l--) {
                    int k = l-1;
                    int j = 1;
                    int i = 0;
                    while(j<k) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] < target)
                            j++;
                        else if (nums[i] + nums[j] + nums[k] + nums[l] > target)
                            k--;
                        else {
                            hset.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            j++;
                            k--;
                        }
                    }
                }
                
                nums = Arrays.copyOfRange(nums, 1, nums.length-1);
            }
            
            /* finally */
            result = new ArrayList<List<Integer>>(hset);
            return result;
        }
        return result;
    }
}
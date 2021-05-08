/*
Coded by DCUFO
Leetcode problem
3. Longest Substring Without Repeating Characters
Medium
Given a string s, find the length of the longest substring without repeating characters.
Runtime: 117 ms
Memory Usage: 39.5 MB
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int output = s.length() > 0 ? 1 : 0;
            for (int i = 0; i < s.length() - 1; i++) {
                Set set = new HashSet();
                set.add(s.charAt(i));
                if (output >= s.length() - i) break;
                for (int j = i + 1; j < s.length(); j++) {
                    if (set.contains(s.charAt(j))) {
                        if (j - i > output) output = j - i;
                        break;
                    } else if (j == s.length() -1) {
                        if (s.length() - i > output) output = s.length() - i;
                        break;
                    }
                    set.add(s.charAt(j));
                }
            }
        return output;
    }
}
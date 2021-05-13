/*
Coded by DCUFO
Leetcode problem
14. Longest Common Prefix
Easy
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        // sort the strs array in ascending order of the string length
        Arrays.sort(strs, (a, b)->Integer.compare(a.length(), b.length()));
        outer:
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) break outer;
            }
            prefix += strs[0].charAt(i);
        }
        return prefix;
    }
}
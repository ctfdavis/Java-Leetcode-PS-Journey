/*
Coded by DCUFO
Leetcode problem
28. Implement strStr()
Easy
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
Constraints:
0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
*/
class Solution {
    public int strStr(String haystack, String needle) {
        /*purpose: implement the indexOf() String method in Java*/
        // return haystack.indexOf(needle);
        
        int lenNee = needle.length();
        if (lenNee == 0) return 0;
        
        for (int i = 0; i <= haystack.length()-lenNee; i++) {
            if (haystack.substring(i,i+lenNee).equals(needle)) return i;
        }
        
        return -1;
    }
}
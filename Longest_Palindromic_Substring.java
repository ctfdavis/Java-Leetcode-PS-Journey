/*
Coded by DCUFO
Leetcode problem
5. Longest Palindromic Substring
Medium
Given a string s, return the longest palindromic substring in s.
*/

class Solution {
    public static boolean isPalindrome(String x) {
        for (int i = 0; i < x.length() / 2; i++) {
            if (x.charAt(i) != x.charAt(x.length()-i-1)) return false;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            if (output.length() >= s.length() - i) break;
            for (int j = i+1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j)) && j-i > output.length()) {
                    output = s.substring(i,j);
                }
            }
        }
        return output;
    }
}
/*
Coded by DCUFO
Leetcode problem
9. Palindrome Number
Easy
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
*/
import java.lang.Math;
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;
        int number_of_digits = 2;
        int y = x / 100;
        while (y!=0) {
            y = y /10;
            number_of_digits++;
        }
        int prevTrailingNum = 0;
        int prevLeadingNum = 0;
        for (int i = 1; i <= number_of_digits/2; i++) {
            int currTrailingNum = x % (int) (Math.pow(10,i));
            int currLeadingNum = x / (int) (Math.pow(10, (number_of_digits - i)));
            if ((currTrailingNum - prevTrailingNum) / (int) (Math.pow(10,i-1)) != (currLeadingNum - prevLeadingNum * 10)) 
                return false;         
            prevTrailingNum = currTrailingNum;
            prevLeadingNum = currLeadingNum;
        }
        return true;
    }
}
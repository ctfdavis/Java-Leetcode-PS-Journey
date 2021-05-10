/*
Coded by DCUFO
Leetcode problem
8. String to Integer (atoi)
Medium
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
*/
import java.math.BigInteger;

class Solution {
    String max = String.valueOf(Integer.MAX_VALUE);
    String min = String.valueOf(Integer.MIN_VALUE);
    BigInteger b_max = new BigInteger(max);
    BigInteger b_min = new BigInteger(min);
    
    public int myAtoi(String s) {
        int result = 0; // default the result to 0
        boolean negative = false;     
        // removes leading spaces and checking sign
        int lastLeadingSpaceIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) != 32) {
                if (s.charAt(i) == '-') negative = true; // check if negative
                lastLeadingSpaceIndex = i;
                if (negative || s.charAt(i) == '+')
                    lastLeadingSpaceIndex = i + 1;
                break;
            }
        }
        
        s = s.substring(lastLeadingSpaceIndex);
            
        // default the index of the last digit in s to its length
        int lastDigitIndex = s.length(); 
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) > 57 || (int) s.charAt(i) < 48) {
                lastDigitIndex = i;
                break;
            }
        }
        
        if (lastDigitIndex > 0) {
             BigInteger b1 = new BigInteger(s.substring(0,lastDigitIndex));
             if (negative) {
                 if (b1.negate().compareTo(b_min) < 0) return (int) Integer.MIN_VALUE;
             } else {
                 if (b1.compareTo(b_max) > 0) return (int) Integer.MAX_VALUE;
             }
             
             result = negative ? - b1.intValue() : b1.intValue();
        }

        return result;
    }
}
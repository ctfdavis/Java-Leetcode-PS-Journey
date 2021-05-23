/*
Coded by DCUFO
Leetcode problem
29. Divide Two Integers
Medium

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
Constraints:
-231 <= dividend, divisor <= 231 - 1
divisor != 0
*/
class Solution {
    public int divide(int dividend, int divisor) {
        /* without using multiplication, division and mod */
        int toReturn = 0;
        boolean negative = false;
        boolean specialCase = false;
        
        if (divisor < 0) {
            negative = !negative;
            if (divisor == Integer.MIN_VALUE) {
                if (dividend == Integer.MIN_VALUE) return 1;
                else return 0;
            }
            divisor = -divisor;
        }
        
        if (dividend < 0) {
            negative = !negative;
            if (divisor == 1) {
                if (!negative && dividend == Integer.MIN_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (negative) return dividend;
                return -dividend;
            }
            if (dividend == Integer.MIN_VALUE) {
                specialCase = true;
                dividend = Integer.MAX_VALUE;
            } else {
                dividend = -dividend;
            }
        }
        
        if (divisor == 1) {
            if (negative) return -dividend;
            else return dividend;
        }
        
        
        //using base doubling in the loop to reduce time complexity
        int divisorBase = divisor;
        int toReturnBase = 1;
        
        while (true) {
	        if (dividend >= divisorBase+divisorBase && divisorBase+divisorBase > 0) {
                divisorBase+=divisorBase;
                toReturnBase += toReturnBase;
		        dividend-=divisorBase;
		        toReturn+=toReturnBase;
	        }
	        else if (dividend >= divisorBase) {
		        dividend-=divisorBase;
		        toReturn+=toReturnBase;
	        }
	        else if (dividend >= divisor) {
		        dividend-=divisor;
		        divisorBase=divisor;
		        toReturnBase=1;
		        toReturn++;
	        }
	        else break;
        }
        
        //handling edge cases
        if (specialCase) {
            if (dividend+1 >= divisor) {
                toReturn++;
            }
        }
        
        
        if (negative) return -toReturn;
        return toReturn;
    }
}
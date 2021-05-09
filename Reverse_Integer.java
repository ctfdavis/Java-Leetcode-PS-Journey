/*
Coded by DCUFO
Leetcode problem
7. Reverse Integer
Easy
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
*/
import java.math.BigInteger;

class Solution {
    
    String max = String.valueOf(Integer.MAX_VALUE);
    String min = String.valueOf(Integer.MIN_VALUE);
    BigInteger b_max = new BigInteger(max);
    BigInteger b_min = new BigInteger(min);
    
    public int reverse(int x) {
        StringBuilder sb;
        boolean negative = false;
        if (x < 0) negative = true;
        String y = String.valueOf(x);
        if (negative)
            sb = new StringBuilder(y.substring(1));
        else
            sb = new StringBuilder(y);
        sb.reverse();
        String str = sb.toString();
        BigInteger b1 = new BigInteger(str);
        if (b1.compareTo(b_max) > 0 || b1.compareTo(b_min) < 0) return 0;
        int unsigned = Integer.parseInt(str);
        return negative ? - (unsigned) : unsigned;
    }
}